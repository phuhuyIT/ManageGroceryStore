package Model;

public class Supplier {

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String suppliersCode) {
        this.supplierCode = suppliersCode;
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

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Supplier(int supplierId, String supplierCode, String fullName, String location, String phone, double debit, double credit) {
        this.supplierId = supplierId;
        this.supplierCode = supplierCode;
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
        this.debit = debit;
        this.credit = credit;
    }

    public Supplier(String fullName, String location, String phone) {
        this.fullName = fullName;
        this.location = location;
        this.phone = phone;
    }

    private int supplierId;
    private String supplierCode;
    private String fullName;
    private String location;
    private String phone;
    private double debit;
    private double credit;
    private double balance;



}
