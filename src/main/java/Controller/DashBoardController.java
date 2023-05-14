package Controller;

import DAO.*;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
    @FXML
    private LineChart lc_revenueChart;
    @FXML
    private AnchorPane pane_DashBoard;
    @FXML
    private TableView tv_dashBoardTopProduct;
    @FXML
    private TableColumn tc_productID;
    @FXML
    private TableColumn tx_productName;
    @FXML
    private TableColumn tx_productQuantitySold;
    @FXML
    private TableColumn tc_productRevenue;
    DecimalFormat formattera = new DecimalFormat("#,###");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lb_numberProduct.setText(String.valueOf(new ProductDAO().getNumProuduct()));
        lb_numberCategory.setText(String.valueOf(new CategoryDao().getNumCategory()));
        lb_numberStaff.setText(String.valueOf(new StaffDAO().getNumStaff()));
        lb_numberRevenue.setText(String.valueOf(formattera.format(new BillDao().totalRevenueByMonth())));
        drawChart();
        showTop5Staff();
        showTop5Customer();
        showTopProduct();
    }

    public void drawChart() {
        lc_revenueChart.setTitle("Doanh thu theo tháng");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Doanh thu");
        ResultSet rs = new BillDao().getRevenueByMonth();
        try {
            while (rs.next()) {
                String month = rs.getString("month");
                double revenue = rs.getDouble("totalRevenue");
                series.getData().add(new XYChart.Data<>(month, revenue));
            }
            lc_revenueChart.getData().add(series);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showTop5Staff() {
        AnchorPane ap = (AnchorPane) pane_DashBoard.lookup("#pane_staff");
        VBox vb = (VBox) ap.lookup("#vbox_Staff");
        ResultSet rs = new StaffDAO().getTop5StaffRevenues();
        for (int i = 1; i <= 5; i++) {
            HBox hb = (HBox) vb.lookup("#hb_Staff" + i);
            Label staffTop = (Label) hb.lookup("#lb_topStaff" + i);
            try {
                if (rs.next())
                    staffTop.setText(rs.getString("fullname"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void showTop5Customer() {
        AnchorPane ap = (AnchorPane) pane_DashBoard.lookup("#pane_Customer");
        VBox vb = (VBox) ap.lookup("#vbox_customer");
        ResultSet rs = new CustomerDAO().getTop5CustomerRevenues();
        for (int i = 1; i <= 5; i++) {
            HBox hb = (HBox) vb.lookup("#hbox_customer" + i);
            Label staffTop = (Label) hb.lookup("#lb_topCustomer" + i);
            try {
                if (rs.next())
                    staffTop.setText(rs.getString("fullname"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void showTopProduct() {
        tc_productID.setCellValueFactory(new PropertyValueFactory<>("productId"));

        tx_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));

        tx_productQuantitySold.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tc_productRevenue.setCellValueFactory(new PropertyValueFactory<>("productBarCode"));
        ResultSet rs = new ProductDAO().getTopProducts();
        try {
            int i = 1;
            ObservableList<Product> topProduct = tv_dashBoardTopProduct.getItems();
            while (rs.next()) {
                int sequence = i;i++;
                String productName = rs.getString("productName");
                int totalSold = rs.getInt("totalSold");
                Double revenue = Double.valueOf(rs.getDouble("revenue"));
                topProduct.add( new Product(sequence,productName,totalSold, formattera.format(revenue)));
            }
            tv_dashBoardTopProduct.setItems(topProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
