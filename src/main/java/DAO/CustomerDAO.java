package DAO;
import Model.InventoryAlert;
import Model.Customer;
import DatabaseConnection.ConnectionFactory;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO extends InventoryAlert implements DaoInterface <Customer>{
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
        String findCustomerByNameLocatePhone = "SELECT cid FROM CUSTOMERs WHERE citizenIDNumber =?";
        try {
            pstmt = con.prepareStatement(findCustomerByNameLocatePhone);
            pstmt.setString(1,cus.getCitizenIDNumber());
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
    public int delete(int cid) {
        String deleteCustomerDetails= "DELETE FROM customers\n" +
                "WHERE cid = ?\n" +
                "AND cid NOT IN (SELECT DISTINCT customerID FROM bill);";
        int result;
        try {
            pstmt = con.prepareStatement(deleteCustomerDetails);
            pstmt.setInt(1,cid);
            result=pstmt.executeUpdate();
            if(result==0)
                errorAlert("Error","YOU CANNOT REMOVE THIS CUSTOMER BECAUSE THE INVOICE DETAILS IS REFERRED TO");
            else
                informationAlert("Success","DELETE SUCCESSFUL");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Customer customer) {
        String updateCustomerDetails= "UPDATE CUSTOMERS SET location=?, phone=?, EMAIL=?, avatarLink=? WHERE  cid= ?";
        int result;
        try {
            pstmt = con.prepareStatement(updateCustomerDetails);
            pstmt.setString(1, customer.getLocation());
            pstmt.setString(2, customer.getPhone());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAvatarLink());
            pstmt.setInt(5,customer.getCustomersId());
            result=pstmt.executeUpdate();
            if(result>0)
                InventoryAlert.informationAlert("Sucessful","THIS CUSTOMER INFORMATION HAS BEEN UPDATED SUCCESSFULLY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ResultSet selectALL(int Limit, int offSet) {
        try {
            String sql= "SELECT * FROM CUSTOMERS LIMIT "+Limit+" OFFSET "+offSet;
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
            String selectByID_query = "SELECT * FROM CUSTOMERS WHERE cid =?";
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
            String url = "insert into CUSTOMERS (citizenIDNumber, gender, fullname, location, phone, EMAIL, avatarLink, Birthdate)"
                    + "values (?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(url);
            pstmt.setString(1, customer.getCitizenIDNumber());
            System.out.println("");
            System.out.println("Gender:"+customer.getGender());
            if(customer.getGender().equals("Nam"))
                pstmt.setInt(2,0);
            else if (customer.getGender().equals("Nữ"))
                pstmt.setInt(2,1);
            else pstmt.setInt(2,2);
            pstmt.setString(3, customer.getFullName());
            pstmt.setString(4, customer.getLocation());
            pstmt.setString(5, customer.getPhone());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getAvatarLink());
            pstmt.setString(8,customer.getBirthDate());
            result = pstmt.executeUpdate();
            if(result>0)
                InventoryAlert.informationAlert("Sucessful","THIS CUSTOMER HAS BEEN ADDED SUCCESSFULLY");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public int getNumCustomer(){
        String query="SELECT COUNT(cid) as numberCustomer FROM customers";
        int numberCustomer=0;
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            if(rs.next())
                numberCustomer=rs.getInt("numberCustomer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberCustomer;
    }
    public ResultSet getTop5CustomerRevenues(){
        try {
            CallableStatement cstmt = con.prepareCall("{ CALL top5CustomersRevenues() }");
            rs = cstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public ArrayList<Customer> search(String searchValue, String searchFilter){
        ArrayList<Customer> customerSearchList= new ArrayList<>();
        String fullTextSearches="SELECT FULLNAME,GENDER,cid,PHONE,AVATARLINK\n" +
                "FROM customers\n" +
                "WHERE MATCH("+searchFilter+") AGAINST (?);\n";
        searchValue = "\"" + searchValue.trim() + "\"";
        try {
            pstmt = con.prepareStatement(fullTextSearches);
            pstmt.setString(1,searchValue);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String gender;
                if (0 != rs.getInt("GENDER")) {
                    gender= "Nữ";
                }else gender="Nam";
                customerSearchList.add(new Customer(rs.getString("fullname"), gender, rs.getInt("cid"),rs.getString("PHONE"),rs.getString("AVATARLINK")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerSearchList;
    }
}
