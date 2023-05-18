package Controller;

import DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChangePassController implements Initializable {

    @FXML
    private Button btn_update;
    @FXML
    private TextField tf_oldPassword;
    @FXML
    private TextField tf_confirmPassword;
    @FXML
    private TextField tf_newPassword;
    @FXML
    private AnchorPane pane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                UserDAO user = new UserDAO();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                ResultSet rs =user.getPassword(LoginController.getLoggedInUsername(),tf_oldPassword.getText());
                try {
                    if(tf_newPassword.getText().equals(tf_confirmPassword.getText()) && rs.next()){

                        user.changePassword(LoginController.getLoggedInUsername(),tf_newPassword.getText());
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/user_profile.fxml"));
                        Node node = null;
                        try {
                            node = loader.load();
                            pane.getChildren().add(node);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (!rs.next()) {

                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter the correct old password");

                        alert.showAndWait();
                    } else {
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter the correct confirm password field");

                        alert.showAndWait();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
