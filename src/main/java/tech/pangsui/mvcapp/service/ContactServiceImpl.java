package tech.pangsui.mvcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.pangsui.mvcapp.dao.BaseDAO;
import tech.pangsui.mvcapp.dao.ContactDAO;
import tech.pangsui.mvcapp.domain.Contact;
import tech.pangsui.mvcapp.rm.ContactRowMapper;
import tech.pangsui.mvcapp.util.StringUtil;

/**
 *
 * @author Vikram
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	@Override
	public void save(Contact c) {
		contactDAO.save(c);
	}

	@Override
	public void update(Contact c) {
		contactDAO.update(c);
	}

	@Override
	public void delete(Integer cotactId) {
		contactDAO.delete(cotactId);
	}

	@Override
	public void delete(Integer[] cotactIds) {
		String ids = StringUtil.toCommaSeparatedString(cotactIds);
		String sql = "DELETE FROM contact WHERE contactId IN(" + ids + ")";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer iduser) {
		return contactDAO.findByProperty("iduser", iduser);
	}

	@Override
	public List<Contact> findUserContact(Integer iduser, String txt) {
		String sql = "SELECT contactId, iduser, name, phone, email, address, remark FROM contact WHERE iduser=? AND (name LIKE '%"
				+ txt + "%' OR address LIKE '%" + txt + "%' OR phone LIKE '%" + txt + "%' OR email LIKE '%" + txt
				+ "%' OR remark LIKE '%" + txt + "%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), iduser);
	}

	@Override
	public Contact findById(Integer cotactId) {
		return contactDAO.findById(cotactId);
	}

}
