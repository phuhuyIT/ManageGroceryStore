package Controller;

import DAO.UserDAO;
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
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

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
    private Button btn_edit;

    @FXML
    private Label lbl_username;

    @FXML
    private PasswordField tf_password;
    @FXML
    private TextField tf_fullname;
    @FXML
    private TextField tf_phone;
    @FXML
    private TextField tf_location;
    @FXML
    private TextField tf_category;



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
        image_user.setImage(image);
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Lấy dữ liệu tên người dùng và password từ database push vào Hash Map

        try {
            UserDAO userData=new UserDAO();
            System.out.println("cc1  "+LoginController.getLoggedInUsername());
            ResultSet rs=userData.getQueryResult1(LoginController.getLoggedInUsername());
            while (rs.next()){
                String img  = rs.getString("IMAGE");
                if(img!=null) {
                    Image image1 = new Image(String.valueOf(img));
                    image_user.setImage(image1);
                }
                tf_fullname.setText(rs.getString("FULLNAME"));
                tf_phone.setText(rs.getString("PHONE"));
                tf_location.setText(rs.getString("LOCATION"));
                tf_category.setText(rs.getString("CATEGORY"));
                tf_password.setText(rs.getString("PASSWORD"));

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
                System.out.println(filePath);
                try {
                    Set<String> keySet = acc_user.keySet();
                    for (String key : keySet) {
                        System.out.println(key);
                        System.out.println(acc_user.get(key));
                        if (username.equals(key) && password.equals(acc_user.get(key))) {
                            if (!tf_fullname.getText().trim().isEmpty() && !tf_phone.getText().trim().isEmpty() && !tf_location.getText().trim().isEmpty() && !tf_category.getText().trim().isEmpty()) {
                                User user=new User(tf_fullname.getText(),tf_location.getText(), tf_phone.getText(),  username.toString(), password.toString(),tf_category.getText(),filePath.toString());
                                LoginController.Update_Infor(actionEvent,user);
                            } else {
                                System.out.println("Please fill in all information ");
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("Please fill in all information");
                                alert.show();
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
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
