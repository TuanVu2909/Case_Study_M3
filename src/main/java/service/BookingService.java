//package service;
//
//import DAO.BookingDAO;
//import model.Booking;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookingService implements Service<Booking> {
//    private final List<Booking> bookingList;
//    private static BookingService bookingService;
//    private final BookingDAO bookingDAO;
//
//    private BookingService() {
//        bookingList = new ArrayList<>();
//        bookingDAO = new BookingDAO();
//    }
//
//    public static BookingService getInstance() {
//        if (bookingService == null) {
//            bookingService = new BookingService();
//        }
//        return bookingService;
//    }
//
////    public Booking getBookingById(int id) {
////        return bookingDAO.getBookingByID(id);
////    }
//
//    public void deleteById(int id) {
//        bookingDAO.deleteById(id);
//
//    }
//
////    @Override
////    public List<Booking> getList() {
////        return bookingDAO.getBookingList();
////
////    }
//
//    @Override
//    public void create(Booking booking) {
//        bookingDAO.CreateBooking(booking);
//    }
//
//    @Override
//    public void update(Booking booking) {
//
//    }
//
//    @Override
//    public void delete() {
//
//    }
//
//    @Override
//    public void displayALL() {
//
//    }
//}
