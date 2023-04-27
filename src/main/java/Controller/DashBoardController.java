package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    @FXML
    private Label title;

    @FXML
    private Label num_customer;
    @FXML
    private Label num_product;
    @FXML
    private Label num_category;
    @FXML
    private Label num_revenue;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
