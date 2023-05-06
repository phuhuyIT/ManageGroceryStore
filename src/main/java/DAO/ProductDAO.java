package DAO;

import Controller.AlertAndVerifyController;
import DatabaseConnection.ConnectionFactory;
import Model.CameraApp;
import Model.Customer;
import Model.Product;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductDAO extends AlertAndVerifyController implements DaoInterface<Product> {
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs1=null;
    Statement stmt1=null;
    ResultSet rs = null;
    public static ProductDAO getInstance(){
        return new ProductDAO();
    }
    public ProductDAO(){
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
            stmt1=con.createStatement();
            Stocks stocks = new Stocks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int insert(Product product) {
        try{
            String query = "SELECT pid FROM products WHERE PRODUCTBARCODE=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,product.getProductBarCode());
            rs=pstmt.executeQuery();
            if(rs.next()){
                errorAlert("ERROR","THIS PRODUCT HAS BEEN ADDED!");
                return 0;
            }else{
                addFunction(product);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int delete(String productCode) {
        String deleteProduct= "DELETE FROM PRODUCTS WHERE PRODUCTBARCODE= ?";
        int result;
        try {
            pstmt = con.prepareStatement(deleteProduct);
            pstmt.setString(1,productCode);
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Product product) {

       /* String updateProduct= "UPDATE PRODUCT SET PRODUCTID=?, PRODUCTCODE=?, DATE=?, SELLDATE=?," +
                " SUPPLIERCODE=?, PRODUCTNAME=?,QUANTITY=?,COSTPRICE=?,SELLINGPRICE=?,BRAND=?,USERID=?," +
                "CUSTOMERCODE=?,TOTALCOST=?,TOTALREVENUE=? WHERE  CUSTOMERID= ?";
        int result;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(updateProduct);
            pstmt.setInt(1,product.getProductId());
            pstmt.setString(2,product.getProductBarCode());
            pstmt.setDate(3, (Date) product.getDate());
            pstmt.setDate(4, (Date) product.getSellDate());
            pstmt.setString(5,product.getSupplierCode());
            pstmt.setString(6,product.getProductName());
            pstmt.setInt(7,product.getQuantity());
            pstmt.setDouble(8,product.getCostPrice());
            pstmt.setDouble(9,product.getSellingPrice());
            pstmt.setString(10,product.getBrand());
            pstmt.setInt(11,product.getUserId());
            pstmt.setString(12,product.getCustomerCode());
            pstmt.setDouble(13,product.getTotalCost());
            pstmt.setDouble(14,product.getTotalRevenue());
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return 0;
    }

    @Override
    public ResultSet selectALL() {

        ArrayList<Product> result= new ArrayList<Product>();
        try {
            String selectAllProduct = "SELECT * FROM PRODUCTS ORDER BY pid ASC LIMIT 10;";
            pstmt= con.prepareStatement(selectAllProduct);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  rs;
    }
    @Override
    public ResultSet selectByID(int ID) {
        ResultSet rs;
        try {
            String selectByID_query = "SELECT * FROM PRODUCTS WHERE Pid =?";
            pstmt= con.prepareStatement(selectByID_query);
            pstmt.setInt(1,ID);
            rs =pstmt.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rs;
    }

    @Override
    public int addFunction(Product product) {
        int result=0;
        try {
            String productSKUCode = null;
            productSKUCode = product.getProductBarCode()+" "+product.getMFGDate();
            String addProduct= "INSERT INTO PRODUCTS (productBarCode, productname, costprice, sellingprice, sid,categoryid,productSKU,thumbnail)"
                    +"VALUE(?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(addProduct);
            pstmt.setString(1,product.getProductBarCode());
            pstmt.setString(2, product.getProductName());
            pstmt.setDouble(3,product.getCostPrice());
            pstmt.setDouble(4,product.getSellingPrice());
            pstmt.setInt(5,product.getSupplierID());
            pstmt.setInt(6,product.getCategoryID());
            pstmt.setString(7,productSKUCode);
            pstmt.setString(8,product.getThumbnailLink());
            pstmt.executeUpdate();
            String skuFileName=product.getProductName()+product.getMFGDate();
            CameraApp.skuGenerate(productSKUCode,skuFileName+".png");
            String getPid ="SELECT LAST_INSERT_ID()";
            rs=pstmt.executeQuery(getPid);
            int pid=0;
            if(rs.next()) {
                pid = rs.getInt("LAST_INSERT_ID()");
            }
            System.out.println(pid);
            String addProductBatch= "INSERT INTO PRODUCTBATCH (pid, expirationDate, manufactureDate, quantity)"
                    +"VALUE(?,?,?,?)";
            pstmt = con.prepareStatement(addProductBatch);
            pstmt.setInt(1,pid);
            pstmt.setDate(2, Date.valueOf(product.getEXPDate()));
            pstmt.setDate(3,Date.valueOf(product.getMFGDate()));
            pstmt.setInt(4,product.getQuantity());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
