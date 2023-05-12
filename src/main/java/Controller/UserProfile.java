package Controller;

import DAO.UserDAO;
import Model.InventoryAlert;
import Model.User;
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
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ResourceBundle;

public class UserProfile extends InventoryAlert implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Button btn_update;

    @FXML
    private AnchorPane pane;

    private File filePath;
    private FileChooser fileChooser;
    @FXML
    private ImageView image_user;

    @FXML
    private Button choose_avatar;

    @FXML
    private Button change_pass;

    @FXML
    private Button btn_edit;

    @FXML
    private Label lbl_username;

    @FXML
    private PasswordField tf_password;
    @FXML
    private TextField txt_fullname;
    @FXML
    private ChoiceBox cb_category;
    @FXML
    private TextField txt_phone;
    @FXML
    private TextField txt_location;
    @FXML
    private TextField txt_email;
    @FXML
    private Button btn_refesh;
    @FXML
    public void chooseImageButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");

        //cai dat den thu muc cua ng dung hoac chuyen truc tiep den o c neu ko truy cap duoc
        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);

        fileChooser.setInitialDirectory(userDirectory);
        filePath = fileChooser.showOpenDialog(stage);


        //cập nhật ảnh mới
        Image image = new Image(String.valueOf(filePath));
        image_user.setImage(image);
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Hiển thị cho choiceBox
        cb_category.getItems().addAll("ADMINISTRATOR", "STAFF", "CUSTOMER");
        cb_category.setStyle("-fx-font-size: 18;");
        // Lấy thông tin từ database hiện lên
        try {
            UserDAO userData = new UserDAO();
            ResultSet rs = userData.getQueryResult1(Login.getLoggedInUsername());
            while (rs.next()) {
                String img = rs.getString("IMAGE");
                if (img != null) {
                    Image image1 = new Image(String.valueOf(img));
                    image_user.setImage(image1);
                }
                txt_email.setText(rs.getString("EMAIL"));
                txt_fullname.setText(rs.getString("FULLNAME"));
                txt_phone.setText(rs.getString("PHONE"));
                txt_location.setText(rs.getString("LOCATION"));
                cb_category.setValue(rs.getString("CATEGORY"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        change_pass.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/change_pass.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pane.getChildren().add(node);
            }
        });


        btn_update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Image image =image_user.getImage();
                filePath =new File(image.getUrl());
                if (!txt_fullname.getText().trim().isEmpty() && !txt_phone.getText().trim().isEmpty() && !txt_location.getText().trim().isEmpty() && !cb_category.getValue().toString().trim().isEmpty()&& !txt_email.getText().trim().isEmpty()) {
                    User user=new User(txt_fullname.getText(),txt_location.getText(), txt_phone.getText(), txt_email.getText(), (String) cb_category.getValue(), filePath.toString());
                    try {
                        Login.Update_Infor(actionEvent,user);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    errorAlert("Error","Please fill in at lease one field!");
                }
            }
        });

    }

    public static String encryptPassword(String input){
        String encPass=null;
        if(input==null) return null;

        try{
            MessageDigest digest=MessageDigest.getInstance("SHA-256");
            digest.update(input.getBytes(),0,input.length());
            encPass=new BigInteger(1,digest.digest()).toString(16);
        }catch(Exception e){
            e.printStackTrace();
        }
        return encPass;
    }
}

