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
        int affectedRow=0;
        String updateProduct = "UPDATE products SET categoryid = ?, costPrice = ?, sellingPrice = ?, thumbnail =? WHERE pid=?";
        try {
            pstmt = con.prepareStatement(updateProduct);
            pstmt.setInt(1,product.getCategoryID());
            pstmt.setDouble(2,product.getCostPrice());
            pstmt.setDouble(3,product.getSellingPrice());
            pstmt.setString(4, product.getThumbnailLink());
            pstmt.setInt(5,product.getProductId());
            affectedRow+=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            String checkProductBatch = "Select BATCHID FROM PRODUCTBATCH WHERE manufractureDate=? AND PID =?";
            pstmt = con.prepareStatement(checkProductBatch);
            pstmt.setDate(1,Date.valueOf(product.getMFGDate()));
            pstmt.setInt(2,product.getProductId());
            rs=pstmt.executeQuery();
            if(rs.next()){
                String updateProductBatch = "UPDATE PRODUCTBATCH SET Quantity=?,importDate=CURRENT_TIMESTAMP WHERE manufractureDate=? AND PID =?";
                pstmt = con.prepareStatement(updateProductBatch);
                pstmt.setInt(1, product.getQuantity());
                pstmt.setDate(2,Date.valueOf(product.getMFGDate()));
                pstmt.setInt(3,product.getProductId());
                affectedRow+=pstmt.executeUpdate();
                informationAlert("Update","THE BATCH OF PRODUCT "+product.getProductName().toUpperCase()+" PRODUCED ON "+product.getMFGDate()+" HAS BEEN UPDATED WITH THE QUANTITY");
            }else{
                addProductBatch(product,product.getProductId());
                informationAlert("Addition","SUCCESSFULLY ADDED NEW BATCH FOR PRODUCT "+product.getProductName().toUpperCase());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return affectedRow;
    }

    @Override
    public ResultSet selectALL(int Limit, int offSet) {

        ArrayList<Product> result= new ArrayList<Product>();
        try {
            String selectAllProduct = "SELECT * FROM PRODUCTS ORDER BY pid ASC LIMIT "+Limit+" OFFSET "+offSet;
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
            String selectByID_query = "SELECT * FROM PRODUCTS P INNER JOIN PRODUCTBATCH PB ON P.PID = PB.PID WHERE P.Pid =? ";
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
            addProductBatch(product, pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public long getQuantity(int pid){
        String query="SELECT SUM(quantity) AS totalQuantity FROM PRODUCTBATCH WHERE pid = ?";
        long totalQuantity=0;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,pid);
            rs =pstmt.executeQuery();
            if(rs.next())
                totalQuantity=rs.getInt("totalQuantity");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalQuantity;
    }
    private void addProductBatch(Product product, int pid){

        try {
            String addProductBatch= "INSERT INTO PRODUCTBATCH (pid, expirationDate, manufractureDate, quantity)"
                    +"VALUE(?,?,?,?)";
            pstmt = con.prepareStatement(addProductBatch);
            pstmt.setInt(1,pid);
            pstmt.setDate(2, Date.valueOf(product.getEXPDate()));
            pstmt.setDate(3,Date.valueOf(product.getMFGDate()));
            pstmt.setInt(4,product.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int getNumProuduct(){
        String query="SELECT COUNT(pid) as numberProduct FROM products";
        int numberProduct=0;
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            if(rs.next())
                numberProduct=rs.getInt("numberProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberProduct;
    }
}
