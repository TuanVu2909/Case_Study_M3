package DAO;

import model.Action;
import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAO {
    private final Connection connection = MyConnection.getConnection();
    private final String SELECT_ALL_ACTION = "select * from action;";
    private final String SELECT_ACTION_BY_ID = "select * from action where id=?;";
    public ActionDAO(){

    }
    public List<Action> getActionList(){
        List<Action> actionList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACTION)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Action action = new Action(id,name);
                actionList.add(action);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return actionList;
    }
    public Action getById(int id){
        Action action = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACTION_BY_ID)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                action = new Action(id,name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return action;
    }
}
