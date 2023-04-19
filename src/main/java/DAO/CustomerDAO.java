package DAO;
import Model.Customer;
import DatabaseConnection.ConnectionFactory;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
public class CustomerDAO implements DaoInterface <Customer>{
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
    public void insert(Customer cus) {
        String findCustomerByNameLocatePhone = "SELECT * FROM CUSTOMER WHERE FULLNAME=? AND LOCATION=? AND PHONE=?";
        try {
            pstmt = con.prepareStatement(findCustomerByNameLocatePhone);
            pstmt.setString(1,cus.getFullName());
            pstmt.setString(2,cus.getLocation());
            pstmt.setString(3,cus.getPhone());
            rs= pstmt.executeQuery();
            if(rs.next()){
                System.out.println("This customer has already been added");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Password and ConfirmPassword are difference");
//                alert.setTitle("Warning");
//                alert.show();
            }else{
                addFunction(cus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(Customer customer) {
        String deleteCustomerDetails= "DELETE FROM CUSTOMER WHERE CUSTOMERID= ?";
        int result;
        try {
            pstmt = con.prepareStatement(deleteCustomerDetails);
            pstmt.setInt(1,customer.getCustomersId());
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
    public ArrayList<Customer> selectALL() {
        ArrayList<Customer> result= new ArrayList<Customer>();
        try {
            String selectAllInformation= "SELECT * FROM CUSTOMER";
            pstmt= con.prepareStatement(selectAllInformation);
            rs = pstmt.executeQuery();
            while (rs.next()){
                int id=rs.getInt("CUSTOMERID");
                String fname=rs.getString("FULLNAME");
                String location=rs.getString("LOCATION");
                String phone=rs.getString("PHONE");
                String debit=rs.getString("DEBIT");
                String credit=rs.getString("CREDIT");
                String email=rs.getString("EMAIL");
                Customer cus=new Customer(id,"cc",fname,location,phone,debit, credit,email);
                result.add(cus);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Customer selectByID(Customer customer) {
        Customer result = null;
        try {
            String selectByID_query = "SELECT * FROM CUSTOMER WHERE CUSTOMERID =?";
            pstmt= con.prepareStatement(selectByID_query);
            pstmt.setInt(1,customer.getCustomersId());
            rs = pstmt.executeQuery();
            while (rs.next()){
                int id=rs.getInt("CUSTOMERID");
                String fname=rs.getString("FULLNAME");
                String location=rs.getString("LOCATION");
                String phone=rs.getString("PHONE");
                String debit=rs.getString("DEBIT");
                String credit=rs.getString("CREDIT");
                String email=rs.getString("EMAIL");
                result = new Customer (id,"cc",fname,location,phone,debit, credit,email);

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    @Override
    public int addFunction(Customer cus) {
        int result;
        String url="insert into CUSTOMER (CUSTOMERID, FULLNAME, LOCATION, EMAIL, DEBIT, CREDIT, PHONE)"
                    + "values (?,?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(url);
            pstmt.setInt(1,cus.getCustomersId());
            pstmt.setString(2, cus.getFullName());
            pstmt.setString(3, cus.getLocation());
            pstmt.setString(4, cus.getEmail());
            pstmt.setString(5,cus.getDebit());
            pstmt.setString(6,cus.getCredit());
            pstmt.setString(7,cus.getPhone());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;    }
}
