package com.epam.hackathon.controller;

import com.epam.hackathon.entity.User;
import com.epam.hackathon.entity.UserRole;
import com.epam.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @RequestMapping("/get")
    public User get(@RequestParam(value = "email") String name) {
        System.out.println("name -> " + name);
        return userService.findByEmail(name);
    }

    @RequestMapping("/auth")
    public boolean authenticate(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password) {

        return userService.authenticate(email, password);
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public User addUser(@RequestParam(value = "name") String name,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "password") String password) {

        UserRole role = new UserRole(2L);

        User user = new User(name, email, password);
        user.setRole(role);

        userService.add(user);

        return user;
    }

    @RequestMapping("/login")
    public User loginUser(@RequestParam(value = "email") String email,
                          @RequestParam(value = "password") String password) {
        return userService.login(email, password);
    }
}
