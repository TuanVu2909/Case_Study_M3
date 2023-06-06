package DAO;

import model.Role;
import model.User;
import service.RoleService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final Connection connection = MyConnection.getConnection();
    private final RoleService roleService =RoleService.getInstance();
    private final String SELECT_ALL_USER = "select * from user;";
    private final String SELECT_BY_ID_USER = "select * from user where id = ?;";
    private final String INSERT_INTO_USER
            = "insert into user(username,password,avatar,full_name,address,phone,role_id ) value (?,?,?,?,?,?,?);";
    private final String UPDATE_BY_ID_USER
            = "update user set username = ?,password = ?,avatar = ?,full_name = ?,address = ?,phone = ?,role_id = ?  where id = ?;";
    private final String DELETE_BY_ID_USER = "delete from user where id = ?";

    public UserDAO() {
    }
    public List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String avatar = resultSet.getString("avatar");
                String full_name = resultSet.getString("full_name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int role_id = resultSet.getInt("role_id");
                Role role = roleService.getById(role_id);
                User user = new User(id,username,password,avatar,full_name,address,phone,role);
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }
    public void createUser(User user){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER)) {
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getAvatar());
            preparedStatement.setString(4,user.getFullName());
            preparedStatement.setString(5,user.getAddress());
            preparedStatement.setString(6,user.getPhone());
            preparedStatement.setInt(7,user.getRole().getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public  void updateUser(User user){
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID_USER)) {
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getAvatar());
            preparedStatement.setString(4,user.getFullName());
            preparedStatement.setString(5,user.getAddress());
            preparedStatement.setString(6,user.getPhone());
            preparedStatement.setInt(7,user.getRole().getId());
            preparedStatement.setInt(8,user.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public User getUserByID(int id){
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_USER)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String avatar = resultSet.getString("avatar");
                String full_name = resultSet.getString("full_name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int role_id = resultSet.getInt("role_id");
                Role role = roleService.getById(role_id);
                user = new User(id,username,password,avatar,full_name,address,phone,role);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    public void deleteById(int id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_USER)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
