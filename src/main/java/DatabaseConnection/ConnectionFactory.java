package DatabaseConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class ConnectionFactory {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public ConnectionFactory(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "123456");
            stmt=con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "123456");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public boolean checkLogin(String username,String password){
        String query="SELECT * FROM user WHERE USERNAME='"+username+"' AND PASS='"+password+"' LIMIT 1";
        try{
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }
}