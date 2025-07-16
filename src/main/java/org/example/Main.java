package org.example;

import Config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = config.getConnection();

        try {
            // Güncelleme sorgusu
            String sql = "UPDATE users SET name = ? WHERE id = ?";
            PreparedStatement ustatement = conn.prepareStatement(sql);

            ustatement.setString(1, "ad");
            ustatement.setInt(2, 1);

            int uCount = ustatement.executeUpdate();
            System.out.println("Güncellenen satır sayısı: " + uCount);

            ustatement.close();

            // Silme sorgusu
            String dsql = "DELETE FROM users WHERE id = ?";
            PreparedStatement dstatement = conn.prepareStatement(dsql);

            dstatement.setInt(1, 2);

            int dCount = dstatement.executeUpdate(); // 💡 Düzeltme burada!
            System.out.println("Silinen satır sayısı: " + dCount);

            dstatement.close();

            conn.close();

        } catch (SQLException e) {
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

 //JA-6

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

*/
