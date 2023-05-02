package Model;

import java.io.File;

public class User {
    private int id;
    private String fullName;
    private String location;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String category;
    private String imgLink;

    public String getEmail() {
        return email;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String fullName, String location, String phone, String email, String category, String image) {
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.imgLink = image;
    }

    public User(int id, String fullName, String location, String phone, String username, String password, String category, String image) {
        this.id = id;
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.category = category;
        this.imgLink = image;
    }    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageLink() {
        return imgLink;
    }

    public void setImageLink(String image) {
        this.imgLink = image;
    }
}
