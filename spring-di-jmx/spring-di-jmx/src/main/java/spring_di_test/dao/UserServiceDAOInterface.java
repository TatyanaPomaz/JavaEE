package spring_di_test.dao;

import spring_di_test.models.User;

import java.util.List;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public interface UserServiceDAOInterface {
    List<User> getAllUsers();
}
