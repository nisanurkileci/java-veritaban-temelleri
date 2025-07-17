package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnectorConfig {

    public static Connection connection;

    public static void setConnection(){
        try{
            connection = DriverManager.getConnection(DataBaseConfig.URL, DataBaseConfig.USER, DataBaseConfig.PASSWORD);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void  closeConnection(){
        try{
            connection.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
