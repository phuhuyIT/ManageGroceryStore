package Controller;

import DAO.UserDAO;
import DatabaseConnection.ConnectionFactory;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    private static String loggedInUsername =null;
    public static void changeScence(ActionEvent event , String fxmlFile , String title , String username){
        Parent root = null;

        if(username !=null){
            try {
                FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(LoginController.class.getResource("views/" + fxmlFile));

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
                FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(LoginController.class.getResource(fxmlFile));

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
                FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("views/" + fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(username);

            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                root = FXMLLoader.load(LoginController.class.getResource("views/" + fxmlFile));

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
        User userdto=new User(username,password);
        UserDAO user=new UserDAO();
        if(password.equals(confirmPass)){
            user.addUserDAO(userdto);
            changeScence1(event, "views/hello-view.fxml", "Log In", null);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Password and ConfirmPassword are difference");
            alert.setTitle("Warning");
            alert.show();
        }
    }

    public static void LogInUser(ActionEvent event , String username , String password){
        String encrp=UserProfileController.encryptPassword(password);
        if(new ConnectionFactory().checkLogin(username,encrp)==true){
            changeScence(event, "homePage.fxml", "Welcome",username);
            loggedInUsername=username;
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Login");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
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
