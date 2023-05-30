package Model;

import java.util.ArrayList;

public class detailBill {
    private int detailBillID;
    private ArrayList productList;

    public detailBill(int detailBillID, ArrayList productList) {
        this.detailBillID = detailBillID;
        this.productList = productList;
    }

    public int getDetailBillID() {
        return detailBillID;
    }

    public void setDetailBillID(int detailBillID) {
        this.detailBillID = detailBillID;
    }

    public ArrayList getProductList() {
        return productList;
    }

    public void setProductList(ArrayList productList) {
        this.productList = productList;
    }
}
