package org.example;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();

        // 1) CREATE
        User user = new User();
        user.setName("Nisa Nur");
        user.setEmail("nisa@nur.com");
        userDAO.createUser(user);

        // 2) READ
        User dbUser = userDAO.getUserById(user.getId());
        System.out.println("DB'den geldi: " + dbUser.getName());

        // 3) UPDATE
        dbUser.setEmail("mm@nur.com");
        userDAO.updateUser(dbUser);

        // 4) DELETE
        userDAO.deleteUser(dbUser);
    }
}
