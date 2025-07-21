package org.example;

import model.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();


        User user = new User();
        user.setName("Nisa Nur");
        user.setEmail("nn@n.com");
        userService.createUser(user);


        userService.getAllUsers().forEach(u ->
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail())
        );
    }
}
