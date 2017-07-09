package com.backbone.user.test.controller;

import com.backbone.user.test.entity.User;
import com.backbone.user.test.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/rest/users")
public class UserController {
    @Inject
    protected UserRepository userRepository;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    boolean deleteUser(@PathVariable("id") Integer id) {
        userRepository.delete(id);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    User delete(@PathVariable("id") Integer id)
{
        userRepository.delete(id);
        userRepository.flush();
        return new User();
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    User findById(@PathVariable("id") Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public
    @ResponseBody
    User create(@RequestBody User user) {
        userRepository.saveAndFlush(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public
    @ResponseBody
    User update(@RequestBody User user) {
        userRepository.saveAndFlush(user);
        return user;
     }

}
