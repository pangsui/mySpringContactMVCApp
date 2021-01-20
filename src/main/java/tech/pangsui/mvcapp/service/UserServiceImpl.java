package tech.pangsui.mvcapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tech.pangsui.mvcapp.dao.BaseDAO;
import tech.pangsui.mvcapp.dao.UserDAO;
import tech.pangsui.mvcapp.domain.User;
import tech.pangsui.mvcapp.exception.UserBlockedException;
import tech.pangsui.mvcapp.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void register(User u) {
		userDAO.save(u);
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT iduser, name, phone, email, address, role, loginStatus, loginName"
				+ " FROM user WHERE loginName=:ln AND password=:pw";
		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);
		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
			} else {
				return u;
			}
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer iduser, Integer loginStatus) {
		String sql = "UPDATE user SET loginStatus=:lst WHERE iduser=:uid";
		Map m = new HashMap();
		m.put("uid", iduser);
		m.put("lst", loginStatus);
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public Boolean isUsernameExist(String username) {
		String sql = "SELECT count(loginName) FROM user WHERE loginName=?";
		Integer count = getJdbcTemplate().queryForObject(sql, new String[] { username }, Integer.class);
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}
}
