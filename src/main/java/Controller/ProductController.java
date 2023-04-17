package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_Search;

    @FXML
    private ChoiceBox choiceBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> list = FXCollections.observableArrayList(
                "Tăng dần theo giá", "Giảm dần theo giá", "A->Z", "Z->A"
        );
         ChoiceBox<String> choiceBox = new ChoiceBox<>();
         choiceBox.setItems(list);


    }
}
