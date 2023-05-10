package Controller;

import DAO.UserDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.Set;

public class HomeController implements Initializable {

    @FXML
    private Button btn_logout;
    @FXML
    private Button btn_DashBoard;

    @FXML
    private Button btn_Customer;

    @FXML
    private Button btn_Product;
    @FXML
    private Button btn_Staff;
    @FXML
    private Button btn_Caculator;

    @FXML
    private Button btn_Bill;
    @FXML
    private Button btn_UserProfile;
    @FXML
    private Label wlc_user;

    @FXML
    private Label lblClock;

    @FXML
    private ImageView img_user;

    @FXML
    public AnchorPane paneRight;

    private String userName;
    private String avatarSrc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //hiển thị bảng dashboard lên đầu tiên khi login thành công
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/dashboard.fxml"));

        Node node = null;
        try {
            node = loader.load();
            paneRight.getChildren().add(0, node);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //cài sự kiện cho btn_DashBoard
        btn_DashBoard.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/dashboard.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                paneRight.getChildren().set(0, node);

            }

        });

        //cài sự kiện cho btn_Customer
       btn_Customer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/customer.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                paneRight.getChildren().set(0, node);
            }
        });

       //cài sự kiện cho btn_Product
        btn_Product.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/products.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                paneRight.getChildren().set(0, node);
            }
        });
        // cài sự kiện cho btn_Staff
        btn_Staff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/staff.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                paneRight.getChildren().set(0, node);
            }
        });

        //set sự kiện cho btn_Caculator
        btn_Caculator.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/sell.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                paneRight.getChildren().set(0, node);
            }
        });
        // cài sự kiện cho btn_Bill
        btn_Bill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/bill.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                paneRight.getChildren().set(0, node);
            }
        });
        //cài sự kiện cho btn_UserProfile
        btn_UserProfile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/user_profile.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                paneRight.getChildren().set(0, node);
            }
        });
        //cài sự kiện cho btn_Logout
        btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LoginController.changeScence1(actionEvent, "views/hello-view.fxml", "Log In", null);
            }
        });
        //thiết lập đồng hồ hiển thị thời gian trên máy
        Runnable clock = new Runnable() {
            @Override
            public void run() {
                runClock();
            }
        };

        Thread newClock = new Thread(clock); //Creating new thread
        newClock.setDaemon(true); //Thread will automatically close on applications closing
        newClock.start(); //Starting Thread
    }


    public void setUserInformation(String username) throws SQLException {
        wlc_user.setText(username);
        //So sánh tên username , nếu trùng tên trong HashMap sẽ lấy ra avatar tương ứng
        UserDAO user = new UserDAO();
        ResultSet rs =user.getUser(username);

        try {
            if (rs.next()) {
                avatarSrc =rs.getString("IMAGE");
                if(avatarSrc!=null){
                    Image avatar = new Image(String.valueOf(avatarSrc));
                    img_user.setImage(avatar);
                }
            }
            else return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Setting Clock within a new Thread
    public void runClock() {
        while (true) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    // Getting the system time in a string
                    String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
                    // Setting the time in a label
                    lblClock.setText(time);
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
