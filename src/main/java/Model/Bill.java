package Model;

import java.time.LocalDate;

public class Bill {
    private int billID;
    private String billCode;
    private LocalDate purchaseDate;
    private float revenue;
    private int detailBillID;
    private int productID;
    private int customerID;
    private int staffID;
    private int purchaseQuantity;

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public Bill(int billID, String billCode, LocalDate purchaseDate, float revenue, int totalQuantity) {
        this.billID = billID;
        this.billCode = billCode;
        this.purchaseDate = purchaseDate;
        this.revenue = revenue;
        this.purchaseQuantity=totalQuantity;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public int getDetailBillID() {
        return detailBillID;
    }

    public void setDetailBillID(int detailBillID) {
        this.detailBillID = detailBillID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}