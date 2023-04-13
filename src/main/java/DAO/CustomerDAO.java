package DAO;
import Model.Customer;
import DatabaseConnection.ConnectionFactory;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String findCustomerByID = "SELECT * FROM CUSTOMER WHERE CUSTOMERID = ?";
        try {
            pstmt.setInt(1,cus.getCustomersId());
            rs= pstmt.executeQuery(findCustomerByID);
            if(rs.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("This customer has already been added");
            }else{
                addFunction(cus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(Customer customer) {
        return 0;
    }

    @Override
    public int update(Customer customer) {
    return 0;
    }

    @Override
    public ArrayList<Customer> selectALL(Customer customer) {
        return null;
    }

    @Override
    public Customer selectByID(Customer customer) {
        return null;
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
