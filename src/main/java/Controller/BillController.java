package Controller;

import DAO.BillDao;
import Model.Bill;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BillController implements Initializable {


    @FXML
    private Button btn_prBill;

    @FXML
    private Label lb_billCode;

    @FXML
    private Label lb_customerName;

    @FXML
    private Label lb_discount;

    @FXML
    private Label lb_pay;

    @FXML
    private Label lb_purchaseDate;

    @FXML
    private Label lb_staffName;

    @FXML
    private Label lb_totalRevenue;

    @FXML
    private AnchorPane pane_DetailBill;

    @FXML
    private AnchorPane pane_bill;

    @FXML
    private TableColumn<?, ?> tc_ProductList;

    @FXML
    private TableColumn<?, ?> tc_STT;

    @FXML
    private TableColumn<?, ?> tc_StaffName;

    @FXML
    private TableColumn<?, ?> tc_billID;

    @FXML
    private TableColumn<?, ?> tc_billNumber;

    @FXML
    private TableColumn<?, ?> tc_createDate;

    @FXML
    private TableColumn<?, ?> tc_customerName;

    @FXML
    private TableColumn<?, ?> tc_productName;

    @FXML
    private TableColumn<?, ?> tc_productQuantity;

    @FXML
    private TableColumn<?, ?> tc_productRevenue;

    @FXML
    private TableColumn<?, ?> tc_revenue;

    @FXML
    private TableView<Product> tv_productList;

    @FXML
    private TableView<Bill> tv_showBill;

    private ObservableList<Bill> billALLList;
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
        setActionOnProductList();
    }
    private void showData(){
        tc_STT.setCellValueFactory(new PropertyValueFactory<>("sequence"));
        tc_billNumber.setCellValueFactory(new PropertyValueFactory<>("billCode"));
        tc_createDate.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        tc_revenue.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        tc_billID.setCellValueFactory(new PropertyValueFactory<>("billID"));
        tc_StaffName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        tc_customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tc_ProductList.setCellValueFactory(new PropertyValueFactory<>("product"));
        ResultSet rs= new BillDao().selectALL(200,0);
        billALLList =tv_showBill.getItems();
        try {
            if(rs.next()){
                int i = 1;
                while (rs.next()) {
                    int sequence = i;i++;
                    String billCode = rs.getString("billCode");
                    Timestamp createdDate = rs.getTimestamp("purchaseDate");
                    Float revenue = rs.getFloat("revenue");
                    int billID = rs.getInt("billID");
                    String staffName = rs.getString("staffName");
                    String customerName=rs.getString("customerName");
                    String product = rs.getString("productList");
                    billALLList.add( new Bill(sequence,billID,billCode,createdDate, staffName,customerName,revenue,product));
                }
                tv_showBill.setItems(billALLList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setActionOnProductList(){
        tv_showBill.setOnMouseClicked(mouseEvent -> {
            clearBill();
            showDetailBill();
        });
        tv_showBill.setOnKeyPressed(keyPressed ->{
            clearBill();
            showDetailBill();
        });
    }
    private void showDetailBill(){
        tc_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tc_productQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tc_productRevenue.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        Bill bill = tv_showBill.getSelectionModel().getSelectedItem();
        System.out.println(bill.toString());
        if(bill==null){
            clearBill();
            return;
        }
        ObservableList<Product> productList = tv_productList.getItems();
        lb_billCode.setText(bill.getBillCode());
        lb_purchaseDate.setText(String.valueOf(bill.getPurchaseDate()));
        lb_staffName.setText(bill.getStaffName());
        lb_customerName.setText(bill.getCustomerName());
        lb_discount.setText("0%");
        lb_totalRevenue.setText(String.valueOf(bill.getRevenue()));
        lb_pay.setText(String.valueOf(bill.getRevenue()));
        productList = FXCollections.observableArrayList(splitProductListString(bill.getProduct()));
        tv_productList.setItems(productList);
    }
    private ArrayList<Product> splitProductListString(String productList){
        ArrayList<Product> products= new ArrayList<>();
        String[] allProduct = productList.split(", ");
        for (String oneProduct : allProduct) {
            String[] productParts = oneProduct.split("\\|");
            String productName = productParts[0].replace("'", "").trim();
            int productQuantity = Integer.parseInt(productParts[1]);
            Double productRevenue = Double.parseDouble(productParts[2]);
            System.out.println("Product Name: " + productName);
            System.out.println("Product Quantity: " + productQuantity);
            System.out.println("Product Price: " + productRevenue);
            products.add(new Product(productName,productQuantity,productRevenue));
        }
        return products;
    }
    private void clearBill(){
        lb_billCode.setText("");
        lb_purchaseDate.setText("");
        lb_staffName.setText("");
        lb_customerName.setText("");
        tv_productList.getItems().clear();
        tc_productName.setCellValueFactory(new PropertyValueFactory<>(""));
        tc_productQuantity.setCellValueFactory(new PropertyValueFactory<>(""));
        tc_productRevenue.setCellValueFactory(new PropertyValueFactory<>(""));
    }
}
