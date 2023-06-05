package model;

public class Bill {
    private int id;
    private Booking booking;

    public Bill(int id, Booking booking) {
        this.id = id;
        this.booking = booking;
    }

    public Bill(Booking booking) {
        this.booking = booking;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
