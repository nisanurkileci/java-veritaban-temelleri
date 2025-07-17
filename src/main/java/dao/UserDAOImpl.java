package dao;

import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private final Connection connection;

    public UserDAOImpl(Connection connection){
        this.connection=connection;
    }

    @Override
    public void createTable() {
        String sql= "CREATE TABLE IF NOT EXISTS users(" + "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";

        try(Statement statement=connection.createStatement()){
            statement.execute(sql);
            System.out.println("Tablo oluşturuldu.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser() {

    }

    @Override
    public void saveUser(User user) {
        String sql = " INSERT INTO users(name,email) VALUES(?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
           preparedStatement.setString(1, user.getName());
           preparedStatement.setString(2, user.getEmail());
           preparedStatement.executeUpdate();
            System.out.println("Veri oluşturuldu");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}




