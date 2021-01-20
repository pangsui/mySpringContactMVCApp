package tech.pangsui.mvcapp.test;

import tech.pangsui.mvcapp.config.SpringRootConfig;
import tech.pangsui.mvcapp.dao.UserDAO;
import tech.pangsui.mvcapp.domain.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Vikram
 */
public class TestUserDAOSave {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u=new User();
        u.setName("Amit");
        u.setPhone("9303580884");
        u.setEmail("amit@ezeon.net");
        u.setAddress("Mumbai");
        u.setLoginName("amit");
        u.setPassword("amit123");
        u.setRole(1);//Admin Role 
        u.setLoginStatus(1); //Active
        userDAO.save(u);
        System.out.println("--------Data Saved------");
    }    
}
