package Controller;

import DAO.UserDAO;
import DatabaseConnection.ConnectionFactory;
import Model.InventoryAlert;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Login extends InventoryAlert {
    private static String loggedInUsername =null;
    public static void changeScence(ActionEvent event , String fxmlFile , String title , String username){
        Parent root = null;

        if(username !=null){
            try {
                FXMLLoader loader = new FXMLLoader(Login.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException | SQLException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(Login.class.getResource("views/" + fxmlFile));

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage .setTitle(title);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        //stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(new Scene(root,1300, 900));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }
    public static void changeScence1(ActionEvent event , String fxmlFile , String title , String username){
        Parent root = null;

        if(username !=null){
            try {
                FXMLLoader loader = new FXMLLoader(Login.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException | SQLException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(Login.class.getResource(fxmlFile));

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage .setTitle(title);
        stage.setMaximized(true);
        stage.setFullScreen(true);
        //stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(new Scene(root,620, 670));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }
    public static void changeScence2(ActionEvent event , String fxmlFile , String title , String username){
        Parent root = null;

        if(username !=null){
            try {
                FXMLLoader loader = new FXMLLoader(Login.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException | SQLException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(Login.class.getResource("views/" + fxmlFile));

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
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void SignUpUser(ActionEvent event , String username, String password, String confirmPass) {
        User userdto=new User(username,password);
        UserDAO user=new UserDAO();
        if(password.equals(confirmPass)){
            user.addUserDAO(userdto);
            changeScence1(event, "views/hello-view.fxml", "Log In", null);
        }else{
            errorAlert("ERROR","PASSWORD AND CONFIRMPASSWORD ARE DIFFERENCE!");
        }
    }

    public static void LogInUser(ActionEvent event , String username , String password){
        String encrp= UserProfile.encryptPassword(password);
        if(new ConnectionFactory().checkLogin(username,encrp)==true){
            changeScence(event, "homePage.fxml", "Welcome",username);
            loggedInUsername=username;
        }else{
            errorAlert("Invalid Login","Invalid username or password");
        }
    }

    public static String getLoggedInUsername(){
        if(loggedInUsername!=null)
            return loggedInUsername;
        return null;
    }
//lấy link ảnh avatar vào database
    public static void Update_Infor(ActionEvent event ,User user) throws SQLException{
        UserDAO userdao=new UserDAO();
        userdao.editFunction(user);
}


}
