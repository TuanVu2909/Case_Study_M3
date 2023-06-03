package service;

import DAO.BookingDAO;
import model.Booking;


import java.util.ArrayList;
import java.util.List;

public class BookingService implements Service<Booking> {
    private final List<Booking> bookingList;
    private static BookingService bookingService;
    private final BookingDAO bookingDAO;

    private BookingService() {
        bookingList = new ArrayList<>();
        bookingDAO=new BookingDAO();
    }

    public static BookingService getInstance() {
        if (bookingService == null) {
            bookingService = new BookingService();
        }
        return bookingService;
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
