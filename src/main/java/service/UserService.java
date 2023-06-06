package service;

import DAO.UserDAO;
import model.Role;
import model.User;
import model.Validate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserService implements Service<User> {
    private final List<User> userList;
    private static UserService userService;
    private static RoleService roleService = RoleService.getInstance();
    private final UserDAO userDAO;
    private final Validate validate = Validate.getInstance();

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
    public void save(HttpServletRequest request){
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
        String full_name = request.getParameter("full_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int roleId = Integer.parseInt(request.getParameter("role"));
        Role role = roleService.getById(roleId);
        if(id != null && role!=null){
            int idUpdate = Integer.parseInt(id);
            User user = new User(idUpdate, username, password, avatar, full_name, address, phone, role);
            userDAO.updateUser(user);
        }else {
            User user = new User( username, password, avatar, full_name, address, phone, role);
            userDAO.createUser(user);
        }
    }
    public boolean checkId(int id){
        User user =userDAO.getUserByID(id);
        return user !=null;
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
