package Model;

import java.time.LocalDate;

public class productLot {
    private String SKUCode;
    private int productID;
    private LocalDate MFGDate;
    private LocalDate EXPDate;
    private int quantity;

    public productLot(String SKUCode, int productID, LocalDate MFGDate, LocalDate EXPDate, int quantiy) {
        this.SKUCode = SKUCode;
        this.productID = productID;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        this.quantity = quantiy;
    }

    public productLot(String SKUCode, LocalDate MFGDate, LocalDate EXPDate, int quantity) {
        this.SKUCode = SKUCode;
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
        this.quantity = quantity;
    }

    public productLot(LocalDate MFGDate, LocalDate EXPDate) {
        this.MFGDate = MFGDate;
        this.EXPDate = EXPDate;
    }

    public productLot(productLot productLot) {
        SKUCode = productLot.SKUCode;
        productID = productLot.productID;
        MFGDate = productLot.MFGDate;
        EXPDate = productLot.EXPDate;
        quantity = productLot.quantity;
    }

    public productLot(int currentItemID, LocalDate parse, int totalQuantity) {
        this.productID=currentItemID;
        this.MFGDate=parse;
        this.quantity =totalQuantity;
    }

    public String getSKUCode() {
        return SKUCode;
    }

    public void setSKUCode(String SKUCode) {
        this.SKUCode = SKUCode;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    public void setEXPDate(LocalDate EXPDate) {
        this.EXPDate = EXPDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
