package DAO;

import Controller.AlertAndVerifyController;
import DatabaseConnection.ConnectionFactory;
import Model.Bill;
import Model.CameraApp;

import java.sql.*;
import java.util.ArrayList;

public class BillDao implements DaoInterface <Bill> {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs1=null;
    private Statement stmt1=null;
    private ResultSet rs = null;
    public BillDao() {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
            stmt1=con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int insert(Bill bill)  {
        addFunction(bill);
        return 1;
    }

    @Override
    public int delete(int billID) throws SQLException {
        String deleteProduct= "DELETE FROM PRODUCTS WHERE billID= ?";
        int result;
        try {
            pstmt = con.prepareStatement(deleteProduct);
            pstmt.setInt(1,billID);
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Override
    public int update(Bill bill) {
        return 0;
    }

    @Override
    public int addFunction(Bill bill) {
        int result=0;

        try {
            String addBill="INSERT INTO bill (billcode)"+"VALUE(?)";
            pstmt = con.prepareStatement(addBill);
            pstmt.setString(1,bill.getBillCode());
            pstmt.executeUpdate();
            String getBillID ="SELECT LAST_INSERT_ID()";
            rs=pstmt.executeQuery(getBillID);
            int billID=0;
            if(rs.next()) {
                billID = rs.getInt("LAST_INSERT_ID()");
            }
            String addDetailBill= "INSERT INTO detailBill (billID, productID, customerID, staffID, quantity)"
                    +"VALUE(?,?,?,?,?)";
            pstmt = con.prepareStatement(addDetailBill);
            pstmt.setInt(1,billID);
            pstmt.setInt(2,bill.getProductID());
            pstmt.setInt(3,bill.getCustomerID());
            pstmt.setInt(4,bill.getStaffID());
            pstmt.setInt(5,bill.getPurchaseQuantity());
            result=pstmt.executeUpdate();
            if(result>1)
                AlertAndVerifyController.informationAlert("Addition","SUCCESSFULLY ADDED NEW BILL");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public ResultSet selectALL(int Limit, int offSet) {
        try {
            String selectAllProduct = "SELECT b.billCode, b.purchaseDate, b.revenue, SUM(d.quantity) AS totalQuantity\n" +
                    "FROM bill AS b\n" +
                    "JOIN detailBill AS d ON b.billCode = d.billCode\n" +
                    "GROUP BY b.billCode\n" +
                    "LIMIT "+Limit+" OFFSET "+offSet;
            pstmt= con.prepareStatement(selectAllProduct);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  rs;
    }
    @Override
    public ResultSet selectByID(int ID) {
        try {
            String selectByID_query = "SELECT * FROM CUSTOMERS WHERE billID =?";
            pstmt= con.prepareStatement(selectByID_query);
            pstmt.setInt(1,ID);
            rs = pstmt.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
