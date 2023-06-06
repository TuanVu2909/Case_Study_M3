package DAO;

import controller.Home_StayServlet;
import model.*;
import service.Home_StayService;
import service.StatusService;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDAO {

    private final Connection connection;
    private final Home_StayService home_stayService = Home_StayService.getInstance();
    private final UserService userService = UserService.getInstance();

    private final String SELECT_ALL = "select * from booking;";
    private final String SELECT_BY_ID = "select * from booking where id = ?;";
    private final String INSERT_INTO = "insert into booking(user_id,home_id,start_date, end_date, action) value (?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update booking set user_id = ?,home_id=?,status_id=?,start_date=?,end_date=?,action=? where id = ?;";
    private final String DELETE_BY_ID = "delete from booking where id = ?";
    private final String SEARCH_BY_NAME = "select * from booking where name like ?;";

    public BookingDAO() {
        connection = MyConnection.getConnection();
    }

//    public List<Booking> getBookingList() {
//        List<Booking> bookingList = new ArrayList<>();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int userId = resultSet.getInt("user_id");
//                int homeStayId = resultSet.getInt("home_id");
//                Date start_date = resultSet.getDate("start_date");
//                Date end_date = resultSet.getDate("end_date");
//                boolean action = resultSet.getBoolean("action");
//                User user = userService.getUserByID(userId);
//                Home_Stay home_stay = home_stayService.getById(homeStayId);
//                Status status = statusService.getById(statusId);
//                Booking booking = new Booking(id, user, status, start_date, end_date, action);
//                bookingList.add(booking);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bookingList;
//    }

    public void CreateBooking(Booking booking) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, booking.getUser().getId());
            preparedStatement.setInt(2, booking.getHomeStay().getId());
            preparedStatement.setDate(4, (java.sql.Date) booking.getStart_date());
            preparedStatement.setDate(4, (java.sql.Date) booking.getEnd_date());
            preparedStatement.setBoolean(5, booking.isAction());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBooking(Booking booking) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setInt(1, booking.getUser().getId());
            preparedStatement.setInt(2, booking.getHomeStay().getId());
            preparedStatement.setDate(4, (java.sql.Date) booking.getStart_date());
            preparedStatement.setDate(4, (java.sql.Date) booking.getEnd_date());
            preparedStatement.setBoolean(5, booking.isAction());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public Booking getBookingByID(int id){
//        Booking booking = null;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int userId = resultSet.getInt("user_id");
//                int homeStayId = resultSet.getInt("home_id");
//                Date start_date = resultSet.getDate("start_date");
//                Date end_date = resultSet.getDate("end_date");
//                boolean action = resultSet.getBoolean("action");
//                User user = userService.getUserByID(userId);
//                Home_Stay home_stay = home_stayService.getById(homeStayId);
//                Status status = statusService.getById(statusId);
//                Booking newBooking = new Booking(id, user, homeStay, status, start_date, end_date, action);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//        return newBooking;
//    }
    public void deleteById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
