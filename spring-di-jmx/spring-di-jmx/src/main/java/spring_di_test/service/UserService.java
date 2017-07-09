package spring_di_test.service;

import spring_di_test.dao.UserServiceDAO;
import spring_di_test.dao.UserServiceDAOInterface;
import spring_di_test.models.User;

import java.util.List;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class UserService implements UserServiceInterface{
    private UserServiceDAOInterface userServiceDAO =
            new UserServiceDAO();

    public List<User> getAllUsers() {
        return userServiceDAO.getAllUsers();
    }
}
