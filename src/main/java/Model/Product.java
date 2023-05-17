package Model;

import java.time.LocalDate;

public class Product {
    private Integer productId;
    private String productBarCode;
    private LocalDate MFGDate;
    private LocalDate EXPDate;
    private int supplierID;
    private String productName;
    private Integer quantity;
    private double costPrice;
    private double sellingPrice;
    private int categoryID;
    private int userId;
    private String customerCode;
    private Double totalCost;
    private String totalRevenue;
    private String SKUCode;
    private String thumbnailLink;

    public Product(String productName, double sellingPrice, int quantity, String totalRevenue) {
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.quantity=quantity;
        this.totalRevenue=totalRevenue;
    }

    public Product(String productName, int pid,Double costPrice,  String thumbnailLink) {
        this.costPrice = costPrice;
        this.productName = productName;
        this.productId=pid;
        this.thumbnailLink=thumbnailLink;
    }
    public Product( String productName,String productBarCode, int pid, double costPrice, String thumbnailLink) {
        this.productBarCode = productBarCode;
        this.productName = productName;
        this.productId=pid;
        this.costPrice=costPrice;
        this.thumbnailLink=thumbnailLink;
    }

    public Product(String productName, Integer quantity, String totalRevenue) {
        this.productName = productName;
        this.quantity = quantity;
        this.totalRevenue = totalRevenue;
    }

    public Product(Integer productId, LocalDate MFGDate, Integer quantity) {
        this.productId = productId;
        this.MFGDate = MFGDate;
        this.quantity = quantity;
    }

    public Product(Integer productId, LocalDate MFGDate, LocalDate EXPDate, Integer quantity) {
        this.productId = productId;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        this.quantity = quantity;
    }

    public Product(int STT, String productName, int quantity, String totalRevenue) {
        this.productId=STT;
        this.productName = productName;
        this.quantity = quantity;
        this.productBarCode = totalRevenue;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalRevenue=" + totalRevenue +
                '}';
    }

    public Product(String productName, int productId, int categoryID, int quantity, String thumbnailLink,  double costPrice, double sellingPrice) {
        this.productName = productName;
        this.productId = productId;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.categoryID = categoryID;
        this.thumbnailLink = thumbnailLink;
    }

    public Product(String productName, int categoryID, String productBarCode, String thumbnailLink, int supplierID, double costPrice, double sellingPrice, LocalDate MFGDate, LocalDate EXPDate, int quantity) {
        this.productBarCode = productBarCode;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        this.supplierID = supplierID;
        this.productName = productName;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.categoryID = categoryID;
        this.thumbnailLink = thumbnailLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public Product(int productId, String productBarCode, LocalDate MFGDate, LocalDate EXPDate, int supplierID, String productName, int quantity, double costPrice, double sellingPrice, int categoryID, int userId, String customerCode, Double totalCost, String totalRevenue, String SKUCode) {
        this.productId = productId;
        this.productBarCode = productBarCode;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        this.supplierID = supplierID;
        this.productName = productName;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.categoryID = categoryID;
        this.userId = userId;
        this.customerCode = customerCode;
        this.totalCost = totalCost;
        this.totalRevenue = totalRevenue;
        this.SKUCode = SKUCode;
    }

    public String getSKUCode() {
        return SKUCode;
    }

    public void setSKUCode(String SKUCode) {
        this.SKUCode = SKUCode;
    }

    public Product(int productId, String productBarCode, LocalDate MFGDate, LocalDate EXPDate, int supplierID) {
        this.productId = productId;
        this.productBarCode = productBarCode;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        this.supplierID = supplierID;
    }
    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    public LocalDate getMFGDate() {
        return MFGDate;
    }

    public void setMFGDate(LocalDate MFGDate) {
        this.MFGDate = MFGDate;
    }

    public LocalDate getEXPDate() {
        return EXPDate;
    }

    public void setEXPDate() {
        this.EXPDate = EXPDate;
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

    public String getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

}
