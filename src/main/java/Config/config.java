package Config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class config {

    private static final String URL = "jdbc:postgresql://localhost:5432/java-veritaban-temelleri";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";


    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println("Bağlantı hatası!");
            e.printStackTrace();
        }
        return conn;
    }
}
