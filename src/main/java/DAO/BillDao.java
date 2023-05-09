package DAO;

import Model.Bill;

import java.sql.*;
import java.util.ArrayList;

public class BillDao implements DaoInterface <Bill> {
    private final Connection connection;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs1=null;
    ResultSet rs = null;
    public BillDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public int insert(Bill bill)  {
        String sql = "INSERT INTO bills (name, amount, due_date) VALUES (?, ?, ?)";
        try {
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bill.getName());
            pstmt.setBigDecimal(2, bill.getAmount());
            pstmt.setDate(3, bill.getDueDate());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating bill failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    bill.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating bill failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public int delete(String t) throws SQLException {
        return 0;
    }

    public int update(Bill bill) {
        String sql = "UPDATE bills SET name = ?, amount = ?, due_date = ?, paid = ? WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, bill.getName());
            pstmt.setBigDecimal(2, bill.getAmount());
            pstmt.setDate(3, bill.getDueDate());
            pstmt.setBoolean(4, bill.isPaid());
            pstmt.setInt(5, bill.getId());

            return  pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet selectALL(int Limit, int offSet) {
        return null;
    }


    @Override
    public int addFunction(Bill bill) {
        return 0;
    }

    public int delete(Bill bill) throws SQLException {
        String sql = "DELETE FROM bills WHERE id = ?";
        pstmt = connection.prepareStatement(sql);

        pstmt.setInt(1, bill.getId());

        int affectedRows = pstmt.executeUpdate();
        return affectedRows;
    }
    @Override
    public ResultSet selectALL() {
        String sql = "SELECT * FROM bills";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            ArrayList<Bill> bills = new ArrayList<>();

            while (rs.next()) {
                Bill bill = new Bill();

                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setAmount(rs.getBigDecimal("amount"));
                bill.setDueDate(rs.getDate("due_date"));
                bill.setPaid(rs.getBoolean("paid"));
                bill.setCreatedAt(rs.getTimestamp("created_at"));
                bill.setUpdatedAt(rs.getTimestamp("updated_at"));

                bills.add(bill);
            }
            return (ResultSet) bills;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public ResultSet selectByID(int ID) {
        String sql = "SELECT * FROM bills WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, ID);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                Bill bill = new Bill();

                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setAmount(rs.getBigDecimal("amount"));
                bill.setDueDate(rs.getDate("due_date"));
                bill.setPaid(rs.getBoolean("paid"));
                bill.setCreatedAt(rs.getTimestamp("created_at"));
                bill.setUpdatedAt(rs.getTimestamp("updated_at"));

                return (ResultSet) bill;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
