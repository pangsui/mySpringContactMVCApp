package tech.pangsui.mvcapp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import tech.pangsui.mvcapp.domain.User;
/**
 *
 * @author Vikram
 */
public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u=new User();
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setEmail(rs.getString("email"));
        u.setAddress(rs.getString("address"));
        u.setLoginName(rs.getString("loginName"));
        u.setRole(rs.getInt("role"));
        u.setLoginStatus(rs.getInt("loginStatus"));
        return u;
    }    
}
