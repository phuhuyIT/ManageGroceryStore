package Model;

import java.time.LocalDate;

public class Staff {
    private int id;
    private String fullName;
    private String staffIDCard;
    private String position;
    private String phone;
    private LocalDate joinDate;
    private float basicSalary;

    private float totalSalary;
    private String gender;
    private String Email;
    private LocalDate birthDate;
    private String avatarLink;
    private String location;


    public Staff(String fullName, LocalDate joinDate,int id, String position, String avatarLink) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.joinDate = joinDate;
        this.avatarLink = avatarLink;
    }

    public Staff(int id, String location, String phone, String email, String avatarLink, float basicSalary, String position) {
        this.id = id;
        this.position = position;
        this.phone = phone;
        this.basicSalary = basicSalary;
        Email = email;
        this.location = location;
        this.avatarLink=avatarLink;
    }


    public Staff(String fullName, String staffIDCard, String gender, String location, String phone, String email, String avatarLink, LocalDate birthDate, float basicSalary, String position, LocalDate joinDate) {
        this.fullName = fullName;
        this.staffIDCard = staffIDCard;
        this.position = position;
        this.phone = phone;
        this.joinDate = joinDate;
        this.basicSalary = basicSalary;
        this.gender = gender;
        Email = email;
        this.birthDate = birthDate;
        this.avatarLink = avatarLink;
        this.location = location;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getStaffIDCard() {
        return staffIDCard;
    }

    public void setStaffIDCard(String staffIDCard) {
        this.staffIDCard = staffIDCard;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }


    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }
}

