package Controller;

import DAO.CustomerDAO;
import DAO.ProductDAO;
import Model.CameraApp;
import Model.Customer;
import Model.Product;
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
import java.util.ResourceBundle;

public class CustomerController extends ItemController implements Initializable {

    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_Search;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button btn_add_user;
    @FXML
    private AnchorPane anchorPane_customer;
    @FXML
    private Label lb_pageNumber;
    @FXML
    private Button btn_search;
    private String[] choice = {"Tìm theo tên" , "Tìm theo số cccd"};
    private ObservableList <Customer> customerSearchList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Limit=8;
        offSet=0;
        btn_scanSKU.setVisible(false);
        iv_scanSKU.setVisible(false);
        choiceBox.setValue("Tìm theo tên");
        choiceBox.getItems().addAll(choice);
        showData(Limit,offSet);
        btn_scanSKU.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runnable clock = new Runnable() {
                        @Override
                        public void run() {
                            CameraApp barCodeScanner= new CameraApp();
                            barCodeScanner.setTextFieldForCustomer(null,txt_search,null,null, null);
                            barCodeScanner.run();

                        }
                    };

                    Thread newClock = new Thread(clock); //Creating new thread
                    newClock.setDaemon(true); //Thread will automatically close on applications closing
                    newClock.start();
                    newClock.interrupt();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        choiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(choiceBox.getValue().equals("Tìm theo số cccd")){
                    btn_scanSKU.setVisible(true);
                    iv_scanSKU.setVisible(true);
                }else {
                    btn_scanSKU.setVisible(false);
                    iv_scanSKU.setVisible(false);
                }

            }
        });
        btn_add_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/addCustomer.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                anchorPane_customer.getChildren().add(node);
            }
        });
        setActionForBtn();
        setRightLick();
        search();
    }
    @Override
    public void loadFXML(String fxmlPath) {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Node node = null;
        try {
            node = loader.<Node>load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        anchorPane_customer.getChildren().add(node);
    }


    protected void setRightLickAction(ContextMenu contextMenu, MenuItem delete, MenuItem detail) {
        for (int i=0;i<8;i++){
            AnchorPane ap = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
            ap.setOnContextMenuRequested(event -> {
                AnchorPane btn= (AnchorPane) event.getSource();
                String id= String.valueOf(btn.getUserData());
                currentItemID = Integer.parseInt(id);
                contextMenu.show(ap, event.getScreenX(), event.getScreenY());
                event.consume(); // đánh dấu sự kiện này đã được xử lý
            });
        }


        //Định dạng contextMenu
        contextMenu.setStyle("-fx-pref-width: 150px; -fx-pref-height: 90px; -fx-padding : 7px 0px 0px 0px;");
        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            new CustomerDAO().delete(currentItemID);
        });
        detail.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/detailCustomer.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),961, 767);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Detail Customer");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
    }

    @Override
    public void showData(int limit, int offSet){
        isSearch=false;
        numberData = new CustomerDAO().getNumCustomer();
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));

        CustomerDAO customers= new CustomerDAO();
        ResultSet rs=customers.selectALL(Limit,offSet);
        try {
            for (int i=0;i<8;i++){

                if(rs.next()){
                    AnchorPane anchorPane = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
                    Label customerName =(Label) anchorPane.lookup("#nameCustomer"+(i+1));
                    ImageView customerAvatar =(ImageView) anchorPane.lookup("#imageCustomer"+(i+1));
                    Label customerGender =(Label) anchorPane.lookup("#genderCustomer"+(i+1));
                    Label customerPhone =(Label) anchorPane.lookup("#phoneCustomer"+(i+1));
                    anchorPane.setUserData(rs.getString("CID"));
                    String img  = rs.getString("AVATARLINK");
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        customerAvatar.setImage(image1);
                    }
                    customerName.setText(rs.getString("FULLNAME"));
                    if (0 != rs.getInt("GENDER")) {
                        customerGender.setText("Nữ");
                    }else customerGender.setText("Nam");
                    customerPhone.setText(rs.getString("PHONE"));
                }
                else
                    return;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void clearData(){
            for (int i=0;i<8;i++){
                    AnchorPane anchorPane = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(i+1));
                    Label customerName =(Label) anchorPane.lookup("#nameCustomer"+(i+1));
                    ImageView customerAvatar =(ImageView) anchorPane.lookup("#imageCustomer"+(i+1));
                    Label customerGender =(Label) anchorPane.lookup("#genderCustomer"+(i+1));
                    Label customerPhone =(Label) anchorPane.lookup("#phoneCustomer"+(i+1));
                    anchorPane.setUserData("");
                    String img  = "C:\\Users\\Tan Thinh\\IdeaProjects\\ManageGroceryStore\\src\\main\\resources\\Controller\\image\\gamer.png";
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        customerAvatar.setImage(image1);
                    }
                    customerName.setText("");
                    customerGender.setText("");
                    customerPhone.setText("");
            }

    }
    public void search(){
        btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //customerList.clear();
                isSearch=true;
                if(choiceBox.getValue().equals("Tìm theo tên"))
                    customerSearchList = FXCollections.observableArrayList(new CustomerDAO().search(txt_search.getText(),"fullname"));

                else {
                    customerSearchList = FXCollections.observableArrayList(new CustomerDAO().search(txt_search.getText(),"citizenIDNumber"));
                }
                clearData();
                showSearchDate(8,0);
            }
        });
    }
    @Override
    protected void showSearchDate(int limit, int offSet) {
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));
        numberData = customerSearchList.size();
        if(offSet+8>=numberData)
            limit=numberData-offSet;
        for (int i=offSet, z=0;i<numberData;i++,z++){
            AnchorPane anchorPane = (AnchorPane) anchorPane_customer.lookup("#CustomerBox_"+(z+1));
            Label customerName =(Label) anchorPane.lookup("#nameCustomer"+(z+1));
            ImageView customerAvatar =(ImageView) anchorPane.lookup("#imageCustomer"+(z+1));
            Label customerGender =(Label) anchorPane.lookup("#genderCustomer"+(z+1));
            Label customerPhone =(Label) anchorPane.lookup("#phoneCustomer"+(z+1));
            String img  = customerSearchList.get(i).getAvatarLink();
            anchorPane.setUserData(customerSearchList.get(i).getCustomersId());
            if(img!=null) {
                Image image1 = new Image(String.valueOf(img));
                customerAvatar.setImage(image1);
            }
            customerName.setText(customerSearchList.get(i).getFullName());
            anchorPane.setUserData(customerSearchList.get(i).getCustomersId());
            customerGender.setText(String.valueOf(customerSearchList.get(i).getGender()));
            customerPhone.setText(String.valueOf(customerSearchList.get(i).getPhone()));
        }
    }
}
