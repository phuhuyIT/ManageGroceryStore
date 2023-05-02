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
    private Button btn_detailUser1;


    @FXML
    private ImageView img_back;
    @FXML
    private ImageView img_next;
    @FXML
    private AnchorPane anchorPane_customer;

    private String[] choice = {"A->Z" , "Z->A"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set sự kiện cho btn_detailUser
        btn_detailUser1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/detailCustomer.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                anchorPane_customer.getChildren().add(node);
            }
        });
//        choiceBox.getItems().addAll(choice);
//        CustomerDAO customers= new CustomerDAO();
//        ResultSet rs=customers.selectALL();
//        try {
//            for (int i=0;i<10;i++){
//
//                if(rs.next()){
//                    HBox hbox = (HBox) anchorPane_customer.lookup("#customerHbox"+(i+1));
//                    Label customerName =(Label) hbox.lookup("#user"+(i+1)+"_name");
//
//                    ImageView customerAvatar =(ImageView) hbox.lookup("#user"+(i+1)+"_avatar");
//                    Label customerGender =(Label) hbox.lookup("#user"+(i+1)+"_gender");
//                    Label customerPhone =(Label) hbox.lookup("#user"+(i+1)+"_phone");
//                    Label customerEmail =(Label) hbox.lookup("#user"+(i+1)+"_email");
//
//
//                    String img  = rs.getString("AVATARLINK");
//                    System.out.println(img);
//                    if(img!=null) {
//                        Image image1 = new Image(String.valueOf(img));
//                        customerAvatar.setImage(image1);
//                    }
//                    customerName.setText(rs.getString("FULLNAME"));
//                    if (0 != rs.getInt("GENDER")) {
//                        customerGender.setText("Nữ");
//                    }else customerGender.setText("Nam");
//                    customerPhone.setText(rs.getString("PHONE"));
//                    customerEmail.setText(rs.getString("EMAIL"));
//                }
//                else
//                    return;
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
