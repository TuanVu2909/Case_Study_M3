package DAO;

import model.Booking;
import model.Home_Stay;
import model.User;
import service.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements Service<Booking> {
    private final Connection connection = MyConnection.getConnection();
    private final Home_StayService home_stayService = Home_StayService.getInstance();
    private final UserService userService = UserService.getInstance();
    private final String SELECT_ALL_BOOKING = "select * from booking;";
    private final String SELECT_BY_ID_BOOKING = "select * from booking where id = ?;";
    private final String INSERT_INTO_BOOKING
            = "insert into booking(home_id,user_id,start_date,end_date,action) value (?,?,?,?,?);";
    private final String UPDATE_BY_ID_BOOKING
            = "update booking set home_id = ?,user_id = ?,status_id = ?,start_date = ?,end_date = ?,action = ?  where id = ?;";
    private final String DELETE_BY_ID_BOOKING = "delete from booking where id = ?";

    public BookingDAO() {

    }

    @Override
    public List<Booking> getList() {
        List<Booking> bookingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKING)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int home_id = resultSet.getInt("home_id");
                int user_id = resultSet.getInt("user_id");
                Date start_date = resultSet.getDate("start_date");
                Date end_date = resultSet.getDate("end_date");
                boolean action = resultSet.getBoolean("action");
                Home_Stay home_stay = home_stayService.getHomeById(home_id);
                User user = userService.getUserByID(user_id);
                Booking booking = new Booking(user,home_stay,start_date,end_date,action);
                bookingList.add(booking);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return bookingList;
    }

    @Override
    public void create(Booking booking) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOKING)) {
            preparedStatement.setInt(1, booking.getHomeStay().getId());
            preparedStatement.setInt(2, booking.getUser().getId());
            preparedStatement.setDate(4, (Date) booking.getStart_date());
            preparedStatement.setDate(5, (Date) booking.getEnd_date());
            preparedStatement.setBoolean(6, booking.isAction());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Booking booking) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOKING)) {
            preparedStatement.setInt(1, booking.getHomeStay().getId());
            preparedStatement.setInt(2, booking.getUser().getId());
            preparedStatement.setDate(4, (Date) booking.getStart_date());
            preparedStatement.setDate(5, (Date) booking.getEnd_date());
            preparedStatement.setBoolean(6, booking.isAction());
            preparedStatement.setInt(7, booking.getId());
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
