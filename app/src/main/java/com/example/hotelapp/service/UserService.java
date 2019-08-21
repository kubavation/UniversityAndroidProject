package com.example.hotelapp.service;

import com.example.hotelapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("test","test"));
    }

    public static void addUserIfNotExists(User user) {
        if(isUsernameExists(user)) {
            throw new RuntimeException("This username is already taken");
        }
        users.add(user);
    }

    public static boolean isUserExists(User user) {
        return users.contains(user);
    }

    private static boolean isUsernameExists(User user) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()))
                return true;
        }
        return false;
    }

    public static List<User> getUsers() {
        return users;
    }

    private UserService() {}
}
