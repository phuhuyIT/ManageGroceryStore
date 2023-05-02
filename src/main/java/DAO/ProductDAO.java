package DAO;

import DatabaseConnection.ConnectionFactory;
import Model.Customer;
import Model.Product;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO implements DaoInterface<Product> {
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
    public void insert(Product product) {
        try{
            String query = "SELECT * FROM products WHERE productname='"+product.getProductName()+"' AND costprice='"+product.getCostPrice()+"' AND sellingprice='"+product.getSellingPrice()+"' AND brand='"+product.getBrand()+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("This product has been added.");
                alert.show();
            }else{
                addFunction(product);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int delete(String productCode) {
        String deleteProduct= "DELETE FROM PRODUCT WHERE PRODUCTCODE= ?";
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

        String updateProduct= "UPDATE PRODUCT SET PRODUCTID=?, PRODUCTCODE=?, DATE=?, SELLDATE=?," +
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
        }
        return result;
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
            String productCode = null;
            String oldProductCode = null;
            String query1="SELECT * FROM products";
            rs=stmt.executeQuery(query1);
            if(!rs.next()){
                productCode="prod"+"1";
            }
            else{
                String query2="SELECT * FROM products ORDER by productID DESC";
                rs=stmt.executeQuery(query2);
                if(rs.next()){
                    oldProductCode=rs.getString("productcode");
                    Integer pcode=Integer.parseInt(oldProductCode.substring(4));
                    pcode++;
                    productCode="prod"+pcode;
                }
            }
            String updateProduct= "INSERT INTO PRODUCT ( PRODUCTID, PRODUCTBARCODE, DATE, SELLDATE, SUPPLIERCODE, PRODUCTNAME,QUANTITY,COSTPRICE,SELLINGPRICE,BRAND,USERID,CUSTOMERCODE,TOTALCOST,TOTALREVENUE "
                    +"VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
