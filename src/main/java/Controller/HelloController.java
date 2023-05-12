package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Hyperlink btn_signup;
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_loginGoogle;
    @FXML
    private Button btn_loginFB;
    @FXML
    public TextField tf_username;
    @FXML
    public PasswordField tf_password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login.LogInUser(event , tf_username.getText(), tf_password.getText());

            }
        });

        btn_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login.changeScence1(event , "views/RegisForm.fxml", "Sign Up", null);
            }
        });
    }
}