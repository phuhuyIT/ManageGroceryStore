package Controller;

import DAO.BillDao;
import DAO.CustomerDAO;
import DAO.ProductDAO;
import Model.Bill;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CaculatorController implements Initializable {
    @FXML
    private Button btn_bank;

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_cash;

    @FXML
    private Button btn_cod;

    @FXML
    private Button btn_print;

    @FXML
    private Button btn_scanSKU;

    @FXML
    private Button btn_search;

    @FXML
    private ImageView iv_scanSKU;

    @FXML
    private TextField lb_discount;

    @FXML
    private TextField lb_receive;

    @FXML
    private Label lb_refund;

    @FXML
    private Label lb_totalCost;

    @FXML
    private Label lb_totalRevenue;

    @FXML
    private Label name_Product1;

    @FXML
    private AnchorPane pane_Sell;

    @FXML
    private Label price_Product1;

    @FXML
    private HBox select_Product1;

    @FXML
    private CheckBox select_all;

    @FXML
    private Label stt_Product1;

    @FXML
    private TextField txt_search;

    @FXML
    private TextField txt_searchCustomer;

    @FXML
    private VBox vb_productList;
    @FXML
    private Label lb_customerName;
    @FXML
    private Button btn_searchCustomer;
    @FXML
    private Button btn_payment;
    private Bill selectedBill;

    DecimalFormat formattera = new DecimalFormat("#,###");
    public Bill getSelectedBill() {
        return selectedBill;
    }

    public void setSelectedBill(Bill selectedBill) {
        this.selectedBill = selectedBill;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_cash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/cash.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pane_Sell.getChildren().add(node);
            }
        });
        btn_scanSKU.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runnable clock = new Runnable() {
                        @Override
                        public void run() {
                            CameraApp barCodeScanner= new CameraApp();
                            barCodeScanner.run1(vb_productList,lb_totalCost,txt_search);
                        }
                    };

                    Thread newClock = new Thread(clock); //Creating new thread
                    newClock.setDaemon(true); //Thread will automatically close on applications closing
                    newClock.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        lb_discount.setText("0");
        lb_receive.setOnKeyReleased(keyEvent ->  {
            double receive = 0;
            receive = Double.parseDouble(lb_receive.getText())-Double.parseDouble(lb_totalRevenue.getText()) - Double.parseDouble(lb_discount.getText());
            lb_refund.setText(String.valueOf(receive));
        });
        btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ResultSet rs =new ProductDAO().getProductBySKU(txt_search.getText());
                try {
                    if(rs.next()){
                        HBox hbox = new HBox();
                        Label nameLabel = new Label(rs.getString("productName"));
                        nameLabel.setId("nameLabel");
                        nameLabel.setPrefWidth(229);
                        nameLabel.setPrefHeight(38);

                        // Thiết lập kích thước chữ của Label
                        nameLabel.setStyle("-fx-font-size: 18;");

                        // Thiết lập vị trí chữ của Label là trung tâm
                        nameLabel.setAlignment(Pos.CENTER);
                        // Tạo label cho giá cả
                        Label priceLabel = new Label(String.valueOf(rs.getDouble("sellingPrice")));
                        priceLabel.setId("priceLabel");
                        priceLabel.setPrefWidth(91);
                        priceLabel.setPrefHeight(38);

                        // Thiết lập kích thước chữ của Label
                        priceLabel.setStyle("-fx-font-size: 18;");

                        // Thiết lập vị trí chữ của Label là trung tâm
                        priceLabel.setAlignment(Pos.CENTER);

                        // Tạo textField cho số lượng
                        TextField quantityTextField = new TextField();
                        quantityTextField.setId("quantityTextField");
                        quantityTextField.setPrefWidth(101);
                        quantityTextField.setPrefHeight(38);
                        quantityTextField.setStyle("-fx-font-size: 18;");
                        quantityTextField.setAlignment(Pos.CENTER);

                        Button btnDelete = new Button();
                        btnDelete.setId("btn_deleteCaculator");
                        btnDelete.setPrefWidth(52);
                        btnDelete.setPrefHeight(38);
                        btnDelete.setStyle("-fx-font-size: 12;");
                        btnDelete.setAlignment(Pos.CENTER);
                        btnDelete.setText("Delete");
                        hbox.setOnMouseClicked(event -> {

                        });
                        hbox.getChildren().addAll(btnDelete,nameLabel, priceLabel, quantityTextField);
                        vb_productList.getChildren().add(hbox);
                        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                // Lấy danh sách các node con trong VBox
                                ObservableList<Node> children = vb_productList.getChildren();

                                // Lấy chỉ mục của HBox trong danh sách
                                int index = children.indexOf(hbox);
                                if (index >= 0 && index < vb_productList.getChildren().size()) {
                                    // Xóa HBox khỏi danh sách
                                    HBox productHBox = (HBox) vb_productList.getChildren().get(index);

                                    double totalCost= Double.parseDouble(lb_totalCost.getText());
                                    Label lookupPrice = (Label) productHBox.lookup("#priceLabel");
                                    TextField lookupQuantity = (TextField) productHBox.lookup("#quantityTextField");
                                    totalCost-=Double.parseDouble(lookupPrice.getText())*Integer.parseInt(lookupQuantity.getText());
                                    lb_totalCost.setText(String.valueOf(totalCost));
                                    vb_productList.getChildren().remove(productHBox);
                                }
                            }
                        });
                        quantityTextField.setOnKeyReleased(keyEvent ->  {
                            double totalCost = 0;
                            int i=0;
                            for (Node node : vb_productList.getChildren()) {
                                if (node instanceof HBox) {
                                    HBox hboxa = (HBox) node;
                                    Label lookupPrice = (Label) hboxa.lookup("#priceLabel");
                                    TextField lookupQuantity = (TextField) hboxa.lookup("#quantityTextField");

                                    double sellingPrice = Double.parseDouble(lookupPrice.getText());
                                    int quantityInHBox = Integer.parseInt(lookupQuantity.getText());

                                    totalCost += sellingPrice * quantityInHBox;
                                    i++;
                                }
                            }
                            lb_totalRevenue.setText(String.valueOf(totalCost));
                            lb_totalCost.setText(String.valueOf(totalCost));
                        });
                        btn_payment.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                ArrayList<Product> productList = new ArrayList<>();
                                Double totalRevenue= Double.valueOf(0);
                                int quantity=0;
                                for (Node node : vb_productList.getChildren()) {
                                    if (node instanceof HBox) {
                                        HBox hboxa = (HBox) node;
                                        Label lookupPrice = (Label) hboxa.lookup("#priceLabel");
                                        TextField lookupQuantity = (TextField) hboxa.lookup("#quantityTextField");
                                        Label lookupNameLabel = (Label) hboxa.lookup("#nameLabel");
                                        double sellingPrice = Double.parseDouble(lookupPrice.getText());
                                        int quantityInHBox = Integer.parseInt(lookupQuantity.getText());
                                        String productName  = lookupNameLabel.getText();
                                        Double totalCost = sellingPrice * quantityInHBox;
                                        totalRevenue+=totalCost;
                                        quantity=quantityInHBox;
                                        productList.add(new Product(productName,sellingPrice,quantityInHBox,formattera.format(totalCost)));
                                    }
                                }
                                LocalDate currentDate = LocalDate.now();
                                String billCode="HDS"+currentDate+totalRevenue;
                                String staffName = txt_searchCustomer.getText();
                                String customerName = txt_searchCustomer.getText();
                                new BillDao().addFunction(new Bill(billCode,currentDate, staffName,customerName,formattera.format(Double.parseDouble(lb_totalCost.getText())),productList,quantity ));
                                selectedBill = new Bill(0,0,billCode,currentDate, LoginController.getLoggedInUsername(),lb_customerName.getText(),formattera.format(Double.parseDouble(lb_totalCost.getText())),productList,Double.parseDouble(lb_receive.getText()),Double.parseDouble(lb_refund.getText()));
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/detail_bill.fxml"));
                                DetailBillController controller = new DetailBillController(selectedBill);
                                fxmlLoader.setController(controller);
                                Stage stage = new Stage();
                                Scene scene = null;
                                try {
                                    scene = new Scene(fxmlLoader.load(), 583, 838);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                stage.setTitle("Detail Bill");
                                stage.setScene(scene);
                                stage.setResizable(false);
                                stage.show();
                            }
                        });
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        btn_searchCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lb_customerName.setText(new CustomerDAO().selectByPhone(txt_searchCustomer.getText()));
            }
        });


    }

}
