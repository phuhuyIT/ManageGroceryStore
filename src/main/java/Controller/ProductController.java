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

public class ProductController implements Initializable {
    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_search;
    @FXML
    private Button btn_addProduct;

    @FXML
    private CheckBox select_all;
    @FXML
    private CheckBox select_product1;
    @FXML
    private CheckBox select_product2;
    @FXML
    private CheckBox select_product3;
    @FXML
    private CheckBox select_product4;
    @FXML
    private CheckBox select_product5;
    @FXML
    private CheckBox select_product6;
    @FXML
    private CheckBox select_product7;
    @FXML
    private CheckBox select_product8;

    @FXML
    private ChoiceBox<String> choiceBox_sort;

    @FXML
    private ChoiceBox<String> choiceBox_list;
    @FXML
    private AnchorPane pane_Product;

    private String[] choice = {"Tăng theo giá ", "Giảm theo giá" , "A->Z" , "Z->A"};

    private String[] list = {"Cake", "Noodle" , "Fast Food" , "Drinking" , "Ice Cream" , "Vegetable"};
    private static int currentProductID;

    public static int getCurrentProductID() {return currentProductID;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox_sort.getItems().addAll(choice);
        choiceBox_sort.setStyle("-fx-font-size:15px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
        choiceBox_list.setStyle("-fx-font-size:20px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
        choiceBox_list.getItems().addAll(list);


//        EventHandler<ActionEvent> linktoDetailProduct =event -> {
//            String fxmlPath = "views/detailProduct.fxml";
//            Button btn= (Button) event.getSource();
//            String id= (String)btn.getUserData();
//            currentProductID = Integer.parseInt(id);
//            loadFXML(fxmlPath);
//        };
//
//        for (int i=0;i<8;i++){
//            AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(i+1));
//            Button btnDetailsProduct = (Button) ap.lookup("#btnProductDetails"+(i+1));
//            btnDetailsProduct.setOnAction(linktoDetailProduct);
//        }
    btn_addProduct.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            loadFXML("views/addProduct.fxml");
        }
    });

    select_all.selectedProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
            if (t1) {
                select_product1.setSelected(true);
                select_product2.setSelected(true);
                select_product3.setSelected(true);
                select_product4.setSelected(true);
                select_product5.setSelected(true);
                select_product6.setSelected(true);
                select_product7.setSelected(true);
                select_product8.setSelected(true);
            }else{
                select_product1.setSelected(false);
                select_product2.setSelected(false);
                select_product3.setSelected(false);
                select_product4.setSelected(false);
                select_product5.setSelected(false);
                select_product6.setSelected(false);
                select_product7.setSelected(false);
                select_product8.setSelected(false);
            }
        }
    });
    loadDataProduct();

    }
    private void loadFXML(String fxmlPath) {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Node node = null;
        try {
            node = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane_Product.getChildren().set(0,node);
    }

    protected void loadDataProduct(){
        ProductDAO pdao=new ProductDAO();
        ResultSet rs=pdao.selectALL();
        try {
            for (int i=0;i<8;i++){

                if(rs.next()){
                    AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(i+1));

                    ImageView productThumbnail =(ImageView) ap.lookup("#productThumbnail"+(i+1));
                    Label productQuantity =(Label) ap.lookup("#productQuantity"+(i+1));
                    Label productPrice =(Label)ap.lookup("#productPrice"+(i+1));
                    Button productDetailBtn= (Button) ap.lookup("#btnProductDetails"+(i+1));
                    String img  = rs.getString("THUMBNAIL");
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        productThumbnail.setImage(image1);

                    }
                    productDetailBtn.setUserData(rs.getString("PID"));
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
}

