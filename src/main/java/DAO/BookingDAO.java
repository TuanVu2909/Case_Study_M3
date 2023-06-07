package DAO;

import model.*;
import service.Home_StayService;

import service.UserService;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import model.Home_Stay;
import model.User;
import service.*;


public class BookingDAO implements Service<Booking> {
    private final Connection connection = MyConnection.getConnection();
    private final Home_StayService home_stayService = Home_StayService.getInstance();
    private final UserService userService = UserService.getInstance();
    private final ActionService actionService = ActionService.getInstance();

    private final String SELECT_ALL_BOOKING = "select * from booking;";
    private final String SELECT_BY_ID_BOOKING = "select * from booking where id = ?;";
    private final String INSERT_INTO_BOOKING
            = "insert into booking(home_id,user_id,start_date,end_date,action_id,isBill) value (?,?,?,?,?,?);";
    private final String UPDATE_BY_ID_BOOKING
            = "update booking set home_id = ?,user_id = ?,start_date = ?,end_date = ?,action_id = ?,isBill = ?  where id = ?;";
    private final String DELETE_BY_ID_BOOKING = "delete from booking where id = ?";
    private final String SELEC_DAY_ID_BOOKING = "SELECT DATEDIFF(end_date,start_date) totalDay from booking where id = ?;";
    private final String PAY_ID = "update booking set isBill = ? where id = ?;";

    public BookingDAO() {

    }

    @Override
    public List<Booking> getList(BookingService bookingService) {
        List<Booking> bookingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKING)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int home_id = resultSet.getInt("home_id");
                int user_id = resultSet.getInt("user_id");
                Date start_date = resultSet.getDate("start_date");
                Date end_date = resultSet.getDate("end_date");
                int action_id = resultSet.getInt("action_id");
                int bill_id = resultSet.getInt("isBill");
                Home_Stay home_stay = home_stayService.getHomeById(home_id);
                User user = userService.getUserByID(user_id);
                Action action = actionService.getById(action_id);
                Booking booking = new Booking(id, user, home_stay, start_date, end_date, action,bill_id);
                int totalDay = bookingService.dateDiff(booking);

                Booking finalBooking = new Booking(id, user, home_stay, start_date, end_date, action,bill_id, totalDay, home_stay.getPrice() * totalDay);
                bookingList.add(finalBooking);
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
                int action_id = resultSet.getInt("action_id");
                int bill_id = resultSet.getInt("isBill");
                Home_Stay home_stay = home_stayService.getHomeById(home_id);
                User user = userService.getUserByID(user_id);
                Action action = actionService.getById(action_id);
                booking = new Booking(id, user, home_stay, start_date, end_date, action,bill_id);
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
            preparedStatement.setDate(3, (Date) booking.getStart_date());
            preparedStatement.setDate(4, (Date) booking.getEnd_date());
            preparedStatement.setInt(5, booking.getAction().getId());
            preparedStatement.setInt(6, booking.getIsBill());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int dateDiff(Booking booking){
        int dateDiff=-1;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELEC_DAY_ID_BOOKING)) {
            preparedStatement.setInt(1,booking.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dateDiff = resultSet.getInt("totalDay");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dateDiff;
    }

    @Override
    public void update(Booking booking) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID_BOOKING)) {
            preparedStatement.setInt(1, booking.getHomeStay().getId());
            preparedStatement.setInt(2, booking.getUser().getId());
            preparedStatement.setDate(3, (Date) booking.getStart_date());
            preparedStatement.setDate(4, (Date) booking.getEnd_date());
            preparedStatement.setInt(5, booking.getAction().getId());
            preparedStatement.setInt(6, booking.getIsBill());
            preparedStatement.setInt(7, booking.getId());

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
    public void pay(Booking booking){
        try (PreparedStatement preparedStatement = connection.prepareStatement(PAY_ID)){
            preparedStatement.setInt(1,booking.getIsBill());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}