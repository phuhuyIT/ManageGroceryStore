package com.example.btl_demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import com.example.btl_demo.HelloController;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/btl_demo/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600, 400);
       // stage.setFullScreen(true);
      //  stage.setMaximized(true);
      //  stage.setResizable(false);
        stage.setTitle("Log In");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}