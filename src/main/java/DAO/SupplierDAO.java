package DAO;


import Controller.AlertAndVerifyController;
import DatabaseConnection.ConnectionFactory;
import Model.Product;
import Model.Supplier;

import java.sql.*;
import java.util.ArrayList;




public class SupplierDAO extends AlertAndVerifyController implements DaoInterface <Supplier> {
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    public SupplierDAO() {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int insert(Supplier supplier) {
        int sid=0;
        try{
            String query = "SELECT SID FROM suppliers WHERE fullname=? AND location=? AND phone=?";
            pstmt =con.prepareStatement(query);
            pstmt.setString(1,supplier.getFullName());
            pstmt.setString(2,supplier.getLocation());
            pstmt.setString(3,supplier.getPhone());
            rs=pstmt.executeQuery();
            if(rs.next()){
                sid=rs.getInt("SID");
            }else{
                sid=addFunction(supplier);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return sid;
    }//end of method addSupplierDAO
    @Override
    public int addFunction(Supplier supplier){
        int sid=0;
        try{
            String supplierCode = null;
            String oldSupplierCode = null;
            String query1="SELECT * FROM suppliers";
            rs=stmt.executeQuery(query1);
            if(!rs.next()){
                supplierCode="sup"+"1";
            }
            else{
                String query2="SELECT * FROM suppliers ORDER by sid DESC";
                rs=stmt.executeQuery(query2);
                if(rs.next()){
                    oldSupplierCode=rs.getString("suppliercode");
                    Integer scode=Integer.parseInt(oldSupplierCode.substring(3));
                    scode++;
                    supplierCode="sup"+scode;
                }
            }
            String q = "INSERT INTO suppliers VALUES(null,?,?,?,?)";
            pstmt = con.prepareStatement(q);
            pstmt.setString(1, supplierCode);
            pstmt.setString(2, supplier.getFullName());
            pstmt.setString(3, supplier.getLocation());
            pstmt.setString(4, supplier.getPhone());
            pstmt.executeUpdate();
            String getSid ="SELECT LAST_INSERT_ID()";
            rs=pstmt.executeQuery(getSid);
            if(rs.next()){
                sid = rs.getInt("LAST_INSERT_ID()");
                informationAlert("Successful addition","INSERTED SUCCESSFULLY!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sid;
    }

    @Override
    public int update(Supplier supplier) {
        int affectedRows =0;
        try {
            String query = "UPDATE suppliers SET suppliercode=?,fullname=?,location=?,phone=? WHERE suppliercode=?";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, supplier.getSupplierCode());
            pstmt.setString(2, supplier.getFullName());
            pstmt.setString(3, supplier.getLocation());
            pstmt.setString(4, supplier.getPhone());
            pstmt.setString(5, supplier.getSupplierCode());
            pstmt.executeUpdate();
            System.out.println("Updated Successfully");
        } catch (Exception e) {
            System.out.println("Nothing updated! Click the table data first!");
        }
        return affectedRows;
    }//end of method editCustomerDTO

    @Override
    public ResultSet selectALL(int Limit, int offSet) {
        ArrayList<Supplier> result= new ArrayList<Supplier>();
        try {
            String selectAllProduct = "SELECT * FROM SUPPLIER";
            pstmt= con.prepareStatement(selectAllProduct);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  rs;
    }

    @Override
    public ResultSet selectByID(int ID) {
        try{
            String query="select fullname, location, phone from suppliers where sid=?";
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,ID);
            rs=pstmt.executeQuery();
        }catch(SQLException  e){
        }
        return rs;
    }
    @Override
    public int delete(int supplierCode){
        int affectedRows=0;
        try{
            String query="delete from suppliers where suppliercode=?";
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,supplierCode);
            affectedRows=pstmt.executeUpdate();
            System.out.println("Deleted..");
        }catch(SQLException  e){

        }
        return affectedRows;
    }

    public ResultSet getQueryResult() {
        try {
            String query = "SELECT suppliercode AS SupplierCode, fullname AS Name, location as Address, phone AS Phone FROM suppliers";
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }//end of method getQueryResult


    public ResultSet getCreditSuppliersQueryResult() {
        try {
            String query = "SELECT * FROM suppliers WHERE credit>0";
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getDebitSuppliersQueryResult() {
        try {
            String query = "SELECT * FROM suppliers WHERE credit=0";
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet getSearchSuppliersQueryResult(String searchTxt) {
        try {
            String query = "SELECT suppliercode AS SupplierCode, fullname AS Name, location as Address, phone AS Phone FROM suppliers WHERE fullname LIKE '%"+searchTxt+"%' OR location LIKE '%"+searchTxt+"%' OR suppliercode LIKE '%"+searchTxt+"%' OR phone LIKE '%"+searchTxt+"%'";
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}

