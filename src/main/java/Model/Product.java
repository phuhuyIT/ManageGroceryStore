package Model;

import java.util.Date;
public class Product {
    private int productId;
    private String productBarCode;
    private Date date;
    private Date sellDate;
    private String supplierCode;
    private String productName;
    private int quantity;
    private double costPrice;
    private double sellingPrice;
    private String brand;
    private int userId;
    private String customerCode;
    private Double totalCost;
    private Double totalRevenue;
    public Product (int productId,String productCode,Date date,Date sellDate,String supplierCode,
                    String productName,int quantity,double costPrice,double sellingPrice,
                    String brand,int userId,String customerCode,Double totalCost,Double totalRevenue){
        this.productId = productId;
        this.productCode = productCode;
        this.date = date;
        this.sellDate = sellDate;
        this.supplierCode = supplierCode;
        this.customerCode = customerCode;
        this.productName = productName;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.brand = brand;
        this.userId= userId;
        this.customerCode = customerCode;
        this.totalCost = totalCost;
        this.totalRevenue= totalRevenue;

    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public  Date getSellDate(){ return sellDate;}

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

//    public ResultSet getSuppliersName() {
//        ResultSet rs=new ProductDAO().getSuppliersInfo();
//        return rs;
//    }
//
//    public ResultSet getCustomersName() {
//        ResultSet rs=new ProductDAO().getCustomersInfo();
//        return rs;
//    }
//
//    public ResultSet getProductsName() {
//        ResultSet rs=new ProductDAO().getProductInfo();
//        return rs;
//    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

}
