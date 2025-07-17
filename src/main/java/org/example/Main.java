package org.example;
import config.DataBaseConfig;
import config.DataBaseConnectorConfig;
import dao.UserDAOImpl;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        DataBaseConnectorConfig.setConnection();
        Connection connection = DataBaseConnectorConfig.getConnection();
        UserDAOImpl userDAO = new UserDAOImpl(connection);


    }
}

