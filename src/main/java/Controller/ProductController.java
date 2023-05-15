package Controller;

import DAO.ProductDAO;
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

public class ProductController extends ItemController implements Initializable {
    @FXML
    private TextField txt_search;
    @FXML
    private Label lb_search;
    @FXML
    private Button btn_addProduct;

    @FXML
    private Label lb_pageNumber;
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
                    productQuantity.setText(String.valueOf(new ProductDAO().getQuantity((rs.getInt("pid")))));
                    productPrice.setText(rs.getString("COSTPRICE"));
                }
                else
                    return;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));

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
    protected void setRightLickAction(ContextMenu contextMenu, MenuItem delete,MenuItem detail){
        Menu addLots = new Menu("Add Lots" );
        ImageView iconaddLots = new ImageView(new Image(getClass().getResourceAsStream("image/add-product.png")));
        iconaddLots.setFitHeight(30);
        iconaddLots.setFitWidth(30);
        addLots.setGraphic(iconaddLots);
        addLots.setText("Add Lots");
        addLots.setStyle("-fx-font-size : 16px ; -fx-padding : 0px 0px 0px 50px;");
        contextMenu.getItems().add(1,addLots);

        MenuItem addNewLot = new MenuItem("Add New Lot");
        MenuItem addOldLot = new MenuItem("Add Old Lot");
        addNewLot.setStyle("-fx-font-size : 16px");
        addOldLot.setStyle("-fx-font-size : 16px");

        addLots.getItems().addAll(addNewLot,addOldLot);

        //set sự kiện cho menu cấp2
        addNewLot.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/addNewLot.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),422, 334);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Add New Lot");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });

        addOldLot.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/addOldLot.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),435, 205);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Add Old Lot");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });


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
        //Định dạng contextMenu
        contextMenu.setStyle("-fx-pref-width: 180px; -fx-pref-height: 130px; -fx-padding : 7px 0px 0px 0px;");

        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            new ProductDAO().delete(currentItemID);
        });
        detail.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/detailProduct.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),1000, 900);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Detail Product");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
    }
}

