package Controller;

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
import java.util.ResourceBundle;

public class ChangeInformationController implements Initializable {

    @FXML
    private TextField txt_fullname;
    @FXML
    private TextField txt_phone;
    @FXML
    private TextField txt_location;
    @FXML
    private TextField txt_category;
    @FXML
    private Button btn_update;

    @FXML
    private AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update");
                alert.setHeaderText(null);
                alert.setContentText("Updated Information Success!");
                alert.showAndWait();
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/user_profile.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pane.getChildren().add(node);
            }
        });
    }
}
