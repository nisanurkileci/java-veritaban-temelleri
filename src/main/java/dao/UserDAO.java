package dao;

import user.User;

import java.util.List;

public interface UserDAO {
 void createTable();

 void saveUser();

 void saveUser(User user);

 void deleteUser(int id);

 List<User> findAll();

}
