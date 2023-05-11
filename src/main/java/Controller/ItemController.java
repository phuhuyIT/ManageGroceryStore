package Controller;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ItemController extends Pagination {
    protected static int currentItemID;

    public static int getCurrentItemID() {return currentItemID;}
    protected abstract void loadFXML(String fxmlPath);
    protected void setRightLick(){
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

        setRightLickAction(contextMenu,delete,detail,cancel);

    }
    protected abstract void setRightLickAction(ContextMenu contextMenu, MenuItem delete,MenuItem detail ,MenuItem cancel);
}
