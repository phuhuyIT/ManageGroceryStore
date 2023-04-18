package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_Search;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ImageView img_back;
    @FXML
    private ImageView img_next;


    private String[] choice = {"A->Z" , "Z->A"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                choiceBox.getItems().addAll(choice);
    }
}
