package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Hyperlink btn_signup;
    @FXML
    private Button btn_login;
    @FXML
    private ToggleButton tb_showHidePass;
    @FXML
    private Button btn_forgotpassword;
    @FXML
    public TextField tf_username;
    @FXML
    public TextField tf_showPass;
    @FXML
    public PasswordField tf_password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginController.LogInUser(event , tf_username.getText(), tf_password.getText());

            }
        });

        btn_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginController.changeScence1(event , "views/RegisForm.fxml", "Sign Up", null);
            }
        });

        Image icon1 = new Image(getClass().getResource("image/eye.png").toExternalForm());
        Image icon2 = new Image(getClass().getResource("image/show.png").toExternalForm());

        tb_showHidePass.setGraphic(new ImageView(icon1));

        // Đăng ký một bộ lắng nghe sự kiện cho nút
        tb_showHidePass.setOnAction(event -> {
            if (tb_showHidePass.isSelected()) {
                tb_showHidePass.setGraphic(new ImageView(icon2));
                String pass = tf_password.getText();
                tf_showPass.setText(pass);
                tf_showPass.setEditable(true);
                tf_showPass.setVisible(true);
                tf_password.setVisible(false);
            } else {
                tb_showHidePass.setGraphic(new ImageView(icon1));
                tf_password.setEditable(true);
                tf_showPass.setVisible(false);
                tf_password.setVisible(true);
            }
        });
        btn_forgotpassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/forgot-password.fxml"));
                Stage stage = new Stage();
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(),627, 431);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Recovery Password");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });
    }
}