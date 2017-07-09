package system.dao;

import org.springframework.stereotype.Repository;
import system.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Татьяна on 27.05.2017.
 */
@Repository
public class UserDAO {

    private List<User> users
            = Arrays.asList(new User("admin", "admin"),
            new User("user1", "user1"));

    public List<User> getAllUsers() {
        return users;
    }
}
