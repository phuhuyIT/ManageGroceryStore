package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    private File filePath;
    private FileChooser fileChooser;
    @FXML
    private ImageView image_customer;
    @FXML
    private ChoiceBox<String> choice_gender;
    private String[] gender = {"Nam" , "Nữ" , "Khác"};

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
        choice_gender.getItems().addAll(gender);
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
    }
}
