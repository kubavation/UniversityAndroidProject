package com.example.hotelapp.service;

import com.example.hotelapp.model.User;

public class AuthService {

    public static User loggedIn = null;

    public static void registerUser(User user) {
        UserService.addUserIfNotExists(user);
    }


}
