package DAO;

import model.Booking;
import service.RoleService;
import service.Service;

import java.sql.Connection;
import java.util.List;

public class BookingDAO implements Service<Booking> {
    private final Connection connection = MyConnection.getConnection();
    private final RoleService roleService =RoleService.getInstance();
    private final String SELECT_ALL_USER = "select * from user;";
    private final String SELECT_BY_ID_USER = "select * from user where id = ?;";
    private final String INSERT_INTO_USER
            = "insert into user(username,password,avatar,full_name,address,phone,role_id ) value (?,?,?,?,?,?,?);";
    private final String UPDATE_BY_ID_USER
            = "update user set username = ?,password = ?,avatar = ?,full_name = ?,address = ?,phone = ?,role_id = ?  where id = ?;";
    private final String DELETE_BY_ID_USER = "delete from user where id = ?";

    public BookingDAO(){

    }
    @Override
    public List<Booking> getList() {
        return null;
    }

    @Override
    public void create(Booking booking) {

    }

    @Override
    public void update(Booking booking) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
