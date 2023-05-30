package DAO;

import DatabaseConnection.ConnectionFactory;
import Model.Staff;
import Model.monthlySalary;

import java.sql.*;
import java.util.ArrayList;

import static Controller.InventoryAlert.errorAlert;
import static Controller.InventoryAlert.informationAlert;

public class StaffDAO implements DaoInterface<Staff>{
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs1=null;
    Statement stmt1=null;
    ResultSet rs = null;

    public static StaffDAO getInstance(){
        return new StaffDAO();
    }
    public StaffDAO(){
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
    public int insert(Staff staff) {
        try{
            String query = "SELECT id FROM staff WHERE staffIDCard=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, staff.getStaffIDCard());
            rs=pstmt.executeQuery();
            if(rs.next()){
                errorAlert("ERROR","THIS PRODUCT HAS BEEN ADDED!");
                return 0;
            }else{
                addFunction(staff);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int delete(int id) throws SQLException {
        String deleteProduct= "DELETE FROM staff\n" +
                "WHERE id = ?\n" +
                "AND id NOT IN (SELECT DISTINCT staffID FROM bill);";
        int result;
        try {
            pstmt = con.prepareStatement(deleteProduct);
            pstmt.setInt(1,id);
            result=pstmt.executeUpdate();
            if(result==0)
                errorAlert("Error","YOU CANNOT REMOVE THIS STAFF BECAUSE THE INVOICE DETAILS IS REFERRED TO");
            else
                informationAlert("Success","DELETE SUCCESSFUL");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Staff staff) {
        String updateCustomerDetails= "UPDATE staff SET position=?, phone=?, EMAIL=?,avatarLink=?,location=?,basicSalary=? WHERE  id= ?";
        int result;
        try {
            System.out.println(staff.getAvatarLink());
            pstmt = con.prepareStatement(updateCustomerDetails);
            pstmt.setString(1, staff.getPosition());
            pstmt.setString(2, staff.getPhone());
            pstmt.setString(3, staff.getEmail());
            pstmt.setString(4, staff.getAvatarLink());
            pstmt.setString(5, staff.getLocation());
            pstmt.setFloat(6,staff.getBasicSalary());
            pstmt.setFloat(7, staff.getId());
            result=pstmt.executeUpdate();
            if(result>0)
                informationAlert("Sucessful","THIS CUSTOMER INFORMATION HAS BEEN UPDATED SUCCESSFULLY");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public ResultSet selectALL(int Limit, int offSet) {
        try {
            String selectAllProduct = "SELECT ID, fullname, position, joinDate, avatarLink FROM staff ORDER BY id ASC LIMIT "+Limit+" OFFSET "+offSet;
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
            String selectByID_query = "SELECT * FROM staff WHERE id =? ";
            pstmt= con.prepareStatement(selectByID_query);
            pstmt.setInt(1,ID);
            rs =pstmt.executeQuery();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public int addFunction(Staff staff) {
        int result = 0;
        try {
            String url = "insert into staff (fullname, gender, staffIDCard, position , phone, joinDate, EMAIL, avatarLink, Birthdate, basicSalary, location)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(url);
            pstmt.setString(1, staff.getFullName());
            if(staff.getGender().equals("Nam"))
                pstmt.setInt(2,0);
            else if (staff.getGender().equals("Nữ"))
                pstmt.setInt(2,1);
            else pstmt.setInt(2,2);
            pstmt.setString(3, staff.getStaffIDCard());
            pstmt.setString(4, staff.getPosition());
            pstmt.setString(5, staff.getPhone());
            pstmt.setDate(6, Date.valueOf(staff.getJoinDate()));
            pstmt.setString(7, staff.getEmail());
            pstmt.setString(8, staff.getAvatarLink());
            pstmt.setDate(9, Date.valueOf(staff.getBirthDate()));
            pstmt.setDate(9, Date.valueOf(staff.getBirthDate()));
            pstmt.setFloat(10,staff.getBasicSalary());
            pstmt.setString(11,staff.getLocation());
            result = pstmt.executeUpdate();
            if(result>0)
                informationAlert("Sucessful","THIS STAFF HAS BEEN ADDED SUCCESSFULLY");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public void addMonthlySalary(monthlySalary staff){
        /*String checkSalary ="Select id FROM monthly_salary WHERE staffid=? AND monthSalary=?";*/
        int affectedRow=0;
        try {
            /*pstmt = con.prepareStatement(checkSalary);
            pstmt.setInt(1,staff.getId());
            System.out.println("Date: "+ staff.getMonthSalary().toString());
            pstmt.setDate(2, Date.valueOf(staff.getMonthSalary()));
            rs=pstmt.executeQuery();*/
            rs= isHasThisMonthSalary(staff.getID());
            if(rs.next()){
                String sql = "UPDATE monthly_salary SET monthSalary=?, workingHours=?, overtimeHours=?, allowance=?, deduction=? WHERE id=?";
                pstmt = con.prepareStatement(sql);

                // Thiết lập các tham số truy vấn
                pstmt.setDate(1, Date.valueOf(staff.getMonthSalary()));
                pstmt.setInt(2, staff.getWorkingHours());
                pstmt.setInt(3, staff.getOvertimeHours());
                pstmt.setFloat(4, staff.getAllowance());
                pstmt.setFloat(5, staff.getDeduction());
                pstmt.setInt(6, staff.getID());
                // Thực thi truy vấn
                affectedRow = pstmt.executeUpdate();
                if(affectedRow>0)
                    informationAlert("Success","SUCCESSFULLY UPDATE MONTHLY SALARY"+staff.getMonthSalary());
            }else{
                String sql = "INSERT INTO monthly_salary (staffid, workingHours, overtimeHours, allowance, deduction,monthSalary) VALUES (?, ?, ?, ?, ?, ?)";
                try {
                    pstmt = con.prepareStatement(sql);
                    // Thiết lập các tham số truy vấn
                    pstmt.setInt(1, staff.getID());
                    pstmt.setInt(2, staff.getWorkingHours());
                    pstmt.setInt(3, staff.getOvertimeHours());
                    pstmt.setFloat(4, staff.getAllowance());
                    pstmt.setFloat(5, staff.getDeduction());
                    pstmt.setDate(6, Date.valueOf(staff.getMonthSalary()));
                    // Thực thi truy vấn
                    affectedRow = pstmt.executeUpdate();
                    if(affectedRow>0)
                        informationAlert("Success","SUCCESSFULLY CREATE NEW MONTHLY SALARY"+staff.getMonthSalary());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int getNumStaff(){
        String query="SELECT COUNT(id) as numberStaff FROM staff";
        int numberProduct=0;
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            if(rs.next())
                numberProduct=rs.getInt("numberStaff");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numberProduct;
    }
    public ResultSet getTop5StaffRevenues(){
        try {
            CallableStatement cstmt = con.prepareCall("{ CALL getTop5StaffRevenues() }");
            rs = cstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public ResultSet isHasThisMonthSalary(int ID){
        String checkSalary ="SELECT * FROM monthly_salary\n" +
                "WHERE staffid = ? \n" +
                "AND MONTH(monthSalary) = MONTH(NOW()) \n" +
                "AND YEAR(monthSalary) = YEAR(NOW())\n";
        try {
            pstmt = con.prepareStatement(checkSalary);
            pstmt.setInt(1,ID);
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public ArrayList<Staff> search(String searchValue, String searchFilter){
        ArrayList<Staff> staffSearchList= new ArrayList<>();
        String fullTextSearches="SELECT FULLNAME,joinDate,ID,POSITION,avatarLink\n" +
                "FROM staff\n" +
                "WHERE MATCH("+searchFilter+") AGAINST (?);\n";
        searchValue = "\"" + searchValue.trim() + "\"";
        try {
            pstmt = con.prepareStatement(fullTextSearches);
            pstmt.setString(1,searchValue);
            rs = pstmt.executeQuery();
            while (rs.next())
                staffSearchList.add(new Staff(rs.getString("FULLNAME"), rs.getDate("joinDate").toLocalDate(), rs.getInt("ID"),rs.getString("POSITION"),rs.getString("avatarLink")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffSearchList;
    }
    public int getID(String fullname){
        String query ="SELECT id FROM staff WHERE fullname = ?";
        int cid=0;
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1,fullname);
            rs = pstmt.executeQuery();
            if(rs.next())
                cid = rs.getInt("id");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cid;
    }
}
