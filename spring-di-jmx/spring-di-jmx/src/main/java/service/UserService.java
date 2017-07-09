package service;

import domain.User;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class UserService implements IUserService {
    private User originalUser = new User();
    private User cloneUser;

    public void cloneUser() throws CloneNotSupportedException {
        cloneUser = (User) originalUser.clone();
    }


    public String printCloneUser() {
        return cloneUser == null ? "Clone is absent." : cloneUser.toString();
    }

}
