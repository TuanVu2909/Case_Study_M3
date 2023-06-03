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
        userDAO=new UserDAO();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    public User getUserByID(int id){
        return null;
    }
    public void deleteById(int id){

    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
