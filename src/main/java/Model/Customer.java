package Model;

public class Customer {
    private int customersId;
    private String citizenIDNumber;
    private String fullName;
    private String location;
    private String phone;
    private String debit;
    private String credit;
    private String email;
    private String avatarLink;
    private String gender;
    private String birthDate;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public Customer(String fullName, String citizenIDNumber, String gender, String location, String phone, String email, String avatarLink, String birthDate) {
        this.citizenIDNumber = citizenIDNumber;
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.avatarLink = avatarLink;
        this.birthDate=birthDate;
    }

    public Customer(int customersId,String phone, String email,String location, String avatarLink) {
        this.customersId=customersId;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.avatarLink = avatarLink;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customersId=" + customersId +
                ", citizenIDNumber='" + citizenIDNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", debit='" + debit + '\'' +
                ", credit='" + credit + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    public String getCitizenIDNumber() {
        return citizenIDNumber;
    }

    public void setCitizenIDNumber(String citizenIDNumber) {
        this.citizenIDNumber = citizenIDNumber;
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

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

}
