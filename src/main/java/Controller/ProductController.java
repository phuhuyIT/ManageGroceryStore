package Controller;

import DAO.ProductDAO;
import Model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
    private ChoiceBox<String> choiceBox_sort;

    @FXML
    private ChoiceBox<String> choiceBox_list;
    @FXML
    private AnchorPane anchorPane_Product;

    private String[] choice = {"Tăng theo giá ", "Giảm theo giá" , "A->Z" , "Z->A"};

    private String[] list = {"Cake", "Noodle" , "Fast Food" , "Drinking" , "Ice Cream" , "Vegetable"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox_sort.getItems().addAll(choice);
        choiceBox_sort.setStyle("-fx-font-size:15px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
        choiceBox_list.setStyle("-fx-font-size:20px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
        choiceBox_list.getItems().addAll(list);
        ProductDAO pdao=new ProductDAO();
        ResultSet rs=pdao.selectALL();
        try {
            for (int i=0;i<8;i++){

                if(rs.next()){
                    AnchorPane ap = (AnchorPane) anchorPane_Product.lookup("#productBox"+(i+1));

                    ImageView productThumbnail =(ImageView) ap.lookup("#productThumbnail"+(i+1));
                    Label productQuantity =(Label) ap.lookup("#productQuantity"+(i+1));
                    Label productPrice =(Label)ap.lookup("#productPrice"+(i+1));
                    String img  = rs.getString("THUMBNAIL");
                    System.out.println(img);
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        productThumbnail.setImage(image1);
                    }
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
