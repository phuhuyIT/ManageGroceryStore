package Model;

import java.sql.Timestamp;
import java.util.Objects;

public class Bill {
    private int billID;
    private String billCode;
    private Timestamp purchaseDate;
    private float revenue;
    private int detailBillID;
    private int productID;
    private int customerID;
    private int staffID;
    private String productList;
    private String customerName;
    private String staffName;
    private int sequence;

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    private int purchaseQuantity;
    public String getProduct() {
        return productList;
    }

    public void setProduct(String product) {
        this.productList = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return billID == bill.billID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billID);
    }

    public Bill(int sequence, int billID, String billCode, Timestamp purchaseDate, String staffName, String customerName, Float revenue , String product) {
        this.billID = billID;
        this.billCode = billCode;
        this.purchaseDate = purchaseDate;
        this.customerName = customerName;
        this.staffName = staffName;
        this.productList = product;
        this.revenue=revenue;
        this.sequence=sequence;
    }


    public String getCustomerName() {
        return customerName;
    }

    public String getStaffName() {
        return staffName;
    }


    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public Bill(int sequence, String billCode, Timestamp purchaseDate, float revenue, int billID) {
        this.billID = billID;
        this.billCode = billCode;
        this.purchaseDate = purchaseDate;
        this.revenue = revenue;
        this.sequence=sequence;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
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

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}