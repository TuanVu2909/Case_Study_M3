//package DAO;
//
//import model.*;
////import service.BookingService;
//import service.StatusService;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class BillDAO {
//    private final Connection connection;
////    private final BookingService bookingService = BookingService.getInstance();
//    private final String SELECT_ALL = "select * from bill;";
//    private final String SELECT_BY_ID = "select * from bill where id = ?;";
//    private final String INSERT_INTO = "insert into booking(id,booking_id) value (?,?);";
//    private final String UPDATE_BY_ID = "update booking set id = ?,booking_id=? where id = ?;";
//    private final String DELETE_BY_ID = "delete from booking where id = ?";
//    private final String SEARCH_BY_NAME = "select * from booking where name like ?;";
//
//    public BillDAO() {
//        connection = MyConnection.getConnection();
//    }
//
//    public List<Bill> getListBill() {
//        List<Bill> billList = new ArrayList<>();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int bookingId = resultSet.getInt("booking_id");
////                Booking booking = bookingService.getBookingById(bookingId);
//                Bill bill = new Bill(id, booking);
//                billList.add(bill);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return billList;
//    }
//
//    public void CreateBill(Bill bill) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
//            preparedStatement.setInt(1, bill.getId());
//            preparedStatement.setInt(2, bill.getBooking().getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateBill(Bill bill) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
//            preparedStatement.setInt(1, bill.getId());
//            preparedStatement.setInt(2, bill.getBooking().getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Bill getBillId(int id) {
//        Bill bill = null;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int bookingId = resultSet.getInt("booking_id");
//                Booking booking = bookingService.getBookingById(bookingId);
//                bill = new Bill(id, booking);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return bill;
//    }
//}
