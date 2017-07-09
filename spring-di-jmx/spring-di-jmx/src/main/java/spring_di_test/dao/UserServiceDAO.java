package spring_di_test.dao;

import spring_di_test.models.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class UserServiceDAO implements UserServiceDAOInterface{

    private List<User> userList = Arrays.asList(new User("xxx", 12),
            new User("yyy", 13));

    public List<User> getAllUsers() {
        return userList;
    }
}
