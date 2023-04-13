package com.example.btl_demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.w3c.dom.ls.LSOutput;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.Set;

import static com.example.btl_demo.DBUtils.*;

public class HomeController implements Initializable {

    @FXML
    private Button btn_logout;

    @FXML
    private Label wlc_user;

    @FXML
    private Label lblClock;

    @FXML
    private ImageView img_user;
    private String avatarSrc;
    private String userName;
    private HashMap<String, String> acc = new HashMap<String, String>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScence1(actionEvent, "hello-view.fxml", "Log In", null);
            }
        });

        Runnable clock = new Runnable() {
            @Override
            public void run() {
                runClock();
            }
        };

        Thread newClock = new Thread(clock); //Creating new thread
        newClock.setDaemon(true); //Thread will automatically close on applications closing
        newClock.start(); //Starting Thread

        //Lấy dữ liệu tên người dùng và link ảnh từ database và put vào HashMap
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "13062003");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT USERNAME,AVATAR_SRC FROM USER ") ;
            while (resultSet.next()) {
                userName = resultSet.getString("USERNAME");
                avatarSrc = resultSet.getString("AVATAR_SRC");
                acc.put(userName,avatarSrc);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void setUserInformation(String username) {
        wlc_user.setText(username);
        //So sánh tên username , nếu trùng tên trong HashMap sẽ lấy ra avatar tương ứng
        Set<String> keySet = acc.keySet();
        for (String key : keySet) {
            if (username.equals(key)) {
                Image image = new Image(String.valueOf(acc.get(key)));
                img_user.setImage(image);
            }
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
