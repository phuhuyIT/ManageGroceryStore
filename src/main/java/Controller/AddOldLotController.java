package Controller;

import DAO.ProductDAO;
import DatabaseConnection.ConnectionFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.Pair;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddOldLotController implements Initializable {

    @FXML
    private Button btn_save;

    @FXML
    private ChoiceBox cb_selectBatch;

    @FXML
    private TextField tf_quantity;
    private ArrayList<Pair<LocalDate, Integer>> batchList = new ArrayList<>();
    public AddOldLotController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    showData();
    cb_selectBatch.setOnAction(ActionEvent -> {
        for (Pair pair : batchList) {
            if (pair.getKey().equals(LocalDate.parse(cb_selectBatch.getValue().toString()))) {
                tf_quantity.setText(pair.getValue().toString());
                break;
            }
        }
    });
    }
    public void showData(){
        ResultSet rs = new ProductDAO().getAllProductBatchByID(ProductController.getCurrentItemID());

        try {
            while(rs.next()) {
                batchList.add(new Pair(rs.getDate("manufractureDate").toLocalDate(), rs.getInt("quantity")));
                cb_selectBatch.getItems().add(rs.getString("manufractureDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cb_selectBatch.setValue("Chọn ngày sản xuất");
    }
}
