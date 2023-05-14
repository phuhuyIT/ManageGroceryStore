package Controller;

import DAO.ProductDAO;
import Model.DatePickerFormat;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewLotController implements Initializable {

    @FXML
    private Button btn_save;

    @FXML
    private DatePicker dp_mfgnewLot;

    @FXML
    private DatePicker dp_expnewLot;

    @FXML
    private TextField tf_quantity;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatePickerFormat datePicker = new DatePickerFormat();
        datePicker.setDatePickerConverter(dp_mfgnewLot);
        datePicker.setDatePickerConverter(dp_expnewLot);

        btn_save.setOnAction(ActionEvent -> {
            new ProductDAO().addProductBatch(new Product(ProductController.getCurrentItemID(), dp_mfgnewLot.getValue(), dp_expnewLot.getValue(), Integer.valueOf(tf_quantity.getText())));
        });
    }
}
