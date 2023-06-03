package model;

public class Home_Stay {
    private int id;
    private String home_name;
    private String address;
    private String depict;
    private double price;
    private String avatar;
    private User user;

    public Home_Stay(int id, String home_name, String address, String depict, double price, String avatar, User user) {
        this.id = id;
        this.home_name = home_name;
        this.address = address;
        this.depict = depict;
        this.price = price;
        this.avatar = avatar;
        this.user = user;
    }

    public Home_Stay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
