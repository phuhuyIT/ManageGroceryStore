package com.example.btl_demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btn_login;

    @FXML
    private Hyperlink btn_signup;

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            btn_login.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    DBUtils.LogInUser(event , tf_username.getText(), tf_password.getText());
                }
            });

            btn_signup.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    DBUtils.changeScence(event , "RegisForm.fxml", "Sign Up", null);
                }
            });
    }
}