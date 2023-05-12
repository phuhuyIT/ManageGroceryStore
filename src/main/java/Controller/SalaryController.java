package Controller;

import DAO.StaffDAO;
import DAO.UserDAO;
import DatabaseConnection.ConnectionFactory;
import Model.Product;
import Model.Staff;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static Model.InventoryAlert.errorAlert;
import static Model.InventoryAlert.informationAlert;

public class SalaryController implements Initializable {
    @FXML
    private Button btn_save;

    @FXML
    private ImageView iv_staffImage;

    @FXML
    private Label lb_fullnameStaff;

    @FXML
    private Label lb_positionStaff;

    @FXML
    private Label lb_basicSalaryStaff;

    @FXML
    private Label lb_totalSalary;

    @FXML
    private AnchorPane pane_salaryStaff;

    @FXML
    private TextField txt_staffBasicSalary;
    @FXML
    private TextField tf_allowance;
    @FXML
    private TextField txt_deduction;
    @FXML
    private TextField tf_workingHours;
    @FXML
    private TextField tf_overTime;
    @FXML
    private DatePicker dp_MonthSalary;
    @FXML
    private Button btn_caculateTotalSalary;
    float result;
    @FXML
    private Button btn_editMonthSalary;
    @FXML
    private TextField tf_enterPassword;
    DecimalFormat formatter = new DecimalFormat("#,###");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
        btn_caculateTotalSalary.setOnAction(e -> caculateSalary());
        dp_MonthSalary.setConverter(new StringConverter<LocalDate>() {
            final String pattern = "MM/yyyy";
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    YearMonth yearMonth = YearMonth.parse(string, dateFormatter);
                    return yearMonth.atDay(1);
                } else {
                    return null;
                }
            }
        });
        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateSalary();
            }
        });
        btn_editMonthSalary.setOnAction(ActionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/enterPassword.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 316, 95);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Salary Management");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            Boolean isCorrectPassword = new ConnectionFactory().checkLogin(LoginController.getLoggedInUsername(), tf_enterPassword.getText());
            if (isCorrectPassword) {
                txt_deduction.setEditable(true);
                tf_allowance.setEditable(true);
                tf_overTime.setEditable(true);
                tf_workingHours.setEditable(true);
                dp_MonthSalary.setEditable(true);
            } else {
                errorAlert("Incorrect password", "YOU ENTER THE WRONG PASSWORD");
            }
        });
    }

    private void showData(){
        ResultSet rs = new StaffDAO().selectByID(StaffController.getCurrentItemID());
        try {
            if(rs.next()){
                lb_fullnameStaff.setText(rs.getString("fullname"));
                lb_positionStaff.setText(rs.getString("position"));
                lb_basicSalaryStaff.setText(rs.getString("basicSalary"));
                String img  = rs.getString("avatarLink");
                if(img!=null) {
                    Image image1 = new Image(String.valueOf(img));
                    iv_staffImage.setImage(image1);
                }
                rs=new StaffDAO().isHasThisMonthSalary(StaffController.getCurrentItemID());
                if(rs.next()){
                    tf_workingHours.setText(String.valueOf(rs.getInt("workingHours")));
                    tf_workingHours.setEditable(false);
                    tf_overTime.setText(String.valueOf(rs.getInt("overtimeHours")));
                    tf_overTime.setEditable(false);
                    tf_allowance.setText(formatter.format(rs.getFloat("allowance")));
                    tf_allowance.setEditable(false);
                    txt_deduction.setText(formatter.format(rs.getFloat("deduction")));
                    txt_deduction.setEditable(false);
                    dp_MonthSalary.setValue(rs.getDate("monthSalary").toLocalDate());
                    dp_MonthSalary.setEditable(false);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void caculateSalary(){
        float basicSalary = Float.parseFloat(lb_basicSalaryStaff.getText());
        result= (float) (basicSalary*(Integer.parseInt(tf_workingHours.getText())+Integer.parseInt(tf_overTime.getText())*1.5)
                        +Float.parseFloat(tf_allowance.getText())+Float.parseFloat(txt_deduction.getText()));

        lb_totalSalary.setText(formatter.format(result));
    }
    private void updateSalary(){
        if(dp_MonthSalary.getValue()==null||tf_allowance.getText().isEmpty()||tf_workingHours.getText().isEmpty()||tf_overTime.getText().isEmpty()
        ||txt_deduction.getText().isEmpty()){
            errorAlert("Empty field","PLEASE FILL IN ALL NECESSARY INFORMATION!");
        }
        else{
            new StaffDAO().addMonthlySalary(new Staff(StaffController.getCurrentItemID(),dp_MonthSalary.getValue(),Integer.parseInt(tf_workingHours.getText()),Integer.parseInt(tf_overTime.getText()),Float.parseFloat(tf_allowance.getText()),
                    Float.parseFloat(txt_deduction.getText()),result));
        }


    }
}
