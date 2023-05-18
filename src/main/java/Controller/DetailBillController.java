package Controller;

import Model.Bill;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailBillController implements Initializable {
    @FXML
    private ImageView imageView;

    @FXML
    private Label lb_billCode;

    @FXML
    private Label lb_customerName;

    @FXML
    private Label lb_purchaseDate;

    @FXML
    private Label lb_receive;

    @FXML
    private Label lb_refund;

    @FXML
    private Label lb_staffName;

    @FXML
    private Label lb_totalRevenue;

    @FXML
    private TableColumn<?, ?> tc_productName;

    @FXML
    private TableColumn<?, ?> tc_productPrice;

    @FXML
    private TableColumn<?, ?> tc_productQuantity;

    @FXML
    private TableColumn<?, ?> tc_productRevenue;

    @FXML
    private TableView<Product> tv_showDetailBill;

    private Bill selectedBill;

    public DetailBillController(Bill selectedBill) {
        System.out.println("contructor:"+selectedBill.toString() );
        this.selectedBill = selectedBill;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showDetailBill();
    }
    private void showDetailBill(){
        tc_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tc_productQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tc_productPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        tc_productRevenue.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        ObservableList<Product> productList = tv_showDetailBill.getItems();
        lb_billCode.setText(selectedBill.getBillCode());
        lb_purchaseDate.setText(String.valueOf(selectedBill.getPurchaseDate()));
        lb_staffName.setText(selectedBill.getStaffName());
        lb_customerName.setText(selectedBill.getCustomerName());
        lb_totalRevenue.setText(selectedBill.getRevenue());
        lb_receive.setText(String.valueOf(selectedBill.getRevenue()));
        lb_refund.setText(String.valueOf(selectedBill.getRevenue()));
        if(!selectedBill.getReceive().equals(null)){
            lb_receive.setText(String.valueOf(selectedBill.getReceive()));
            lb_refund.setText(String.valueOf(selectedBill.getRefund()));
        }
        productList = FXCollections.observableArrayList(selectedBill.getProductList());
        tv_showDetailBill.setItems(productList);
    }


}
