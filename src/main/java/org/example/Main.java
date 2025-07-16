package org.example;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Connection conn = config.getConnection();

        String sql = "SELECT * FROM users";

        try {
            PreparedStatement pstatment = conn.prepareStatement(sql);

            ResultSet rs = pstatment.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("ID: " + id + ", İsim: " + name + ", Email: " + email);
            }

            rs.close();
            pstatment.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Hata oluştu!");
            e.printStackTrace();
        }
    }
}


//JA-5
/* try {

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
*/