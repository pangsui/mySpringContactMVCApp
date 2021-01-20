package tech.pangsui.mvcapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import tech.pangsui.mvcapp.domain.User;
import tech.pangsui.mvcapp.rm.UserRowMapper;

/**
 *
 * @author Vikram
 */
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void save(User u) {
		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
				+ " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());

		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer iduser = kh.getKey().intValue();
		u.setUserId(iduser);
	}

	@Override
	public void update(User u) {
		String sql = "UPDATE user " + " SET name=:name," + " phone=:phone, " + " email=:email," + " address=:address,"
				+ " role=:role," + " loginStatus=:loginStatus " + " WHERE iduser=:iduser";
		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("iduser", u.getUserId());
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public void delete(User u) {
		this.delete(u.getUserId());
	}

	@Override
	public void delete(Integer iduser) {
		String sql = "DELETE FROM user WHERE iduser=?";
		getJdbcTemplate().update(sql, iduser);
	}

	@Override
	public User findById(Integer iduser) {
		String sql = "SELECT iduser, name, phone, email, address, loginName, role, loginStatus"
				+ " FROM user WHERE iduser=?";
		User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), iduser);
		return u;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT iduser, name, phone, email, address, loginName, role, loginStatus" + " FROM user";
		/*
		 * List<User> users = getJdbcTemplate().query(sql, new UserRowMapper()); return
		 * users;
		 */
		return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		String sql = "SELECT iduser, name, phone, email, address, loginName, role, loginStatus" + " FROM user WHERE "
				+ propName + "=?";
		return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
	}

}
