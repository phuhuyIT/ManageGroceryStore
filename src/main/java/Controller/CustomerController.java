package Controller;

import DAO.CustomerDAO;
import DAO.ProductDAO;
import Model.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class CustomerController implements Initializable {

    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_Search;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private ImageView user1_avatar;
    @FXML
    private Label user1_name;
    @FXML
    private Label user1_gender;
    @FXML
    private Label user1_phone;
    @FXML
    private Label user1_email;
    @FXML
    private Button btn_add_user;
    @FXML
    private ImageView img_back;
    @FXML
    private ImageView img_next;
    @FXML
    private AnchorPane anchorPane_customer;
    private static int currentCustomerID;
    private String[] choice = {"A->Z" , "Z->A"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set sự kiện cho btn_detailUser
        EventHandler<ActionEvent> linktoDetailProduct =event -> {
            String fxmlPath = "views/detailCustomer.fxml";
            Button btn= (Button) event.getSource();
            String id= (String)btn.getUserData();
            currentCustomerID = Integer.parseInt(id);
            loadFXML(fxmlPath);
        };

        for (int i=0;i<8;i++){
            AnchorPane ap1 = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
            Button btnDetailsUser = (Button) ap1.lookup("#btn_detailUser"+(i+1));
            btnDetailsUser.setOnAction(linktoDetailProduct);
        }

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

        choiceBox.getItems().addAll(choice);
        CustomerDAO customers= new CustomerDAO();
        ResultSet rs=customers.selectALL();
        try {
            for (int i=0;i<8;i++){

                if(rs.next()){
                    AnchorPane anchorPane = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
                    Label customerName =(Label) anchorPane.lookup("#nameCustomer"+(i+1));
                    Button btnDetailCustomer= (Button) anchorPane.lookup("#btn_detailUser"+(i+1));
                    ImageView customerAvatar =(ImageView) anchorPane.lookup("#imageCustomer"+(i+1));
                    Label customerGender =(Label) anchorPane.lookup("#genderCustomer"+(i+1));
                    Label customerPhone =(Label) anchorPane.lookup("#phoneCustomer"+(i+1));

                    btnDetailCustomer.setUserData(String.valueOf(rs.getInt("cid")));
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

}
