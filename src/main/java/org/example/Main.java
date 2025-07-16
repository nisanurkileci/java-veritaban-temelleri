package org.example;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = config.getConnection();

        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setString(1, "Ali");
            pstmt.setString(2, "ali@mail.com");

            pstmt.executeUpdate();

            System.out.println("Kullanıcı eklendi!");

            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Hata oluştu!");
            e.printStackTrace();
        }

    }
}