package Controller;

import DAO.ProductDAO;
import DatabaseConnection.ConnectionFactory;
import Model.Product;
import Model.productLot;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class AddOldLotController implements Initializable {

    @FXML
    private Button btn_save;

    @FXML
    private ChoiceBox cb_selectBatch;

    @FXML
    private TextField tf_newQuantity;
    @FXML
    private Label lb_totalQuantity;
    private int totalQuantity;
    private Map<LocalDate, Integer> batchList = new HashMap<>();
    public AddOldLotController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    showData();
    cb_selectBatch.setOnAction(ActionEvent -> {
        for (LocalDate key : batchList.keySet()) {
            if (key.equals(LocalDate.parse(cb_selectBatch.getValue().toString()))) {
                lb_totalQuantity.setText(String.valueOf(batchList.get(key)));
                totalQuantity = batchList.get(key);
                break;
            }
        }
    });
    btn_save.setOnAction(ActionEvent -> {
        totalQuantity += Integer.parseInt(tf_newQuantity.getText());
        batchList.put(LocalDate.parse(cb_selectBatch.getValue().toString()), totalQuantity);
        new ProductDAO().updateOldBatch(new productLot(ProductController.getCurrentItemID(), LocalDate.parse(cb_selectBatch.getValue().toString()),totalQuantity));
        lb_totalQuantity.setText(String.valueOf(batchList.get(LocalDate.parse(cb_selectBatch.getValue().toString()))));
        tf_newQuantity.clear();
    });

    }
    public void showData(){
        ResultSet rs = new ProductDAO().getAllProductBatchByID(ProductController.getCurrentItemID());
        cb_selectBatch.setValue("Chọn ngày sản xuất");
        try {
            while(rs.next()) {
                batchList.put(rs.getDate("manufractureDate").toLocalDate(), rs.getInt("quantity"));
                cb_selectBatch.getItems().add(rs.getString("manufractureDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
