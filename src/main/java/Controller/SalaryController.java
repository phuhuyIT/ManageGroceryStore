package Controller;

import DAO.StaffDAO;
import DatabaseConnection.ConnectionFactory;
import Model.monthlySalary;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static Controller.InventoryAlert.errorAlert;
import static Controller.InventoryAlert.informationAlert;

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
    private Label lb_notificationEditSalary;
    @FXML
    private Button btn_confirmPassword;
    @FXML
    private TextField tf_enterPassword;
    private monthlySalary staffSalary;
    DecimalFormat formatter = new DecimalFormat("#.###");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
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
        btn_caculateTotalSalary.setOnAction(e -> caculateSalary());
        btn_confirmPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boolean isCorrect = new ConnectionFactory().checkLogin(LoginController.getLoggedInUsername(), new UserProfileController().encryptPassword(tf_enterPassword.getText()) );
                if(isCorrect){
                    informationAlert("Success","NOW YOU CAN EDIT SALARY");
                    tf_workingHours.setEditable(true);
                    tf_overTime.setEditable(true);
                    tf_allowance.setEditable(true);
                    txt_deduction.setEditable(true);
                    dp_MonthSalary.setEditable(true);
                    lb_notificationEditSalary.setVisible(false);
                    btn_confirmPassword.setVisible(false);
                    tf_enterPassword.setVisible(false);
                }else errorAlert("Incorrect","YOU ENTER THE WRONG PASSWORD");
            }
        });
    }
    private void showData(){
        ResultSet rs = new StaffDAO().selectByID(StaffController.getCurrentItemID());
        try {
            if(rs.next()){
                lb_fullnameStaff.setText(rs.getString("fullname"));
                lb_positionStaff.setText(rs.getString("position"));
                lb_basicSalaryStaff.setText(formatter.format(Float.parseFloat(rs.getString("basicSalary"))));
                String img  = rs.getString("avatarLink");
                if(img!=null) {
                    Image image1 = new Image(String.valueOf(img));
                    iv_staffImage.setImage(image1);
                }
                rs=new StaffDAO().isHasThisMonthSalary(StaffController.getCurrentItemID());

                if(rs.next()){
                    staffSalary=new monthlySalary(StaffController.getCurrentItemID(),rs.getDate("monthSalary").toLocalDate(),rs.getInt("workingHours"),
                            rs.getInt("overtimeHours"),rs.getFloat("allowance"),
                            rs.getFloat("deduction"));
                    tf_workingHours.setText(String.valueOf(staffSalary.getWorkingHours()));
                    tf_workingHours.setEditable(false);
                    tf_overTime.setText(String.valueOf(staffSalary.getOvertimeHours()));
                    tf_overTime.setEditable(false);
                    tf_allowance.setText(formatter.format(staffSalary.getAllowance()));
                    tf_allowance.setEditable(false);
                    txt_deduction.setText(formatter.format(staffSalary.getDeduction()));
                    txt_deduction.setEditable(false);
                    dp_MonthSalary.setValue(staffSalary.getMonthSalary());
                    dp_MonthSalary.setEditable(false);
                }else {
                    lb_notificationEditSalary.setVisible(false);
                    btn_confirmPassword.setVisible(false);
                    tf_enterPassword.setVisible(false);
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
            new StaffDAO().addMonthlySalary(new monthlySalary(StaffController.getCurrentItemID(),dp_MonthSalary.getValue(),Integer.parseInt(tf_workingHours.getText()),Integer.parseInt(tf_overTime.getText()),Float.parseFloat(tf_allowance.getText()),
                    Float.parseFloat(txt_deduction.getText())));
        }


    }
}
