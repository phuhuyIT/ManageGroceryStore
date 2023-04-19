package DAO;

import DatabaseConnection.ConnectionFactory;
import Model.Customer;
import Model.Product;

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

    }

    @Override
    public int delete(Product product) {
        String deleteProduct= "DELETE FROM PRODUCT WHERE PRODUCTID= ?";
        int result;
        try {
            pstmt = con.prepareStatement(deleteProduct);
            pstmt.setInt(1,product.getProductId());
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
            pstmt.setString(2,product.getProductCode());
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
    public ArrayList<Product> selectALL() {

        ArrayList<Product> result= new ArrayList<Product>();
        try {
            String selectAllProduct = "SELECT * FROM PRODUCT";
            pstmt= con.prepareStatement(selectAllProduct);
            rs = pstmt.executeQuery();
            while (rs.next()){
            int idProduct = rs.getInt("PRODUCTID");
            String codeProduct = rs.getString("PRODUCTCODE");
            Date date = rs.getDate("DATE");
            Date dateSell = rs.getDate("SELLDATE");
            String codeSupplier = rs.getString("SUPPLIERCODE");
            String nameProduct = rs.getString("PRODUCTNAME");
            int quanty = rs.getInt("QUANTITY");
            double costPrice = rs.getDouble("COSTPRICE");
            double priceSelling = rs.getDouble("SELLINGPRICE");
            String brand = rs.getString("BRAND");
            int userId = rs.getInt("USERID");
            String customerCode = rs.getString("CUSTOMERCODE");
            double totalCode = rs.getDouble("TOTALCOST");
            double totalRevenue = rs.getDouble("TOTALREVENUE");
            Product product = new Product(idProduct,codeProduct,date,dateSell,codeSupplier,nameProduct
                    ,quanty,costPrice,priceSelling,brand,userId,customerCode,totalCode,totalRevenue);
            result.add(product);

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  result;
    }
    @Override
    public Product selectByID(Product product) {
        Product result = null;
        try {
            String selectByID_query = "SELECT * FROM PRODUCT WHERE PRODUCTID =?";
            pstmt= con.prepareStatement(selectByID_query);
            pstmt.setInt(1,product.getProductId());
            rs = pstmt.executeQuery();
            while (rs.next()){
                int idProduct = rs.getInt("PRODUCTID");
                String codeProduct = rs.getString("PRODUCTCODE");
                Date date = rs.getDate("DATE");
                Date dateSell = rs.getDate("SELLDATE");
                String codeSupplier = rs.getString("SUPPLIERCODE");
                String nameProduct = rs.getString("PRODUCTNAME");
                int quanty = rs.getInt("QUANTITY");
                double costPrice = rs.getDouble("COSTPRICE");
                double priceSelling = rs.getDouble("SELLINGPRICE");
                String brand = rs.getString("BRAND");
                int userId = rs.getInt("USERID");
                String customerCode = rs.getString("CUSTOMERCODE");
                double totalCode = rs.getDouble("TOTALCOST");
                double totalRevenue = rs.getDouble("TOTALREVENUE");
                result = new Product(idProduct,codeProduct,date,dateSell,codeSupplier,nameProduct
                        ,quanty,costPrice,priceSelling,brand,userId,customerCode,totalCode,totalRevenue);

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int addFunction(Product product) {

        String updateProduct= "INSERT INTO PRODUCT ( PRODUCTID, PRODUCTCODE, DATE, SELLDATE, SUPPLIERCODE, PRODUCTNAME,QUANTITY,COSTPRICE,SELLINGPRICE,BRAND,USERID,CUSTOMERCODE,TOTALCOST,TOTALREVENUE "
                +"VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int result;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(updateProduct);
            pstmt.setInt(1,product.getProductId());
            pstmt.setString(2,product.getProductCode());
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
}
