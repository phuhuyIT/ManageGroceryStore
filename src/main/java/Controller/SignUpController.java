package Controller;

import MailConfig.MailConfig;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Model.InventoryAlert.errorAlert;

public class SignUpController implements Initializable {

    public TextField email;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button btn_signup;
    @FXML
    private Hyperlink btn_log_in;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField tf_password;
    @FXML
    private PasswordField tf_confirmpass;

    public class EmailValidator {
        private static final String EMAIL_REGEX =
                "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        public static boolean isValidEmail(String email) {
            Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        btn_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                boolean isValid = ForgotPasswordController.EmailValidator.isValidEmail(email.getText());
                if (email.getText().equals("")) {
                    System.out.println("Email");
                    alert.setTitle("Warning");
                    alert.setContentText("Warning:Trường email của bạn đang trông!Vui lòng nhập email");
                    alert.showAndWait();
                } else {
                    if (isValid) {
                        System.out.println("Email is valid.");
                    } else {
                        alert.setTitle("Warning");
                        alert.setContentText("Warning:Email của bạn không hợp lệ !");
                        alert.showAndWait();
                    }
                }

                if (tf_username.getText().equals("")) {
                    System.out.println("username");
                    alert.setTitle("Warning");
                    alert.setContentText("Warning:Trường username của bạn đang trông!Vui lòng nhập username");
                    alert.showAndWait();
                    return;
                }

                if (tf_password.getText().equals("")) {
                    System.out.println("password");
                    alert.setTitle("Warning");
                    alert.setContentText("Warning:Trường password của bạn đang trông!Vui lòng nhập password");
                    alert.showAndWait();
                    return;
                }

                if (!tf_confirmpass.getText().equals(tf_password.getText())) {
                    System.out.println("Confirm");
                    alert.setTitle("Warning");
                    alert.setContentText("Warning:Trường confirm của bạn đang trông!Vui lòng nhập lại mật khẩu");
                    alert.showAndWait();
                    return;
                }


                MailConfig.sendOTP(email.getText());
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Nhập thông tin");
                dialog.setHeaderText("Vui lòng nhập thông tin");
                dialog.setContentText("Nhập OTP verify email:");

                Optional<String> result = dialog.showAndWait();
                String otp = result.get();
                if (!MailConfig.verifyOTP(email.getText(), otp)) {
                    alert.showAndWait();
                    return;
                }
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty() && !tf_confirmpass.getText().trim().isEmpty()) {
                    LoginController.SignUpUser(event, email.getText(), tf_username.getText(), tf_password.getText(), tf_confirmpass.getText());
                    return;
                }

                errorAlert("ERROR", "Please fill in all information!");

            }
        });

        btn_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginController.changeScence1(event, "views/hello-view.fxml", "Log In", null);
            }
        });
    }
}
