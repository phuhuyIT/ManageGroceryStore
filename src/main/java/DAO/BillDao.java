package DAO;

import Model.InventoryAlert;
import DatabaseConnection.ConnectionFactory;
import Model.Bill;

import java.sql.*;

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
                InventoryAlert.informationAlert("Addition","SUCCESSFULLY ADDED NEW BILL");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public ResultSet selectALL(int Limit, int offSet) {
        try {
            String selectAllProduct = "SELECT \n" +
                    "  b.billID, \n" +
                    "  b.billCode, \n" +
                    "  b.revenue, \n" +
                    "  b.staffName,\n" +
                    "  b.customerName,\n" +
                    "  b.purchaseDate,\n" +
                    "  GROUP_CONCAT(DISTINCT CONCAT(productName,'|', quantity,'|',productRevenue ) SEPARATOR ', ') AS productList\n" +
                    "FROM billdetails b\n" +
                    "GROUP BY b.billID\n" +
                    "ORDER BY b.billID ASC\n" +
                    "LIMIT "+Limit+" OFFSET "+offSet;
            pstmt= con.prepareStatement(selectAllProduct);
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  rs;
    }
    public ResultSet getAllBill(){
        String query = "SELECT * FROM BILLDETAILS";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
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
    public ResultSet getRevenueByMonth(){
        //Câu truy vấn này sử dụng hàm DATE_FORMAT để định dạng cột purchaseDate thành chuỗi có định dạng 'YYYY-MM' để lấy thông tin theo tháng,
        // sau đó sử dụng hàm SUM để tính tổng doanh thu và nhóm kết quả theo tháng. Kết quả sẽ trả về một bảng với hai cột: "month" chứa tháng
        // (dưới dạng chuỗi 'YYYY-MM') và "total_revenue" chứa tổng doanh thu của tháng đó.
        String query="SELECT DATE_FORMAT(purchaseDate, '%Y-%m') AS month, SUM(revenue) AS totalRevenue  FROM bill GROUP BY month ORDER BY MONTH";
        try {
            pstmt=con.prepareStatement(query);
            rs= pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public float totalRevenueByMonth(){
        float totalRevenue=0;
        String query="SELECT SUM(revenue) AS totalRevenue FROM bill WHERE YEAR(purchaseDate) = YEAR(CURRENT_TIMESTAMP) AND MONTH(purchaseDate) = MONTH(CURRENT_TIMESTAMP)\n" +
                "GROUP BY MONTH(purchaseDate);\n";
        try {
            pstmt=con.prepareStatement(query);
            rs= pstmt.executeQuery();
            if(rs.next())
                totalRevenue=rs.getFloat("totalRevenue");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalRevenue;
    }
}
