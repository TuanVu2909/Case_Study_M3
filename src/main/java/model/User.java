package model;

public class User {
    private int id;
    private String username;
    private String password;
    private String avatar;
    private String fullName;
    private String address;
    private String phone;
    private Role role;

    public User(int id, String username, String password, String avatar, String fullName, String address, String phone, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
