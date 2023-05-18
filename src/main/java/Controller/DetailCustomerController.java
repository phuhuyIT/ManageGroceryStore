package Controller;

import DAO.CustomerDAO;
import Model.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DetailCustomerController implements Initializable {
    @FXML
    private Button btn_save;
    @FXML
    private Label lb_DCBirthDate;
    @FXML
    private Label lb_detailCustomerName;
    @FXML
    private Label lb_detailCustomerID;
    @FXML
    private TextField txt_phoneNumberCustomer;
    @FXML
    private TextField txt_emailCustomer;
    @FXML
    private TextField txt_locationCustomer;

    @FXML
    private Button btn_refesh;
    @FXML
    private AnchorPane pane;

    private File filePath;
    private FileChooser fileChooser;
    @FXML
    private ImageView image_customer;
    @FXML
    private Label lb_detailCustomerGender;
    @FXML
    public void chooseImageProduct(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");

        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);


        fileChooser.setInitialDirectory(userDirectory);
        filePath = fileChooser.showOpenDialog(stage);


        //cập nhật ảnh mới
        Image image = new Image(String.valueOf(filePath));
        image_customer.setImage(image);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateDetailCustomer();
            }
        });
        showData();
     }
    private void showData(){
        ResultSet rs=new CustomerDAO().selectByID(CustomerController.getCurrentItemID());
        try {
            if(rs.next()){
                lb_detailCustomerName.setText(rs.getString("fullname"));
                lb_detailCustomerID.setText(rs.getString("citizenIDNumber"));
                String gender=null;
                if(rs.getInt("gender")==0)
                    gender="Nam";
                else if(rs.getInt("gender")==1)
                    gender="Nữ";
                else gender="Khác";
                lb_detailCustomerGender.setText(gender);
                lb_DCBirthDate.setText(String.valueOf(rs.getDate("birthDate")));
                txt_phoneNumberCustomer.setText(rs.getString("PHONE"));
                txt_emailCustomer.setText(rs.getString("EMAIL"));
                txt_locationCustomer.setText(rs.getString("LOCATION"));
                String thumbnailLink = rs.getString("avatarLink");
                if(thumbnailLink!=null){
                    Image productThumbnail = new Image(String.valueOf(thumbnailLink));
                    image_customer.setImage(productThumbnail);
                    filePath=new File(thumbnailLink);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void updateDetailCustomer(){
        new CustomerDAO().update(new Customer(CustomerController.getCurrentItemID(),txt_phoneNumberCustomer.getText(),txt_emailCustomer.getText(),txt_locationCustomer.getText()
        ,filePath.toString()));
    }
}
