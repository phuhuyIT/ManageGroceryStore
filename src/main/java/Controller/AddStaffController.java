package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStaffController extends DetailStaffController implements Initializable {
    @FXML
    private Button btn_back;
    private File filePath;
    private FileChooser fileChooser;
    @FXML
    private ImageView iv_staffImage;
    @FXML
    private ChoiceBox<String> cb_staffGender;
    @FXML
    private ChoiceBox<String> cb_staffPosition;


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
        setBtnBackAction();
    }
}
