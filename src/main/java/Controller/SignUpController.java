package Controller;

import MailConfig.MailConfig;
import Model.InventoryAlert;
import Model.Verification;
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

public class SignUpController extends InventoryAlert implements Initializable {

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
                    errorAlert("ERROR","Email is empty");
                } else {
                    if (isValid) {
                        System.out.println("Email is valid.");
                        if (tf_username.getText().equals("") || !Verification.CheckUsername(tf_username.getText())) {
                            System.out.println("username");
                            errorAlert("ERROR","Invalid Username");
                            return;
                        }

                        if (tf_password.getText().equals("") || !Verification.CheckPass(tf_password.getText())) {
                            System.out.println("password");
                            errorAlert("ERROR","Invalid Password");
                            return;
                        }

                        if (!tf_confirmpass.getText().equals(tf_password.getText())) {
                            System.out.println("Confirm");
                            errorAlert("ERROR","Confirm Password is empty");
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

                    } else {
                        errorAlert("ERROR","Email is Invalid");
                    }
                }



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
