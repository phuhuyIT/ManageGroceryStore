package Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CaculatorController implements Initializable {
    @FXML
    private AnchorPane pane_Sell;
    @FXML
    private Button btn_cash;
    @FXML
    private CheckBox select_all;
    @FXML
    private HBox select_Product1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_cash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/cash.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pane_Sell.getChildren().add(node);
            }
        });

        //set sự kiện Select All
        select_all.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    select_Product1.setStyle("-fx-background-color : #BBBBBB");

                }else{
                    select_Product1.setStyle("-fx-background-color : #FFFFFF");
                }
            }
        });

    }
}
