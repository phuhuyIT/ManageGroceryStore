package Controller;

import DAO.ProductDAO;
import Model.DatePickerFormat;
import Model.Product;
import Model.productLot;
import Oauth2.Verification;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.DatePicker;
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
            if(Verification.isValidQuantity(Integer.valueOf(tf_quantity.getText())) == false){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid number of quantity");
                alert.setContentText("Quantity must be greater than 0");
                alert.showAndWait();
            }
            else if(Verification.isValidManufactureDate(dp_mfgnewLot.getValue(), dp_expnewLot.getValue()) == false){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid date");
                alert.setContentText("Manufacture date must be before expiration date");
                alert.showAndWait();
            }
            else if(Verification.isValidExpirationDate(dp_mfgnewLot.getValue(), dp_expnewLot.getValue()) == false){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid date");
                alert.setContentText("Expiration date must be after manufacture date");
                alert.showAndWait();
            }
            else{
                int id =ProductController.getCurrentItemID();
                new ProductDAO().addProductBatch(new Product(new productLot(new ProductDAO().getProductBarCodeByID(id), id, dp_mfgnewLot.getValue(), dp_expnewLot.getValue(), Integer.valueOf(tf_quantity.getText()))));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Add new lot successfully");
                alert.showAndWait();
            }
        });
    }
}
