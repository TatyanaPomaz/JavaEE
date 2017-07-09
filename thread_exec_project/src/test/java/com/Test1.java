package com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by User on 02.07.2017.
 */
public class Test1 {
    @Test
    public void test_1() {
        assertEquals(true, true);
    }

    @Test
    public void testList() {
        List numbers = new ArrayList(Arrays.asList(1, 2, 4, 5, 7));
        //System.out.println(numbers.get(100));
        List mockList = mock(numbers.getClass());
        when(mockList.get(100)).thenReturn(-1);
        Object o = mockList.get(100);

        assertEquals(-1, o);
        System.out.println(mockList.get(1));
    }

    @Test
    public void testListSpy() {
        List numbers = new ArrayList(Arrays.asList(1, 2, 4, 5, 7));
        List spyList = spy(numbers);

        assertEquals(5, spyList.size());
        assertEquals(spyList.get(0), 1);
        when(spyList.get(100)).thenReturn(null);
        assertEquals(spyList.get(100), null);
    }

    @Test
    public void testUserService() {
        UserDAO userDAO = mock(UserDAO.class);
        UserService userService = new UserService();
        UserService spy = spy(userService);
        //spy.setUserDAO(userDAO);
        when(spy.getUserDAO()).thenReturn(userDAO);
        when(userDAO.sendMessage()).thenReturn("ku ku");
        boolean sendMessageStatus = spy.sendMessage();
        assertEquals(true, sendMessageStatus);
    }
}

interface UserDAO {
    String sendMessage();
}

class UserService {
    private UserDAO userDAO;

    public UserService() {
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public boolean sendMessage() {
        try {
            String s = getUserDAO().sendMessage();
            System.out.println(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}