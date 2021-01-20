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
public class TestUserDAODelete {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        userDAO.delete(2);
        System.out.println("--------Data Deleted------");
    }    
}
