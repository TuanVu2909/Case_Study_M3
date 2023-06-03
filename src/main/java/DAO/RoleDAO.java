package DAO;

import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private final Connection connection =MyConnection.getConnection();
    private final String SELECT_ALL_ROLE = "select * from role;";
    private final String SELECT_ROLE_BY_ID = "select * from role where id=?;";
    public RoleDAO(){

    }
    public List<Role> getRoleList(){
        List<Role> roleList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLE)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Role role = new Role(id,name);
                roleList.add(role);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return roleList;
    }
    public Role getById(int id){
        Role role = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                role = new Role(id,name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return role;
    }
}
