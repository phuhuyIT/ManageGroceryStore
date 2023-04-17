package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateUserProfileController implements Initializable {
    @FXML
    private Label title;
    @FXML
    private Button btn_OK;

    @FXML
    private AnchorPane pane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_OK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("The information has been updated");
                alert.show();
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/user_profile.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                    pane.getChildren().add(node);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
