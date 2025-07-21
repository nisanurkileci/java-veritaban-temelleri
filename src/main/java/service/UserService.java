package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO = new UserDAOImpl();

    public void createUser(User user) {
        userDAO.save(user);
    }

    public User getUser(int id) {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }
}
