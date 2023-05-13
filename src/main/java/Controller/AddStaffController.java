package Controller;

import DAO.CustomerDAO;
import DAO.StaffDAO;
import Model.CameraApp;
import Model.Customer;
import Model.Staff;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
import java.sql.Timestamp;
import java.util.ResourceBundle;

import static Model.InventoryAlert.errorAlert;

public class AddStaffController implements Initializable {
    @FXML
    private Button btn_back;
    private File filePath;
    private FileChooser fileChooser;
    @FXML
    private Button btn_addThumnail;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_scanIDCard;

    @FXML
    private ChoiceBox<String> cb_staffGender;

    @FXML
    private ChoiceBox<String> cb_staffPosition;

    @FXML
    private DatePicker dp_staffBirthdate;

    @FXML
    private DatePicker dp_staffFWD;

    @FXML
    private ImageView iv_staffImage;

    @FXML
    private AnchorPane pane_addStaff;

    @FXML
    private TextField txt_IndentifierStaff;

    @FXML
    private TextField txt_emailStaff;

    @FXML
    private TextField txt_fullNameStaff;

    @FXML
    private TextField txt_locationStaff;

    @FXML
    private TextField txt_phoneNumberStaff;

    @FXML
    private TextField txt_staffBasicSalary;

    private String[] gender = {"Nam" , "Nữ" , "Khác"};
    private String[] position = {"Nhân viên" , "Quản lý" , "Kế toán"};

    @FXML
    public void chooseImageStaff(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");

        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);

        fileChooser.setInitialDirectory(userDirectory);
        filePath = fileChooser.showOpenDialog(stage);

        //cập nhật ảnh mới
        Image image = new Image(String.valueOf(filePath));
        iv_staffImage.setImage(image);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cb_staffGender.getItems().addAll(gender);
        cb_staffPosition.getItems().addAll(position);
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/staff.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pane_addStaff.getChildren().add(node);
            }
        });
        btn_scanIDCard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CameraApp scanIDCard=new CameraApp();
                scanIDCard.setTextFieldForCustomer(txt_fullNameStaff,txt_IndentifierStaff,cb_staffGender,dp_staffBirthdate,txt_locationStaff);
                scanIDCard.start();
            }
        });
        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addStaff();
            }
        });
    }
    public void addStaff(){
        if(txt_fullNameStaff.getText().isEmpty()||cb_staffGender.getValue().isEmpty()||
                dp_staffBirthdate.equals(null)||txt_phoneNumberStaff.equals(null)){
            errorAlert("Empty field","PLEASE FILL IN ALL NECESSARY INFORMATION!");
        }else{
            if(cb_staffGender.getValue()=="Nam"&&filePath.toString()==null){
                filePath = new File("D:/java/ManageGroceryStore/src/main/resources/Controller/image/woman1.jpg");
            } else if (cb_staffGender.getValue()=="Nữ"&&filePath.toString()==null) {
                filePath = new File("D:/java/ManageGroceryStore/src/main/resources/Controller/image/man.jpg");
            }
            if(txt_IndentifierStaff.getText()==null)
                txt_IndentifierStaff.setText("");
            if(txt_locationStaff.getText()==null)
                txt_locationStaff.setText("");
            if(txt_emailStaff.getText()==null)
                txt_emailStaff.setText("");
            Staff staff = new Staff(txt_fullNameStaff.getText(),txt_IndentifierStaff.getText(), cb_staffGender.getValue()
                    , txt_locationStaff.getText(), txt_phoneNumberStaff.getText(), txt_emailStaff.getText(),filePath.toString(),
                    dp_staffBirthdate.getValue(),Float.parseFloat(txt_staffBasicSalary.getText()),cb_staffPosition.getValue(),
                    dp_staffFWD.getValue());
            new StaffDAO().insert(staff);
        }
    }
}
