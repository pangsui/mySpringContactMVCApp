package tech.pangsui.mvcapp.test;

import tech.pangsui.mvcapp.config.SpringRootConfig;
import tech.pangsui.mvcapp.dao.UserDAO;
import tech.pangsui.mvcapp.domain.User;
import tech.pangsui.mvcapp.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Vikram
 */
public class TestUserServiceRegister {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService=ctx.getBean(UserService.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u=new User();
        u.setName("Nitin");
        u.setPhone("55555555");
        u.setEmail("nitin@ezeon.net");
        u.setAddress("Mumbai");
        u.setLoginName("nitin");
        u.setPassword("nitin123");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(u);
        System.out.println("--------User Registered Successfully------");
    }    
}
