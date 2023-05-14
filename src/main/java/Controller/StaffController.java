package Controller;

import DAO.CustomerDAO;
import DAO.ProductDAO;
import DAO.StaffDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
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
import java.util.ResourceBundle;


public class StaffController extends ItemController implements Initializable {
    @FXML
    private Button btn_add_user;

    @FXML
    private AnchorPane anchorPane_staff;
    @FXML
    private Label lb_pageNumber;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberData = new StaffDAO().getNumStaff();
        Limit=8;
        offSet=0;
        btn_add_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFXML("views/addStaff.fxml");
            }
        });

        showData(Limit,offSet);
        setActionForBtn();
        setRightLick();
    }

    @Override
    protected void loadFXML(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Node node = null;
        try {
            node = loader.<Node>load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        anchorPane_staff.getChildren().add(node);
    }

    @Override
    protected void setRightLickAction(ContextMenu contextMenu, MenuItem delete, MenuItem detail) {
        MenuItem salary = new MenuItem("Salary Management" );
        ImageView iconSalary = new ImageView(new Image(getClass().getResourceAsStream("image/salary.png")));
        iconSalary.setFitHeight(30);
        iconSalary.setFitWidth(30);
        salary.setGraphic(iconSalary);
        salary.setText("Salary Management");
        salary.setStyle("-fx-font-size : 16px ; -fx-padding : 0px 0px 0px 50px;");

        contextMenu.getItems().add(1,salary);
        for (int i=0;i<8;i++){
            AnchorPane ap = (AnchorPane) anchorPane_staff.lookup("#StaffBox_"+(i+1));
            ap.setOnContextMenuRequested(event -> {
                AnchorPane btn= (AnchorPane) event.getSource();
                String id= (String)btn.getUserData();
                currentItemID = Integer.parseInt(id);
                contextMenu.show(ap, event.getScreenX(), event.getScreenY());
                event.consume(); // đánh dấu sự kiện này đã được xử lý
            });
        }

        //Định dạng contextMenu
        contextMenu.setStyle("-fx-pref-width: 200px; -fx-pref-height: 130px; -fx-padding : 5px 0px 5px 0px;");

        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            System.out.println("Dã xoá");
        });
        detail.setOnAction(actionEvent -> {
            String fxmlPath = "views/detailStaff.fxml";
            loadFXML(fxmlPath);
        });
        salary.setOnAction(actionEvent ->{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/salaryManage.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),800, 620);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Salary Management");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
    }

    @Override
    protected void showData(int limit, int offSet) {
        //choiceBox.getItems().addAll(choice);
        ResultSet rs=new StaffDAO().selectALL(limit,offSet);
        try {
            for (int i=0;i<8;i++){

                if(rs.next()){
                    AnchorPane anchorPane = (AnchorPane) anchorPane_staff.lookup("#StaffBox_"+(i+1));
                    Label staffName =(Label) anchorPane.lookup("#nameStaff_"+(i+1));
                    ImageView staffAvatar =(ImageView) anchorPane.lookup("#imageStaff_"+(i+1));
                    Label staffPosition =(Label) anchorPane.lookup("#positionStaff_"+(i+1));
                    Label staffJoinDate =(Label) anchorPane.lookup("#fwd_Staff"+(i+1));
                    String img  = rs.getString("avatarLink");
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        staffAvatar.setImage(image1);

                    }
                    anchorPane.setUserData(rs.getString("ID"));
                    staffPosition.setText(rs.getString("POSITION"));
                    staffName.setText(rs.getString("FULLNAME"));
                    staffJoinDate.setText(rs.getString("joinDate"));
                }
                else
                    return;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));
    }

    @Override
    protected void clearData() {
        for (int i=0;i<8;i++){
            AnchorPane anchorPane = (AnchorPane) anchorPane_staff.lookup("#StaffBox_"+(i+1));
            Label staffName =(Label) anchorPane.lookup("#nameStaff_"+(i+1));
            ImageView staffAvatar =(ImageView) anchorPane.lookup("#imageStaff_"+(i+1));
            Label staffPosition =(Label) anchorPane.lookup("#positionStaff_"+(i+1));
            Label staffJoinDate =(Label) anchorPane.lookup("#fwd_Staff"+(i+1));

            String img  = "D:\\java\\ManageGroceryStore\\src\\main\\resources\\Controller\\image\\gamer.png";
            if(img!=null) {
                Image image1 = new Image(String.valueOf(img));
                staffAvatar.setImage(image1);
            }
            staffName.setText("");
            staffPosition.setText("");
            staffJoinDate.setText("");
        }
    }
}
