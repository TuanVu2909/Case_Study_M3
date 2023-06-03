package model;

import java.util.Date;

public class Booking {
    private int id;
    private User user;
    private Home_Stay homeStay;
    private Status status;
    private Date start_date;
    private Date end_date;
    private boolean action;

    public Booking(int id, User user, Home_Stay homeStay, Status status, Date start_date, Date end_date, boolean action) {
        this.id = id;
        this.user = user;
        this.homeStay = homeStay;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
        this.action = action;
    }

    public Booking() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }
}
