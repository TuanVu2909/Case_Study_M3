package service;

import DAO.UserDAO;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<User> {
    private final List<User> userList;
    private static UserService userService;
    private final UserDAO userDAO;

    private UserService() {
        userList = new ArrayList<>();
        userDAO = new UserDAO();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    public void deleteById(int id) {
        userDAO.deleteById(id);

    }

    @Override
    public List<User> getList() {
        return userDAO.getUserList();
    }

    @Override
    public void create(User user) {
        userDAO.createUser(user);

    }

    @Override
    public void update(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
