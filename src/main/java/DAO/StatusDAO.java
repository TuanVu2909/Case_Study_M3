package DAO;

import model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO {
    private final Connection connection;

    private final String SELECT_BY_ID = "select * from status where id=?;";

    private final String SELECT_ALL_STATUS = "select * from status;";


    public StatusDAO() {
        connection = MyConnection.getConnection();
    }

    public Status getById(int id) {
        Status status = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                status = new Status(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Status> getStatusList() {
        List<Status> roleList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATUS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Status status = new Status(id, name);
                roleList.add(status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }
}