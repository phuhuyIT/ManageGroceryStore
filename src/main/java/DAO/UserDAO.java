package DAO;

import Model.InventoryAlert;
import Controller.LoginController;
import Controller.UserProfileController;
import DatabaseConnection.ConnectionFactory;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/***
 * Refactoring name: PULL UP METHOD
 * To remove duplication of code for the method buildTableModel() in both classes UserDAO.java and SupplierDAO.java,
 * Pull up method refactoring is performed and method is pulled from both classes and is kept in the new class BuildTableModel.java class
 * The class BuildTableModel.java is then extended to two classes UserDAO.java and SupplierDAO.java.*/


public class UserDAO extends InventoryAlert {

    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    public UserDAO() {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addUserDAO(User userdto) {
        try{
            String query = "SELECT username, password FROM users WHERE USERNAME=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userdto.getUsername());
            rs=pstmt.executeQuery();
            if(rs.next()){
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
                alert.setTitle("Duplicate User");
                alert.setHeaderText(null);
                alert.setContentText("Same User has already been added!");
                alert.showAndWait();
            }else{
                addFunction(userdto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//end of method addUser

    public void addFunction(User userdto){
        try{
            String email = userdto.getEmail();
            String username = userdto.getUsername();
            String password = userdto.getPassword();
            //String oldUsername = null;
            String encPass=null;
            String query1="SELECT username, password FROM users";
            rs=pstmt.executeQuery(query1);
            encPass=new UserProfileController().encryptPassword(password);
            String queryTemp = "INSERT INTO users (username, password, email) VALUES(?,?, ?)";
            pstmt = con.prepareStatement(queryTemp);
            pstmt.setString(1, username);
            pstmt.setString(2, encPass);
            pstmt.setString(3, email);

            pstmt.executeUpdate();
            if("ADMINISTRATOR".equals("ADMINISTRATOR")){
                informationAlert("AdministratorAdded","NEW ADMINISTRATOR ADDED");
            }

            else{
                informationAlert("Normal User Added","NEW NORMAL USER ADDED");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void editUserDAO(User userdto) {
        try {
            String query = "UPDATE users SET fullname=?,location=?,phone=?,category=? WHERE username=?";
            pstmt = (PreparedStatement) con.prepareStatement(query);
            pstmt.setString(1, userdto.getFullName());
            pstmt.setString(2, userdto.getLocation());
            pstmt.setString(3, userdto.getPhone());
            pstmt.setString(4, userdto.getCategory());
            pstmt.setString(5, userdto.getUsername());
            pstmt.executeUpdate();
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Update");
            alert.setHeaderText(null);
            alert.setContentText("Updated");

            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of method editUser

    public void editFunction(User userdto){ /* File file*/

        try{
            if(userdto.getImageLink().equals("")) {

            } else {
                String query = "UPDATE users SET fullname=?,location=?,phone=?,category=?,image=?,email=? WHERE username=?";
                //FileInputStream fis=new FileInputStream(file);
                pstmt = (PreparedStatement) con.prepareStatement(query);
                pstmt.setString(1, userdto.getFullName());
                pstmt.setString(2, userdto.getLocation());
                pstmt.setString(3, userdto.getPhone());
                pstmt.setString(4, userdto.getCategory());
                pstmt.setString(5,userdto.getImageLink());
                pstmt.setString(6, userdto.getEmail());
                pstmt.setString(7, LoginController.getLoggedInUsername());
                pstmt.executeUpdate();
                informationAlert("Update","UPDATED");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String value){
        try{
            String query="delete from users where username=?";
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,value);
            pstmt.executeUpdate();
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Delete status");
            alert.setHeaderText(null);
            alert.setContentText("Deleted...");
            alert.showAndWait();

        }catch(SQLException  e){
        }
    }

    public ArrayList<User> selectALL() {
        ArrayList<User> result= new ArrayList<User>();
        try {
            String selectAllInformation= "SELECT fullname,location,phone,username,category, imgLink FROM users";
            pstmt= con.prepareStatement(selectAllInformation);
            rs = pstmt.executeQuery();
            while (rs.next()){
                String fname=rs.getString("FULLNAME");
                String location=rs.getString("LOCATION");
                String phone=rs.getString("PHONE");
                String userName=rs.getString("USERNAME");
                String category=rs.getString("CATEGORY");
                String imgLink=rs.getString("IMGLINK");
                User cus=new User(fname,location,phone,userName,category,imgLink);
                result.add(cus);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ResultSet getUser(String user){
        try {
            String query = "SELECT * FROM users WHERE username='"+user+"'";
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getPassword(String user, String pass){
        try {
            String encPass = new UserProfileController().encryptPassword(pass);
            String query = "SELECT password FROM users WHERE username='"+user+"' AND password='"+encPass+"'";
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getQueryResult1(String username) {
        try {
            String query = "SELECT fullname,location,phone,email,category,IMAGE FROM users Where username=?";
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,username);
            rs =pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public void changePassword(String user, String pass){
        try{
            String query="UPDATE users SET password=? WHERE username=?";
            pstmt=con.prepareStatement(query);
            String encPass = new UserProfileController().encryptPassword(pass);
            pstmt.setString(1, encPass);
            pstmt.setString(2, user);
            pstmt.executeUpdate();
            informationAlert("Update","YOUR PASSWORD HAS BEEN UPDATED!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public User getUserByEmail(String email) {
        User user =null;
        try {
            String query = "SELECT * FROM users WHERE email='"+email+"'";
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
