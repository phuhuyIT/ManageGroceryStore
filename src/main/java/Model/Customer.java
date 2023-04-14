package Model;

public class Customer {
    private int customersId;
    private String customerCode;
    private String fullName;
    private String location;
    private String phone;
    private String debit;
    private String credit;
    private String email;

    public Customer(int customersId, String customerCode, String fullName, String location, String phone, String debit, String credit, String email) {
        this.customersId = customersId;
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
        this.debit = debit;
        this.credit = credit;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customersId=" + customersId +
                ", customerCode='" + customerCode + '\'' +
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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
