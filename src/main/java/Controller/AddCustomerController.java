package Controller;

import DAO.CustomerDAO;
import Model.CameraApp;
import Model.Customer;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import static Controller.AlertAndVerifyController.errorAlert;

public class AddCustomerController implements Initializable {
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_addThumnail;
    @FXML
    private AnchorPane pane;
    @FXML
    private TextField txt_fullNameCustomer;
    @FXML
    private TextField txt_IndentifierCustomer;
    @FXML
    private TextField txt_phoneNumberCustomer;
    @FXML
    private TextField txt_emailCustomer;
    @FXML
    private TextField txt_locationCustomer;
    @FXML
    private DatePicker dp_customerBirthdate;
    @FXML
    private Button btn_scanIDCard;
    private File filePath;
    private FileChooser fileChooser;
    @FXML
    private ImageView iv_customerImage;
    @FXML
    private ChoiceBox<String> cb_customerGender;
    private String customerInfo;
    private String[] gender = {"Nam" , "Nữ" , "Khác"};

    @FXML
    public void chooseImageCustomer(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");

        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);

        fileChooser.setInitialDirectory(userDirectory);
        filePath = fileChooser.showOpenDialog(stage);

        //cập nhật ảnh mới
        Image image = new Image(String.valueOf(filePath));
        iv_customerImage.setImage(image);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cb_customerGender.getItems().addAll(gender);
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/customer.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pane.getChildren().add(node);
            }
        });
        btn_scanIDCard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CameraApp scanIDCard=new CameraApp();
                scanIDCard.setTextFieldForCustomer(txt_fullNameCustomer,txt_IndentifierCustomer,cb_customerGender,dp_customerBirthdate,txt_locationCustomer);
                scanIDCard.start();

            }
        });
        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addCustomer();
            }
        });
    }
    private void addCustomer(){
        if(txt_fullNameCustomer.getText().isEmpty()||cb_customerGender.getValue().isEmpty()||
        dp_customerBirthdate.equals(null)||txt_phoneNumberCustomer.equals(null)){
            errorAlert("Empty field","PLEASE FILL IN ALL NECESSARY INFORMATION!");
        }else{
            if(filePath.toString()==null){
                filePath = new File("");
            }
            if(txt_IndentifierCustomer.getText()==null)
                txt_IndentifierCustomer.setText("");
            if(txt_locationCustomer.getText()==null)
                txt_locationCustomer.setText("");
            if(txt_emailCustomer.getText()==null)
                txt_emailCustomer.setText("");
            Customer cus = new Customer(txt_fullNameCustomer.getText(),txt_IndentifierCustomer.getText(), cb_customerGender.getValue()
            , txt_locationCustomer.getText(), txt_phoneNumberCustomer.getText(), txt_emailCustomer.getText(),filePath.toString(),dp_customerBirthdate.getValue().toString());
            new CustomerDAO().insert(cus);
        }
    }
}
