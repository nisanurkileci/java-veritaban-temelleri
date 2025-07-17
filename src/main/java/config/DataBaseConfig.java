package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConfig {

    public static final String URL = "jdbc:postgresql://localhost:5432/java-veritaban-temelleri";
    public static final String NAME = "java-veritaban-temelleri";
    public static final String USER = "postgres";
    public static final String PASSWORD = "1";


}
