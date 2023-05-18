package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bill {
    private int billID;
    private String billCode;
    private LocalDate purchaseDate;
    private String revenue;
    private int detailBillID;
    private int productID;
    private int customerID;
    private int staffID;
    private List productList;
    private String customerName;
    private String staffName;
    private int sequence;
    private Double receive;
    private Double refund;

    public Double getReceive() {
        return receive;
    }

    public void setReceive(Double receive) {
        this.receive = receive;
    }

    public Double getRefund() {
        return refund;
    }

    public void setRefund(Double refund) {
        this.refund = refund;
    }

    public Bill(String billCode, LocalDate invoiceDate, String staffName, String customerName, String format, ArrayList<Product> productList, int quantity) {
        this.billCode=billCode;
        this.purchaseDate=invoiceDate;
        this.staffName =staffName;
        this.customerName=customerName;
        this.revenue = format;
        this.productList=productList;
        this.purchaseQuantity=quantity;
    }
    public Bill(int i, int i1, String billCode, LocalDate invoiceDate, String staffName, String customerName, String format, ArrayList<Product> productList, Double receive, Double refund) {
        this.billCode=billCode;
        this.purchaseDate=invoiceDate;
        this.staffName =staffName;
        this.customerName=customerName;
        this.revenue = format;
        this.productList=productList;
        this.receive = receive;
        this.refund = refund;
    }
    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    private int purchaseQuantity;
    public List getProductList() {
        return productList;
    }

    public void setProductList(List<Product> product) {
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

    public Bill(int sequence, int billID, String billCode, LocalDate purchaseDate, String staffName, String customerName, String revenue , ArrayList<Product> product) {
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

    public Bill(int sequence, String billCode, LocalDate purchaseDate, String revenue, int billID) {
        this.billID = billID;
        this.billCode = billCode;
        this.purchaseDate = purchaseDate;
        this.revenue = revenue;
        this.sequence=sequence;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID=" + billID +
                ", billCode='" + billCode + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", revenue='" + revenue + '\'' +
                ", detailBillID=" + detailBillID +
                ", productID=" + productID +
                ", customerID=" + customerID +
                ", staffID=" + staffID +
                ", productList=" + productList +
                ", customerName='" + customerName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", sequence=" + sequence +
                ", purchaseQuantity=" + purchaseQuantity +
                '}';
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

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
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