package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBUtils {
    public static void changeScence(ActionEvent event , String fxmlFile , String title , String username){
        Parent root = null;

        if(username !=null){
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(DBUtils.class.getResource("views/" + fxmlFile));

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage .setTitle(title);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        //stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(new Scene(root,1280, 720));
      //  stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    public static void changeScence1(ActionEvent event , String fxmlFile , String title , String username){
        Parent root = null;

        if(username !=null){
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage .setTitle(title);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        //stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(new Scene(root,650, 450));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    public static void changeScence2(ActionEvent event , String fxmlFile , String title , String username){
        Parent root = null;

        if(username !=null){
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(DBUtils.class.getResource("views/" + fxmlFile));

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage .setTitle(title);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        //stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(new Scene(root,1000, 900));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public static void SignUpUser(ActionEvent event , String username, String password, String confirmPass) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "123456");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM user WHERE USERNAME = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You can not use this username.");
                alert.show();
            } else {
                if (confirmPass.equals(password)){
                    psInsert = connection.prepareStatement("INSERT INTO user (USERNAME , PASS, AVATAR_SRC) VALUES (?,?,?) ");
                    psInsert.setString(1, username);
                    psInsert.setString(2, password);
                    psInsert.setString(3, "D:/workspace/BTL_demo/src/main/resources/Controller/image/user_1.png");
                    psInsert.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Sign Up Success");
                    alert.setTitle("Success");
                    alert.show();
                    changeScence1(event, "hello-view.fxml", "Log In", null);
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Password and ConfirmPassword are difference");
                    alert.setTitle("Warning");
                    alert.show();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(psCheckUserExists != null){
                try{
                    psCheckUserExists.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (psInsert != null){
                try{
                    psInsert.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void LogInUser(ActionEvent event , String username , String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =  null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "123456");
            preparedStatement = connection.prepareStatement("SELECT PASS FROM user WHERE USERNAME = ?");
            preparedStatement.setString(1, username);
            resultSet=preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                System.out.println("User not found in database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect!");
                alert.show();
            }else{
                while(resultSet.next()){
                    String retrievedPassword = resultSet.getString("PASS");
                    if (retrievedPassword.equals(password)){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("Login Success ! ");
                        alert.setTitle("Login Success");
                        alert.show();
                        changeScence(event, "homePage.fxml", "Welcome",username);
                    }else{
                        System.out.println("Pass did not match ");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided credentials are incorrect");
                        alert.show();
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

//lấy link ảnh avatar vào database
    public static void Update_Infor(ActionEvent event ,String src_imageuser,String fullname,String phone , String location , String category, String username, String pass) throws SQLException{
        Connection connection = null;
        PreparedStatement psUpdate = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "123456");

           // resultSet = psCheckUserExists.executeQuery();
            psUpdate = connection.prepareStatement("UPDATE user SET AVATAR_SRC = ? , FULL_NAME  = ? , PHONE = ? , LOCATION = ? , CATEGORY = ? WHERE USERNAME = ? AND PASS = ? ");
            psUpdate.setString(1, src_imageuser);
            psUpdate.setString(2, fullname);
            psUpdate.setString(3, phone);
            psUpdate.setString(4, location);
            psUpdate.setString(5, category);
            psUpdate.setString(6, username);
            psUpdate.setString(7, pass);
            psUpdate.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (psUpdate != null){
                try{
                    psUpdate.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
}


}
