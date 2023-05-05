package DAO;
import Controller.AlertAndVerifyController;
import Model.Customer;
import DatabaseConnection.ConnectionFactory;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
public class CustomerDAO extends AlertAndVerifyController implements DaoInterface <Customer>{
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs1=null;
    Statement stmt1=null;
    ResultSet rs = null;
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
    }

    public CustomerDAO() {
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
    public int insert(Customer cus) {
        String findCustomerByNameLocatePhone = "SELECT * FROM CUSTOMER WHERE FULLNAME=? AND LOCATION=? AND PHONE=?";
        try {
            pstmt = con.prepareStatement(findCustomerByNameLocatePhone);
            pstmt.setString(1,cus.getFullName());
            pstmt.setString(2,cus.getLocation());
            pstmt.setString(3,cus.getPhone());
            rs= pstmt.executeQuery();
            if(rs.next()){
                errorAlert("Error","THIS CUSTOMER HAS BEEN ADDED");
            }else{
                addFunction(cus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int delete(String customerCode) {
        String deleteCustomerDetails= "DELETE FROM CUSTOMER WHERE CUSTOMERCODE= ?";
        int result;
        try {
            pstmt = con.prepareStatement(deleteCustomerDetails);
            pstmt.setString(1,customerCode);
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Customer customer) {
        String updateCustomerDetails= "UPDATE CUSTOMER SET FULLNAME=?, LOCATION=?, PHONE=?, DEBIT=?, CREDIT=?, EMAIL=? WHERE  CUSTOMERID= ?";
        int result;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(updateCustomerDetails);
            pstmt.setString(1,customer.getFullName());
            pstmt.setString(2,customer.getLocation());
            pstmt.setString(3,customer.getPhone());
            pstmt.setString(4,customer.getDebit());
            pstmt.setString(5,customer.getCredit());
            pstmt.setString(6,customer.getEmail());
            pstmt.setInt(7,customer.getCustomersId());
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ResultSet selectALL() {
        ArrayList<Customer> result= new ArrayList<Customer>();
        try {
            String sql= "SELECT * FROM CUSTOMERS";
            pstmt= con.prepareStatement(sql);
            rs = pstmt.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public ResultSet selectByID(int ID) {
        try {
            String selectByID_query = "SELECT * FROM CUSTOMER WHERE CUSTOMERID =?";
            pstmt= con.prepareStatement(selectByID_query);
            pstmt.setInt(1,ID);
            rs = pstmt.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rs;
    }
    @Override
    public int addFunction(Customer customer) {
        int result = 0;
        try {
            String customerCode = null;
            String oldCustomerCode = null;
            String getAllCustomers = "SELECT * FROM customers";
            rs = stmt.executeQuery(getAllCustomers);
            if (!rs.next()) {
                customerCode = "cus" + "1";
            } else {
                String getAllCustomersInDescOrder = "SELECT * FROM customers ORDER by customerID DESC";
                rs = stmt.executeQuery(getAllCustomersInDescOrder);
                if (rs.next()) {
                    oldCustomerCode = rs.getString("customercode");
                    Integer scode = Integer.parseInt(oldCustomerCode.substring(3));
                    scode++;
                    customerCode = "cus" + scode;
                }
            }
            String url = "insert into CUSTOMER (CUSTOMERID, FULLNAME, LOCATION, EMAIL, DEBIT, CREDIT, PHONE)"
                    + "values (?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(url);
            pstmt.setInt(1, customer.getCustomersId());
            pstmt.setString(2, customer.getFullName());
            pstmt.setString(3, customer.getLocation());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getDebit());
            pstmt.setString(6, customer.getCredit());
            pstmt.setString(7, customer.getPhone());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
