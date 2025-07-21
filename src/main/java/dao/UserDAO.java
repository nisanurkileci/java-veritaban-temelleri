package dao;

import model.User;
import java.util.List;

public interface UserDAO {
 void createUser(User user);
 User getUserById(Long id);
 List<User> getAllUsers();
 void updateUser(User user);
 void deleteUser(User user);
}

