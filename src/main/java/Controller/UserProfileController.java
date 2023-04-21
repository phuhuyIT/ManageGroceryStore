package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
import java.sql.*;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

import Controller.HelloController;

public class UserProfileController implements Initializable{

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
    private Label lbl_username;

    @FXML
    private Label lbl_password;

    public String username;
    public String password;

    private HashMap<String, String> acc_user = new HashMap<String, String>();

    @FXML
    public void chooseImageButton(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");

        //cai dat den thu muc cua ng dung hoac chuyen truc tiep den o c neu ko truy cap duoc
        String userDirectoryString = System.getProperty("user.home") ;
        File userDirectory = new File(userDirectoryString);

//        if(!userDirectory.canRead())
//            userDirectory = new File("C:/");

        fileChooser.setInitialDirectory(userDirectory);
        filePath = fileChooser.showOpenDialog(stage);


        //cập nhật ảnh mới
        Image image = new Image(String.valueOf(filePath));
        System.out.println(filePath);
        image_user.setImage(image);
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Lấy dữ liệu tên người dùng và password từ database push vào Hash Map
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT USERNAME,PASS FROM USER ");
            while (resultSet.next()) {
                username = resultSet.getString("USERNAME");
                password = resultSet.getString("PASS");
                acc_user.put(username,password);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
                System.out.println(filePath);
                try {
                    Set<String> keySet = acc_user.keySet();
                    for (String key : keySet) {
                        System.out.println(key);
                        System.out.println(acc_user.get(key));
                        if (username.equals(key) && password.equals(acc_user.get(key))) {
                            DBUtils.Update_Infor(actionEvent,username.toString(), password.toString(), filePath.toString());
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setContentText("The information has been updated - PLEASE RESTART THE PROGRAM TO UPDATE YOUR INFORMATION");
                            alert.show();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
