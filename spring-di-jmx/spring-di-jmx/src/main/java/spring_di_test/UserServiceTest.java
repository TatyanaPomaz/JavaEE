package spring_di_test;

import spring_di_test.service.UserService;
import spring_di_test.service.UserServiceInterface;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class UserServiceTest {
    public static void main(String[] args) {
        UserServiceInterface userServiceInterface =
                new UserService();
        System.out.println(userServiceInterface.getAllUsers());
    }
}
