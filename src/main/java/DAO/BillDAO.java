package DAO;

import model.Bill;
import model.Booking;
import model.Role;
import service.BookingService;
import service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements Service<Bill> {
    private final Connection connection =MyConnection.getConnection();
    private final BookingService bookingService = BookingService.getInstance();
    private final String SELECT_ALL_BILL = "select * from bill;";
    private final String SELECT_BILL_BY_ID = "select * from bill where id=?;";
    private final String INSERT_INTO_BILL = "insert into bill(booking_id) value (?);";
    public BillDAO(){

    }
    public List<Bill> getBillList(){
        List<Bill> billList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BILL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int booking_id = resultSet.getInt("booking_id");
                Booking booking = bookingService.getBookingById(booking_id);
                Bill bill = new Bill(id,booking);
                billList.add(bill);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return billList;
    }
    public Bill getById(int id){
        Bill bill = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_BY_ID)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int booking_id = resultSet.getInt("booking_id");
                Booking booking = bookingService.getBookingById(booking_id);
                bill = new Bill(id,booking);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bill;
    }

    @Override
    public List<Bill> getList() {
        return null;
    }

    @Override
    public void create(Bill bill) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BILL)){
            preparedStatement.setInt(1,bill.getId());
           preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Bill bill) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
