package Controller;

import DAO.CategoryDao;
import DAO.ProductDAO;
import DAO.StaffDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {
    @FXML
    private Label title;

    @FXML
    private Label lb_numberStaff;
    @FXML
    private Label lb_numberCategory;
    @FXML
    private Label lb_numberProduct;
    @FXML
    private Label lb_numberRevenue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lb_numberProduct.setText(String.valueOf(new ProductDAO().getNumProuduct()));
        lb_numberCategory.setText(String.valueOf(new CategoryDao().getNumCategory()));
        lb_numberStaff.setText(String.valueOf(new StaffDAO().getNumStaff()));

    }
}
