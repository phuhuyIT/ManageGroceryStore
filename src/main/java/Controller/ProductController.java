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
    private ChoiceBox<String> choiceBox_sort;

    @FXML
    private ChoiceBox<String> choiceBox_list;

    private String[] choice = {"Tăng theo giá ", "Giảm theo giá" , "A->Z" , "Z->A"};

    private String[] list = {"Cake", "Noodle" , "Fast Food" , "Drinking" , "Ice Cream" , "Vegetable"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox_sort.getItems().addAll(choice);
        choiceBox_list.getItems().addAll(list);

    }
}
