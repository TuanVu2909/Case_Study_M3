package DAO;

import model.Home_Stay;
import model.User;
import service.UserService;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Home_StayDAO {
    private final Connection connection;
    private UserService userService = UserService.getInstance();
    private final String SELECT_ALL_HOMESTAY = "select * from home_stay;";
    private final String SELECT_BY_ID_HOMESTAY = "select * from home_stay where id = ?;";
    private final String INSERT_INTO_HOMESTAY = "insert into home_stay(name,address,depict,price,avatar,admin_id) value (?,?,?,?,?,?);";
    private final String UPDATE_BY_ID_HOMESTAY = "update home_stay set name = ?,address= ?,depict=?,price = ?,avatar = ?, admin_id = ? where id = ?;";
    private final String DELETE_BY_ID_HOMESTAY = "delete from home_stay where id = ?";
    private final String SEARCH_NAME_HOMESTAY = "select * from home_stay where name like ?;";

    public Home_StayDAO() {
        connection = MyConnection.getConnection();
    }
    public List<Home_Stay> getList() {
        List<Home_Stay> home_stayList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOMESTAY)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String depict = resultSet.getString("depict");
                double price = resultSet.getDouble("price");
                String  avatar = resultSet.getString("avatar");
                int admin_id = resultSet.getInt("admin_id");
                User user = userService.getUserByID(admin_id) ;
                Home_Stay homeStay = new Home_Stay(id,name,address,depict,price,avatar,user);
                home_stayList.add(homeStay);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return home_stayList;
    }

    public Home_Stay getHomeStayByID(int id) {
        Home_Stay homeStay = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_HOMESTAY)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String depict = resultSet.getString("depict");
                double price = resultSet.getDouble("price");
                String  avatar = resultSet.getString("avatar");
                int admin_id = resultSet.getInt("admin_id");
                User user = userService.getUserByID(admin_id) ;
                homeStay = new Home_Stay(id,name,address,depict,price,avatar,user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return homeStay;
    }

    public void create(Home_Stay homeStay) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_HOMESTAY)) {
            preparedStatement.setString(1, homeStay.getHome_name());
            preparedStatement.setString(2, homeStay.getAddress());
            preparedStatement.setString(3, homeStay.getDepict());
            preparedStatement.setDouble(4, homeStay.getPrice());
            preparedStatement.setString(5, homeStay.getAvatar());
            preparedStatement.setInt(6, homeStay.getUser().getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Home_Stay homeStay) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID_HOMESTAY)) {
            preparedStatement.setString(1, homeStay.getHome_name());
            preparedStatement.setString(2, homeStay.getAddress());
            preparedStatement.setString(3, homeStay.getDepict());
            preparedStatement.setDouble(4, homeStay.getPrice());
            preparedStatement.setString(5, homeStay.getAvatar());
            preparedStatement.setInt(6, homeStay.getUser().getId());
            preparedStatement.setInt(7,homeStay.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_HOMESTAY)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Home_Stay> searchName(String name){
        List<Home_Stay> home_stayList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME_HOMESTAY)) {
            preparedStatement.setString(1,"%" + name + "%" );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String address = resultSet.getString("address");
                String depict = resultSet.getString("depict");
                double price = resultSet.getDouble("price");
                String  avatar = resultSet.getString("avatar");
                int admin_id = resultSet.getInt("admin_id");
                User user = userService.getUserByID(admin_id) ;
                Home_Stay homeStay = new Home_Stay(id,name1,address,depict,price,avatar,user);
                home_stayList.add(homeStay);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return home_stayList;
    }

}