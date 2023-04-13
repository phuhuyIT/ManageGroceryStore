package DAO;
import Model.Customer;
import DatabaseConnection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
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
    public int insert(Customer customer) {
        int result;
        String url="insert into CUSTOMER (CUSTOMERID, FULLNAME, LOCATION, EMAIL, DEBIT, CREDIT, PHONE) values (1000, 'PHU HUY', 'Wenhe', 'DHGA0@wix.com', 1021, 1208, '123 456 7890')";
        try {
            pstmt = con.prepareStatement(url);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
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
}
