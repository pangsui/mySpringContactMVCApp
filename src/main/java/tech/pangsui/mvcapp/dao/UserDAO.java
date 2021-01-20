package tech.pangsui.mvcapp.dao;

import java.util.List;

import tech.pangsui.mvcapp.domain.User;

/**
 *
 * @author Vikram
 */
public interface UserDAO {

    public void save(User u);

    public void update(User u);

    public void delete(User u);

    public void delete(Integer userId);

    public User findById(Integer userId);

    public List<User> findAll();

    public List<User> findByProperty(String propName, Object propValue);
}
