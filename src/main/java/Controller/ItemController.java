package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ItemController extends Pagination {
    protected static int currentItemID;
    @FXML
    protected Button btn_scanSKU;
    @FXML
    protected ImageView iv_scanSKU;
    public static int getCurrentItemID() {return currentItemID;}
    protected abstract void loadFXML(String fxmlPath);
    protected abstract void search();
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
        delete.setStyle("-fx-font-size : 16px ; -fx-padding : 0px 0px 0px 50px;");

        MenuItem detail = new MenuItem("Detail");
        ImageView iconDetail = new ImageView(new Image(getClass().getResourceAsStream("image/list.png")));
        iconDetail.setFitHeight(30);
        iconDetail.setFitWidth(30);
        detail.setGraphic(iconDetail);
        detail.setText("Detail");
        detail.setStyle("-fx-font-size : 16px ; -fx-padding : 0px 0px 0px 50px;");


        contextMenu.getItems().addAll(detail,delete);

        setRightLickAction(contextMenu,delete,detail);

    }
    protected abstract void setRightLickAction(ContextMenu contextMenu, MenuItem delete,MenuItem detail);
}
