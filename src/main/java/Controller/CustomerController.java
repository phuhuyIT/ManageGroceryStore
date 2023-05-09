package Controller;

import DAO.CustomerDAO;
import DAO.ProductDAO;
import Model.Customer;
import Controller.AlertAndVerifyController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

public class CustomerController extends Pagination implements Initializable {

    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_Search;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button btn_add_user;
    @FXML
    private AnchorPane anchorPane_customer;
    private static int currentCustomerID;

    public static int getCurrentCustomerID() {
        return currentCustomerID;
    }

    private String[] choice = {"A->Z" , "Z->A"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Limit=8;
        offSet=0;
        numberData = new CustomerDAO().getNumCustomer();
        //set sự kiện cho btn_detailUser
        EventHandler<ActionEvent> linktoDetailProduct =event -> {
            String fxmlPath = "views/detailCustomer.fxml";
            Button btn= (Button) event.getSource();
            String id= (String)btn.getUserData();
            currentCustomerID = Integer.parseInt(id);
            loadFXML(fxmlPath);
        };

//        for (int i=0;i<8;i++){
//            AnchorPane ap1 = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
//            Button btnDetailsUser = (Button) ap1.lookup("#btn_detailUser"+(i+1));
//            btnDetailsUser.setOnAction(linktoDetailProduct);
//        }

        showData(Limit,offSet);

        btn_add_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/addCustomer.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                anchorPane_customer.getChildren().add(node);
            }
        });
        setActionForBtn();

        //xử lý sự kiện chuột phải
        ContextMenu contextMenu  = new ContextMenu();

        // Thêm các MenuItem vào ContextMenu
        MenuItem delete = new MenuItem("Delete");
        ImageView iconDelete = new ImageView(new Image(getClass().getResourceAsStream("image/delete.png")));
        iconDelete.setFitHeight(30);
        iconDelete.setFitWidth(30);
        delete.setGraphic(iconDelete);
        delete.setText("Delete");
        delete.setStyle("-fx-font-size : 20px ; -fx-padding : 0px 0px 0px 70px;");

        MenuItem detail = new MenuItem("Detail");
        ImageView iconDetail = new ImageView(new Image(getClass().getResourceAsStream("image/list.png")));
        iconDetail.setFitHeight(30);
        iconDetail.setFitWidth(30);
        detail.setGraphic(iconDetail);
        detail.setText("Detail");
        detail.setStyle("-fx-font-size : 20px ; -fx-padding : 0px 0px 0px 70px;");

        MenuItem cancel = new MenuItem("Cancel");
        ImageView iconCancel = new ImageView(new Image(getClass().getResourceAsStream("image/cancel.png")));
        iconCancel.setFitHeight(30);
        iconCancel.setFitWidth(30);
        cancel.setGraphic(iconCancel);
        cancel.setText("Cancel");
        cancel.setStyle("-fx-font-size : 20px ; -fx-text-fill : #FF0000 ; -fx-padding : 0px 0px 0px 70px; -fx-font-weight:bold;");

        //Định dạng contextMenu
        contextMenu.setStyle("-fx-pref-width: 200px; -fx-pref-height: 130px; -fx-padding : 7px 0px 0px 0px;");
        contextMenu.getItems().addAll(detail,delete,cancel);

        // Thiết lập sự kiện chuột phải cho anchorPane_customer
        anchorPane_customer.setOnContextMenuRequested(event -> {
            contextMenu.show(anchorPane_customer, event.getScreenX(), event.getScreenY());
            event.consume(); // đánh dấu sự kiện này đã được xử lý
        });

        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            System.out.println("Dã xoá");
        });
        cancel.setOnAction(actionEvent -> {
            contextMenu.hide();
        });

    }
    private void loadFXML(String fxmlPath) {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Node node = null;
        try {
            node = loader.<Node>load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        anchorPane_customer.getChildren().add(node);
    }
    @Override
    public void showData(int limit, int offSet){
        choiceBox.getItems().addAll(choice);
        CustomerDAO customers= new CustomerDAO();
        ResultSet rs=customers.selectALL(Limit,offSet);
        try {
            for (int i=0;i<8;i++){

                if(rs.next()){
                    AnchorPane anchorPane = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
                    Label customerName =(Label) anchorPane.lookup("#nameCustomer"+(i+1));
                   // Button btnDetailCustomer= (Button) anchorPane.lookup("#btn_detailUser"+(i+1));
                    ImageView customerAvatar =(ImageView) anchorPane.lookup("#imageCustomer"+(i+1));
                    Label customerGender =(Label) anchorPane.lookup("#genderCustomer"+(i+1));
                    Label customerPhone =(Label) anchorPane.lookup("#phoneCustomer"+(i+1));

                  //  btnDetailCustomer.setUserData(String.valueOf(rs.getInt("cid")));
                    String img  = rs.getString("AVATARLINK");
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        customerAvatar.setImage(image1);
                    }
                    customerName.setText(rs.getString("FULLNAME"));
                    if (0 != rs.getInt("GENDER")) {
                        customerGender.setText("Nữ");
                    }else customerGender.setText("Nam");
                    customerPhone.setText(rs.getString("PHONE"));
                }
                else
                    return;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void clearData(){
            for (int i=0;i<8;i++){
                    AnchorPane anchorPane = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
                    Label customerName =(Label) anchorPane.lookup("#nameCustomer"+(i+1));
                    Button btnDetailCustomer= (Button) anchorPane.lookup("#btn_detailUser"+(i+1));
                    ImageView customerAvatar =(ImageView) anchorPane.lookup("#imageCustomer"+(i+1));
                    Label customerGender =(Label) anchorPane.lookup("#genderCustomer"+(i+1));
                    Label customerPhone =(Label) anchorPane.lookup("#phoneCustomer"+(i+1));

                    btnDetailCustomer.setUserData(null);
                    String img  = "D:\\java\\ManageGroceryStore\\src\\main\\resources\\Controller\\image\\gamer.png";
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        customerAvatar.setImage(image1);
                    }
                    customerName.setText("");
                    customerGender.setText("");
                    customerPhone.setText("");
            }

    }
}
