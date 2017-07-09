package spring_di_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_di_test.dao.UserServiceDAOInterface;
import spring_di_test.service.UserServiceInterface;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class UserServiceSpringAnnotationTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-context-annotation.xml");

        UserServiceInterface userService = applicationContext.getBean("userService", UserServiceInterface.class);
        assert userService != null : "userService is null";
        //System.out.println(userService);

        UserServiceDAOInterface userDAO = applicationContext.getBean("userDAO", UserServiceDAOInterface.class);
        assert userDAO != null : "userDAO is null";
        //System.out.println(userDAO);

        System.out.println(userService.getAllUsers());

    }
}
