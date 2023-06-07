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
        bookingDAO = new BookingDAO();
    }

    public static BookingService getInstance() {
        if (bookingService == null) {
            bookingService = new BookingService();
        }
        return bookingService;
    }

    public Booking getBookingById(int id) {
        return bookingDAO.getById(id);
    }

    public void deleteById(int id) {
        bookingDAO.delete(id);

    }

    @Override
    public List<Booking> getList(BookingService bookingService) {
        return bookingDAO.getList(bookingService);
    }


    @Override
    public void create(Booking booking) {
        bookingDAO.create(booking);
    }
    public int dateDiff(Booking booking){
      return   bookingDAO.dateDiff(booking);
    }
    public int date(Booking booking){
        return -1;
    }

    @Override
    public void update(Booking booking) {
        bookingDAO.update(booking);
    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
