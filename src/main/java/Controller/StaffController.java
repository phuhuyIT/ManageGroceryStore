package Controller;

import DAO.CustomerDAO;
import DAO.StaffDAO;
import Model.Customer;
import Model.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;


public class StaffController extends ItemController implements Initializable {
    @FXML
    private Button btn_add_user;
    @FXML
    private TextField txt_search;
    @FXML
    private AnchorPane anchorPane_staff;
    @FXML
    private Label lb_pageNumber;
    @FXML
    private Button btn_search;
    private ObservableList<Staff> staffSearchList;
    @FXML
    private ChoiceBox <String> choiceBox;
    private String[] choice = {"Tìm theo tên" , "Tìm theo số cccd"};
    private Stage accountStage;

    public Stage getAccountStage() {
        return accountStage;
    }

    public void setAccountStage(Stage accountStage) {
        this.accountStage = accountStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberData = new StaffDAO().getNumStaff();
        choiceBox.getItems().addAll(choice);
        btn_scanSKU.setVisible(false);
        iv_scanSKU.setVisible(false);
        Limit=8;
        offSet=0;
        choiceBox.setValue("Tìm theo tên");
        btn_add_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadFXML("views/addStaff.fxml");
            }
        });

        showData(Limit,offSet);
        setActionForBtn();
        setRightLick();
        search();
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

        MenuItem Account = new MenuItem("Account");
        ImageView iconAccount = new ImageView(new Image(getClass().getResourceAsStream("image/account.png")));
        iconAccount.setFitHeight(30);
        iconAccount.setFitWidth(30);
        Account.setGraphic(iconAccount);
        Account.setText("Account");
        Account.setStyle("-fx-font-size : 16px ; -fx-padding : 0px 0px 0px 50px;");

        contextMenu.getItems().addAll(salary, Account);
        for (int i=0;i<8;i++){
            AnchorPane ap = (AnchorPane) anchorPane_staff.lookup("#StaffBox_"+(i+1));
            ap.setOnContextMenuRequested(event -> {
                AnchorPane btn= (AnchorPane) event.getSource();
                String id= String.valueOf(btn.getUserData());
                currentItemID = Integer.parseInt(id);
                contextMenu.show(ap, event.getScreenX(), event.getScreenY());
                event.consume(); // đánh dấu sự kiện này đã được xử lý
            });
        }

        //Định dạng contextMenu
        contextMenu.setStyle("-fx-pref-width: 200px; -fx-pref-height: 130px; -fx-padding : 5px 0px 5px 0px;");

        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            try {
                new StaffDAO().delete(currentItemID);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        detail.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/detailStaff.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),954, 862);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Detail Staff");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
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
        Account.setOnAction(actionEvent ->{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/account.fxml"));
            accountStage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),800, 620);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            accountStage.setTitle("Account");
            accountStage.setScene(scene);
            accountStage.setResizable(false);
            accountStage.show();
        });
    }

    @Override
    protected void showData(int limit, int offSet) {
        //choiceBox.getItems().addAll(choice);
        isSearch=false;
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));
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

    }

    @Override
    protected void clearData() {
        for (int i=0;i<8;i++){
            AnchorPane anchorPane = (AnchorPane) anchorPane_staff.lookup("#StaffBox_"+(i+1));
            Label staffName =(Label) anchorPane.lookup("#nameStaff_"+(i+1));
            ImageView staffAvatar =(ImageView) anchorPane.lookup("#imageStaff_"+(i+1));
            Label staffPosition =(Label) anchorPane.lookup("#positionStaff_"+(i+1));
            Label staffJoinDate =(Label) anchorPane.lookup("#fwd_Staff"+(i+1));
            anchorPane.setUserData(null);
            String img  = "C:\\Users\\phu huy\\IdeaProjects\\ManageGroceryStore\\src\\main\\resources\\Controller\\image\\gamer.png";
            if(img!=null) {
                Image image1 = new Image(String.valueOf(img));
                staffAvatar.setImage(image1);
            }
            staffName.setText("");
            staffPosition.setText("");
            staffJoinDate.setText("");
        }
    }

    @Override
    protected void showSearchDate(int limit, int offSet) {
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));
        numberData = staffSearchList.size();
        if(offSet+8>=numberData)
            limit=numberData-offSet;
        int numberProduct=offSet+limit;
        for (int i=offSet, z=0;i<numberProduct;i++,z++){
            AnchorPane anchorPane = (AnchorPane) anchorPane_staff.lookup("#StaffBox_"+(z+1));
            Label staffName =(Label) anchorPane.lookup("#nameStaff_"+(z+1));
            ImageView staffAvatar =(ImageView) anchorPane.lookup("#imageStaff_"+(z+1));
            Label staffPosition =(Label) anchorPane.lookup("#positionStaff_"+(z+1));
            Label staffJoinDate =(Label) anchorPane.lookup("#fwd_Staff"+(z+1));
            String img  = staffSearchList.get(i).getAvatarLink();
            if(img!=null) {
                Image image1 = new Image(String.valueOf(img));
                staffAvatar.setImage(image1);
            }
            staffName.setText(staffSearchList.get(i).getFullName());
            anchorPane.setUserData(staffSearchList.get(i).getId());
            staffPosition.setText(String.valueOf(staffSearchList.get(i).getPosition()));
            staffJoinDate.setText(String.valueOf(staffSearchList.get(i).getJoinDate()));
        }
    }

    @Override
    protected void search() {
        btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                isSearch=true;
                if(choiceBox.getValue().equals("Tìm theo tên"))
                    staffSearchList = FXCollections.observableArrayList(new StaffDAO().search(txt_search.getText(),"fullname"));

                else {
                    staffSearchList = FXCollections.observableArrayList(new StaffDAO().search(txt_search.getText(),"staffIDCard"));
                }
                System.out.println(staffSearchList);
                clearData();
                showSearchDate(8,0);
            }
        });
    }
}
