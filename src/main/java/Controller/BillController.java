package Controller;

import DAO.BillDao;
import Model.Bill;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BillController implements Initializable {


    @FXML
    private Button btn_prBill;

    @FXML
    private AnchorPane pane_bill;

    @FXML
    private TableColumn<?, ?> tc_STT;

    @FXML
    private TableColumn<?, ?> tc_billNumber;

    @FXML
    private TableColumn<?, ?> tc_createDate;

    @FXML
    private TableColumn<?, ?> tc_revenue;
    @FXML
    private TableView tv_showBill;
    @FXML
    private TableColumn tc_totalQuantity;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_prBill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/detail_bill.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                    pane_bill.getChildren().add(0, node);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        showData();
    }
    public void showData(){
        tc_STT.setCellValueFactory(new PropertyValueFactory<>("billID"));
        tc_billNumber.setCellValueFactory(new PropertyValueFactory<>("billCode"));
        tc_createDate.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        tc_revenue.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        tc_totalQuantity.setCellValueFactory(new PropertyValueFactory<>("purchaseQuantity"));
        ResultSet rs= new BillDao().selectALL(8,0);
        try {
            if(rs.next()){
                int i = 1;
                ObservableList<Bill> bills = tv_showBill.getItems();
                while (rs.next()) {
                    int sequence = i;i++;
                    String billCode = rs.getString("billCode");
                    LocalDate createdDate = rs.getDate("purchaseDate").toLocalDate();
                    Float revenue = rs.getFloat("revenue");
                    int totalQuantity = rs.getInt("totalQuantity");
                    bills.add( new Bill(sequence,billCode,createdDate,revenue,totalQuantity));
                }
                tv_showBill.setItems(bills);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
