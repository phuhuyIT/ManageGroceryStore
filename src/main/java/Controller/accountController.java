package Controller;

import DAO.RoleDAO;
import DAO.StaffDAO;
import DAO.UserDAO;
import DTO.UserDTO;
import Model.Role;
import Model.Staff;
import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class accountController implements Initializable {

    @FXML
    private Button btn_resetPassword;

    @FXML
    private Button btn_update;

    @FXML
    private ChoiceBox<String> cb_roleList;

    @FXML
    private AnchorPane pane_account;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_role;

    @FXML
    private TextField txt_username;
    @FXML
    private Button btn_createAccount;

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
        cb_roleList.setOnAction(ActionEvent -> {
            txt_role.setText(cb_roleList.getValue());
        });
        btn_update.setOnAction(ActionEvent -> { // Noncompliant
            // Update user
            UserDTO user = new UserDTO( txt_email.getText().toString(), txt_role.getText().toString());
            // Update user in database
            UserDAO userDAO = new UserDAO();
            userDAO.editUserDAO(user);
        });
        btn_resetPassword.setOnAction(ActionEvent -> { // Noncompliant
           // Create new random password
            String newPassword = generatePassword(15);
            // Update user password in database
            UserDAO userDAO = new UserDAO();
            userDAO.resetPassword(txt_username.getText(), newPassword);

        });
        btn_createAccount.setOnAction(ActionEvent -> { // Noncompliant
            // Create new user
            ResultSet rs=new StaffDAO().selectByID(StaffController.getCurrentItemID());
            try {
                if(rs.next()){
                    Staff staff = new Staff(rs.getString("email"), rs.getString("fullname"), rs.getDate("birthdate"), rs.getDate("joinDate"), rs.getInt("id"));
                    new StaffDAO().addAccountStaff(staff);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        List<Role> roles = new RoleDAO().getAllRoles();
        String[] roleNamesArray = convertRoleListToStringArray(roles);
        cb_roleList.getItems().addAll(roleNamesArray);
    }

    private String[] convertRoleListToStringArray(List<Role> roleList) {
        String[] roleNamesArray = new String[roleList.size()];
        for (int i = 0; i < roleList.size(); i++) {
            Role role = roleList.get(i);
            roleNamesArray[i] = role.getName();
        }
        return roleNamesArray;
    }


    private void showData() {
        ResultSet rs=new StaffDAO().selectByID(StaffController.getCurrentItemID());
        try {
            if(rs.next()){
                int id = rs.getInt("userID");
                ResultSet rsUser = new UserDAO().selectByID(id);
                if(rsUser != null && rsUser.next()) {
                    txt_username.setText(rsUser.getString("user_username"));
                    txt_email.setText(rsUser.getString("user_email"));
                    txt_role.setText(rsUser.getString("role_name"));
                }
                else {
                    txt_username.setText("");
                    txt_email.setText("");
                    txt_role.setText("");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private String generatePassword(int length) {
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();

        // Add at least one character from each category
        sb.append(UPPER.charAt(random.nextInt(UPPER.length())));
        sb.append(LOWER.charAt(random.nextInt(LOWER.length())));
        sb.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        sb.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        // Fill remaining length with random characters
        for (int i = 4; i < length; i++) {
            String charSet = UPPER + LOWER + DIGITS + SPECIAL;
            sb.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        // Shuffle the characters to make the password more random
        String password = sb.toString();
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        return new String(passwordArray);
    }
}
