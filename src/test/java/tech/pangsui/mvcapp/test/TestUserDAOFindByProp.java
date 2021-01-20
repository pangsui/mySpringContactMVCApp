package tech.pangsui.mvcapp.test;

import tech.pangsui.mvcapp.config.SpringRootConfig;
import tech.pangsui.mvcapp.dao.UserDAO;
import tech.pangsui.mvcapp.domain.User;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Vikram
 */
public class TestUserDAOFindByProp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);   
        
        //List<User> users = userDAO.findByProperty("userId", 1);
        //List<User> users = userDAO.findByProperty("name", "Vikram");
        List<User> users = userDAO.findByProperty("role", 2);
        for (User u : users) {
             System.out.println(u.getUserId()+" "+u.getName()+" "+u.getRole());
             //TODO: access other columns
        }
        
    }    
}
