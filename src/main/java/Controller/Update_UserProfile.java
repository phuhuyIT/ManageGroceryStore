package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Update_UserProfile implements Initializable {
    @FXML
    private Label title;
    @FXML
    private Button btn_OK;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_OK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScence(actionEvent, "views/homePage.fxml", "Update", null);
            }
        });
    }
}
