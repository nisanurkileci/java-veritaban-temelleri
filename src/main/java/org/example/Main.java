package org.example;
import config.DataBaseConnectorConfig;
import dao.UserDAOImpl;
import dao.UserDAO;
import user.User;
import java.sql.Connection;
import java.util.List;

import static dao.UserDAOImpl.*;

public class Main {
    public static void main(String[] args) {

        DataBaseConnectorConfig.setConnection();
        Connection connection = DataBaseConnectorConfig.getConnection();

        UserDAO userDAO = new UserDAOImpl(connection);

        userDAO.createTable();

        User newuser = new User();
        newuser.setName("Nisa");
        newuser.setEmail("nn@nn.com");

        userDAO.saveUser(newuser);



        List<User> users = userDAO.findAll();
        System.out.println("Tüm Kullanıcılar");
        for(User u: users){
            System.out.println(" " + u.getId() + " " + u.getName() + " " + u.getEmail());
        }

        DataBaseConnectorConfig.closeConnection();
    }
}

