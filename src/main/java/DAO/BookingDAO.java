package DAO;

import model.*;
import service.Home_StayService;

import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Booking;
import model.Home_Stay;
import model.User;
import service.*;


public class BookingDAO implements Service<Booking> {
    private final Connection connection = MyConnection.getConnection();
    private final Home_StayService home_stayService = Home_StayService.getInstance();
    private final UserService userService = UserService.getInstance();
    private final String SELECT_ALL_BOOKING = "select * from booking;";
    private final String SELECT_BY_ID_BOOKING = "select * from booking where id = ?;";
    private final String INSERT_INTO_BOOKING
            = "insert into booking(home_id,user_id,start_date,end_date,action) value (?,?,?,?,?);";
    private final String UPDATE_BY_ID_BOOKING
            = "update booking set home_id = ?,user_id = ?,start_date = ?,end_date = ?,action = ?  where id = ?;";
    private final String DELETE_BY_ID_BOOKING = "delete from booking where id = ?";

    public BookingDAO() {

    }

    @Override
    public List<Booking> getList() {
        List<Booking> bookingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKING)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int home_id = resultSet.getInt("home_id");
                int user_id = resultSet.getInt("user_id");
                Date start_date = resultSet.getDate("start_date");
                Date end_date = resultSet.getDate("end_date");
                boolean action = resultSet.getBoolean("action");
                Home_Stay home_stay = home_stayService.getHomeById(home_id);
                User user = userService.getUserByID(user_id);
                Booking booking = new Booking(id, user, home_stay, start_date, end_date, action);
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingList;
    }
    public Booking getById(int id){
        Booking booking = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_BOOKING)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int home_id = resultSet.getInt("home_id");
                int user_id = resultSet.getInt("user_id");
                Date start_date = resultSet.getDate("start_date");
                Date end_date = resultSet.getDate("end_date");
                boolean action = resultSet.getBoolean("action");
                Home_Stay home_stay = home_stayService.getHomeById(home_id);
                User user = userService.getUserByID(user_id);
                booking = new Booking(id, user, home_stay, start_date, end_date, action);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return booking;
    }


    @Override
    public void create(Booking booking) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOKING)) {
            preparedStatement.setInt(1, booking.getHomeStay().getId());
            preparedStatement.setInt(2, booking.getUser().getId());
            preparedStatement.setDate(3, (java.sql.Date) booking.getStart_date());
            preparedStatement.setDate(4, (java.sql.Date) booking.getEnd_date());
            preparedStatement.setBoolean(5, booking.isAction());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Booking booking) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID_BOOKING)) {
            preparedStatement.setInt(1, booking.getHomeStay().getId());
            preparedStatement.setInt(2, booking.getUser().getId());
            preparedStatement.setDate(3, (java.sql.Date) booking.getStart_date());
            preparedStatement.setDate(4, (java.sql.Date) booking.getEnd_date());
            preparedStatement.setBoolean(5, booking.isAction());
            preparedStatement.setInt(6, booking.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_BOOKING)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}