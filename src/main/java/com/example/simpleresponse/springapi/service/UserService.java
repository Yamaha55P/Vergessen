package com.example.simpleresponse.springapi.service;

import com.example.simpleresponse.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();

        User user1 = new User(1, "Thorsten Steinmeier", "thorstenmitborsten@gmail.com");
        User user2 = new User(2, "Andy Front", "andyfront@gmail.com");
        User user3 = new User(3, "Materia L. Girl", "materialgirl@gmail.com");
        User user4 = new User(4, "Jeremy Fragrance", "jeremyfragrance@gmail.com");

        users.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUser(int id) {
        Optional optional = Optional.empty();
        for (User user : users) {
            if (user.getId() == id) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public User addUser(User newUser) {
        newUser.setId(users.size() + 1);
        return newUser;
    }
}