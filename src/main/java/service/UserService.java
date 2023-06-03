package service;

import DAO.UserDAO;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
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
    public List<User> getUserList(){
        return null;
    }
    public void createUser(User user){

    }
    public  void updateUser(User user){

    }
    public User getUserByID(int id){
        return null;
    }
    public void deleteById(int id){

    }
}
