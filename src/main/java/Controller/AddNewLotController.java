package Controller;

import Model.DatePickerFormat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewLotController implements Initializable {
    @FXML
    private DatePicker dp_mfgnewLot;
    @FXML
    private DatePicker dp_expnewLot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatePickerFormat datePicker = new DatePickerFormat();
        datePicker.setDatePickerConverter(dp_mfgnewLot);
        datePicker.setDatePickerConverter(dp_expnewLot);

    }
}
