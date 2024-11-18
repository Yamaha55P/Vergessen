package com.example.simpleresponse.springapi.api.controller;

import com.example.simpleresponse.springapi.api.model.User;
import com.example.simpleresponse.springapi.service.UserService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        Optional user = userService.getUser(id);
        if (user.isPresent()) {
            return (User) user.get();
        }
        return null;
    }

    @PostMapping("/user/add")
        public User addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }


}
