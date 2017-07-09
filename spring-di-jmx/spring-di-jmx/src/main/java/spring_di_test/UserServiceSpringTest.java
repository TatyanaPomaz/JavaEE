package spring_di_test;

import org.springframework.context.*;
import org.springframework.context.support.*;
import spring_di_test.dao.*;
import spring_di_test.service.*;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class UserServiceSpringTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-context.xml");

//        UserServiceInterface userService = applicationContext.getBean("userService1", UserServiceInterface.class);
//        assert userService != null : "userService is null";
//        //System.out.println(userService);
//
//        UserServiceDAOInterface userDAO = applicationContext.getBean("userDAO", UserServiceDAOInterface.class);
//        assert userDAO != null : "userDAO is null";
//        //System.out.println(userDAO);

        UserServiceInterface userService2 = applicationContext.getBean("userService2", UserServiceInterface.class);
        System.out.println(userService2.getAllUsers());
    }
}
