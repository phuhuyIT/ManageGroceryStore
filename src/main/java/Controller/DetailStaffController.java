package Controller;

import DAO.StaffDAO;
import Model.Staff;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class DetailStaffController implements Initializable {
    @FXML
    private Button btn_addThumnail;

    @FXML
    private Button btn_save;

    @FXML
    private ChoiceBox<String> cb_DStaffPosition;

    @FXML
    private ImageView iv_DStaffImage;

    @FXML
    private Label lb_bdDStaff;

    @FXML
    private Label lb_fullnameDStaff;

    @FXML
    private Label lb_fwdDStaff;

    @FXML
    private Label lb_genderDStaff;

    @FXML
    private Label lb_indentifierDStaff;

    @FXML
    private AnchorPane pane_detailStaff;

    @FXML
    private TextField txt_DstaffBasicSalary;

    @FXML
    private TextField txt_emailDStaff;

    @FXML
    private TextField txt_locationDStaff;

    @FXML
    private TextField txt_phoneNumberDStaff;
    private File filePath;
    private FileChooser fileChooser;
    @FXML
    public void chooseImageStaff(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");

        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);


        fileChooser.setInitialDirectory(userDirectory);
        filePath = fileChooser.showOpenDialog(stage);

        //cập nhật ảnh mới
        Image image = new Image(String.valueOf(filePath));
        iv_DStaffImage.setImage(image);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setBtnSaveAction();
        showData();
    }

    protected void setBtnSaveAction() {
        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateDetailStaff();
            }
        });
    }
    private void showData(){
        ResultSet rs=new StaffDAO().selectByID(CustomerController.getCurrentItemID());
            try {
                if(rs.next()){
                    lb_fullnameDStaff.setText(rs.getString("FULLNAME"));
                    lb_indentifierDStaff.setText(rs.getString("staffIDCard"));
                    txt_emailDStaff.setText(rs.getString("email"));
                    txt_phoneNumberDStaff.setText(rs.getString("phone"));
                    txt_locationDStaff.setText(rs.getString("location"));
                    lb_genderDStaff.setText(rs.getString("gender"));
                    lb_bdDStaff.setText(rs.getDate("BIRTHDATE").toString());

                    String img  = rs.getString("avatarLink");
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        iv_DStaffImage.setImage(image1);
                        filePath=new File(img);
                    }
                    txt_DstaffBasicSalary.setText(String.valueOf(rs.getFloat("basicSalary")));
                    cb_DStaffPosition.setValue(rs.getString("Position"));
                    lb_fwdDStaff.setText(rs.getDate("joinDate").toString());
                }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

    }
    private void updateDetailStaff(){
        if(lb_genderDStaff.getText().equals("0")&&filePath==null){
            filePath = new File("D:/java/ManageGroceryStore/src/main/resources/Controller/image/woman1.jpg");
        } else if (lb_genderDStaff.getText().equals("1")&&filePath==null) {
            filePath = new File("D:/java/ManageGroceryStore/src/main/resources/Controller/image/man.jpg");
        }
        System.out.println(lb_genderDStaff.getText());
        if(txt_locationDStaff.getText()==null)
            txt_locationDStaff.setText("");
        if(txt_emailDStaff.getText()==null)
            txt_emailDStaff.setText("");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Staff staff = new Staff(StaffController.getCurrentItemID(), txt_locationDStaff.getText(), txt_phoneNumberDStaff.getText(), txt_emailDStaff.getText(),filePath.toString(),
                Float.parseFloat(txt_DstaffBasicSalary.getText()),cb_DStaffPosition.getValue());
        new StaffDAO().update(staff);
    }

}
