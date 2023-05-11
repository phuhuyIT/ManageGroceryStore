package Controller;

import DAO.ProductDAO;
import Model.Category;
import Model.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductController extends ItemController implements Initializable {
    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_search;
    @FXML
    private Button btn_addProduct;


    @FXML
    private ChoiceBox<String> choiceBox_sort;

    @FXML
    private ChoiceBox<String> choiceBox_list;
    @FXML
    private AnchorPane pane_Product;
    private String[] choice = {"Tăng theo giá ", "Giảm theo giá" , "A->Z" , "Z->A"};

    private String[] list = {"Cake", "Noodle" , "Fast Food" , "Drinking" , "Ice Cream" , "Vegetable"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberData = new ProductDAO().getNumProuduct();
        Limit=8;
        offSet=0;

        choiceBox_sort.getItems().addAll(choice);
        choiceBox_sort.setStyle("-fx-font-size:15px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
        choiceBox_list.setStyle("-fx-font-size:20px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
        choiceBox_list.getItems().addAll(list);

    btn_addProduct.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            loadFXML("views/addProduct.fxml");
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
        pane_Product.getChildren().set(0,node);
    }

    @Override
    protected void showData(int limit, int offSet) {
        ProductDAO pdao=new ProductDAO();
        ResultSet rs=pdao.selectALL(limit,offSet);
        try {
            for (int i=0;i<8;i++){

                if(rs.next()){
                    AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(i+1));

                    ImageView productThumbnail =(ImageView) ap.lookup("#productThumbnail"+(i+1));
                    Label productQuantity =(Label) ap.lookup("#productQuantity"+(i+1));
                    Label productPrice =(Label)ap.lookup("#productPrice"+(i+1));
                    Label productName = (Label)ap.lookup("#productName"+(i+1));
                    String img  = rs.getString("THUMBNAIL");
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        productThumbnail.setImage(image1);

                    }
                    productName.setText(rs.getString("PRODUCTNAME"));
                    ap.setUserData(rs.getString("PID"));
                    productQuantity.setText(rs.getString("SELLINGPRICE"));
                    productPrice.setText(rs.getString("COSTPRICE"));
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
                AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(i+1));

                ImageView productThumbnail =(ImageView) ap.lookup("#productThumbnail"+(i+1));
                Label productQuantity =(Label) ap.lookup("#productQuantity"+(i+1));
                Label productPrice =(Label)ap.lookup("#productPrice"+(i+1));
                Label productName = (Label)ap.lookup("#productName"+(i+1));
                String img  = "D:/java/ManageGroceryStore/src/main/resources/Controller/image/empty.png";
                if(img!=null) {
                    Image image1 = new Image(String.valueOf(img));
                    productThumbnail.setImage(image1);

                }
                productName.setText("");
                productQuantity.setText("");
                productPrice.setText("");

        }
    }
    protected void setRightLickAction(ContextMenu contextMenu, MenuItem delete,MenuItem detail ,MenuItem cancel){
        // Thiết lập sự kiện chuột phải cho productBox
        for (int i=0;i<8;i++){
            AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(i+1));
            ap.setOnContextMenuRequested(event -> {
                AnchorPane btn= (AnchorPane) event.getSource();
                String id= (String)btn.getUserData();
                currentItemID = Integer.parseInt(id);
                contextMenu.show(ap, event.getScreenX(), event.getScreenY());
                event.consume(); // đánh dấu sự kiện này đã được xử lý
            });
        }

        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            System.out.println("Dã xoá");
        });
        cancel.setOnAction(actionEvent -> {
            contextMenu.hide();
        });
        detail.setOnAction(actionEvent -> {
            String fxmlPath = "views/detailProduct.fxml";
            loadFXML(fxmlPath);
        });
    }
}

