package model;

import java.util.Date;

public class Booking {
    private int id;
    private User user;
    private Home_Stay homeStay;

    private Date start_date;
    private Date end_date;
    private Action action;
    private int isBill;

    public Booking(int id, User user, Home_Stay homeStay, Date start_date, Date end_date, Action action, int isBill) {
        this.id = id;
        this.user = user;
        this.homeStay = homeStay;
        this.start_date = start_date;
        this.end_date = end_date;
        this.action = action;
        this.isBill = isBill;
    }

    public Booking() {
    }

    public Booking(User user, Home_Stay homeStay, Date start_date, Date end_date, Action action, int isBill) {
        this.user = user;
        this.homeStay = homeStay;
        this.start_date = start_date;
        this.end_date = end_date;
        this.action = action;
        this.isBill = isBill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Home_Stay getHomeStay() {
        return homeStay;
    }

    public void setHomeStay(Home_Stay homeStay) {
        this.homeStay = homeStay;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getIsBill() {
        return isBill;
    }

    public void setIsBill(int isBill) {
        this.isBill = isBill;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
