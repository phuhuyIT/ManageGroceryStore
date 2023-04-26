package DAO;

import DatabaseConnection.ConnectionFactory;
import Model.Category;
import Model.Product;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements DaoInterface <Category> {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs1=null;
    private Statement stmt1=null;
    private ResultSet rs = null;
    Stocks stocks = null;
    public CategoryDao(Connection conn) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
            stmt1=con.createStatement();
            stocks = new Stocks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thêm mới một danh mục sản phẩm vào cơ sở dữ liệu
    @Override
    public void insert(Category category) {
        try{
            String query = "SELECT * FROM products WHERE id=? AND name=?";
            pstmt.setInt(1,category.getId());
            pstmt.setString(2,category.getName());
            rs=pstmt.executeQuery(query);
            if(rs.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The same category has been added!");
                alert.show();
            }else{
                addFunction(category);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    // Cập nhật thông tin của một danh mục sản phẩm trong cơ sở dữ liệu
    public int update(Category category) {
        String sql = "UPDATE categories SET name=? WHERE id=?";
        int affectedRows = 0;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getId());
            affectedRows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    @Override
    // Xóa một danh mục sản phẩm khỏi cơ sở dữ liệu
    public int delete(String categoryCode) {
        String sql = "DELETE FROM categories WHERE CategoryCode=?";
        int affectedRows = 0;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, categoryCode);
            affectedRows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    @Override
    // Lấy danh mục sản phẩm từ cơ sở dữ liệu theo id
    public Category selectByID(int ID) {
        String sql = "SELECT * FROM categories WHERE ID=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("ID"));
                category.setName(rs.getString("name"));
                category.setProductList(getProductsByCategoryId(category.getId()));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addFunction(Category category) {
        int result;
        String url="insert into Category (ID, NAME, description, productList)"
                + "values (?,?,?,?)";
        try {
            pstmt = con.prepareStatement(url);
            pstmt.setInt(1,category.getId());
            pstmt.setString(2, category.getName());
            pstmt.setString(3, category.getDescription());
            pstmt.setObject(4, category.getProductList());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    // Lấy danh sách tất cả các danh mục sản phẩm từ cơ sở dữ liệu
    public ResultSet selectALL() {
        String sql = "SELECT * FROM categories";
        ArrayList<Category> categories = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Lấy danh sách các sản phẩm trong một danh mục sản phẩm từ cơ sở dữ liệu theo id
    private List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM category_products cp JOIN products p ON cp.product_id=p.id WHERE cp.category_id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt("productId"), rs.getString("productBarCode"), rs.getDate("date"), rs.getDate("sellDate")
                        , rs.getString("supplierCode"),rs.getString("productName"),rs.getInt("Quantity"), rs.getDouble("costPrice"),rs.getDouble("sellingPrice")
                        , rs.getString("brand"), rs.getInt("userID"), rs.getString("customerCode"), rs.getDouble("totalCost"),rs.getDouble("totalRevenue") );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }
}