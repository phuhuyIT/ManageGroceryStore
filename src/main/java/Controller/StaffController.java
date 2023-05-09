package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {
    @FXML
    private Button btn_add_user;

    @FXML
    private AnchorPane anchorPane_staff;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_add_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/addStaff.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                anchorPane_staff.getChildren().add(node);
            }
        });

        //xử lý sự kiện chuột phải
        ContextMenu contextMenu  = new ContextMenu();

        // Thêm các MenuItem vào ContextMenu
        MenuItem delete = new MenuItem("Delete");
        ImageView iconDelete = new ImageView(new Image(getClass().getResourceAsStream("image/delete.png")));
        iconDelete.setFitHeight(30);
        iconDelete.setFitWidth(30);
        delete.setGraphic(iconDelete);
        delete.setText("Delete");
        delete.setStyle("-fx-font-size : 20px ; -fx-padding : 0px 0px 0px 70px;");

        MenuItem detail = new MenuItem("Detail");
        ImageView iconDetail = new ImageView(new Image(getClass().getResourceAsStream("image/list.png")));
        iconDetail.setFitHeight(30);
        iconDetail.setFitWidth(30);
        detail.setGraphic(iconDetail);
        detail.setText("Detail");
        detail.setStyle("-fx-font-size : 20px ; -fx-padding : 0px 0px 0px 70px;");

        MenuItem cancel = new MenuItem("Cancel");
        ImageView iconCancel = new ImageView(new Image(getClass().getResourceAsStream("image/cancel.png")));
        iconCancel.setFitHeight(30);
        iconCancel.setFitWidth(30);
        cancel.setGraphic(iconCancel);
        cancel.setText("Cancel");
        cancel.setStyle("-fx-font-size : 20px ; -fx-text-fill : #FF0000 ; -fx-padding : 0px 0px 0px 70px; -fx-font-weight:bold;");

        //Định dạng contextMenu
        contextMenu.setStyle("-fx-pref-width: 200px; -fx-pref-height: 130px; -fx-padding : 7px 0px 0px 0px;");
        contextMenu.getItems().addAll(detail,delete,cancel);

        // Thiết lập sự kiện chuột phải cho anchorPane_customer
        anchorPane_staff.setOnContextMenuRequested(event -> {
            contextMenu.show(anchorPane_staff, event.getScreenX(), event.getScreenY());
            event.consume(); // đánh dấu sự kiện này đã được xử lý
        });

        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            System.out.println("Dã xoá");
        });
        cancel.setOnAction(actionEvent -> {
            contextMenu.hide();
        });

    }
}
