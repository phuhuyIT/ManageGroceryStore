package com.example.btl_demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedController implements Initializable {

    @FXML
    private Button btn_logout;

    @FXML
    private Label label_welcome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScence(actionEvent, "hello-view.fxml", "Log In", null);
            }
        });

    }

    public void setUserInformation(String username){
        label_welcome.setText("Welcome" + "  " +  username +"!");

    }
}
