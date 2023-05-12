package Controller;

import DAO.StaffDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showData();
        tf_allowance.setOnAction(e -> caculateSalary(tf_allowance,tf_workingHours,tf_overTime,txt_deduction));
        txt_deduction.setOnAction(e -> caculateSalary(tf_allowance,tf_workingHours,tf_overTime,txt_deduction));
        tf_workingHours.setOnAction(e -> caculateSalary(tf_allowance,tf_workingHours,tf_overTime,txt_deduction));
        tf_overTime.setOnAction(e -> caculateSalary(tf_allowance,tf_workingHours,tf_overTime,txt_deduction));
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void caculateSalary(TextField allowance, TextField workingHours, TextField overTime, TextField deduction){
        float basicSalary = Float.parseFloat(lb_basicSalaryStaff.getText());
        float result= (float) (basicSalary*(Integer.parseInt(workingHours.getText())+Integer.parseInt(overTime.getText())*1.5)
                        +Float.parseFloat(allowance.getText())+Float.parseFloat(deduction.getText()));
        lb_totalSalary.setText(Float.toString(result));
    }
}
