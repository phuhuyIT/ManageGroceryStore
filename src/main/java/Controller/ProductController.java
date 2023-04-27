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
    private AnchorPane anchorPane;

    private String[] choice = {"Tăng theo giá ", "Giảm theo giá" , "A->Z" , "Z->A"};

    private String[] list = {"Cake", "Noodle" , "Fast Food" , "Drinking" , "Ice Cream" , "Vegetable"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox_sort.getItems().addAll(choice);
        choiceBox_list.getItems().addAll(list);
        ProductDAO pdao=new ProductDAO();
        ResultSet rs=pdao.selectALL();
        try {
            for (int i=0;i<10;i++){

                if(rs.next()){
                    HBox hbox = (HBox) anchorPane.lookup("#hbox_line"+(i+1));
                    Label productCode =(Label) hbox.lookup("#product"+(i+1)+"_code");

                    ImageView productThumbnail =(ImageView) hbox.lookup("#product"+(i+1)+"_thumbnail");
                    Label productName =(Label) hbox.lookup("#product"+(i+1)+"_name");
                    Label productCategory =(Label) hbox.lookup("#product"+(i+1)+"_category");
                    Label productSupplier =(Label) hbox.lookup("#product"+(i+1)+"_supplier");
                    Label productPrice =(Label) hbox.lookup("#product"+(i+1)+"_price");
                    //Label productStatus =(Label) hbox.lookup("#product"+(i+1)+"_code");
                    productCode.setText(rs.getString("PRODUCTCODE"));
                    String img  = rs.getString("THUMBNAIL");
                    System.out.println(img);
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        productThumbnail.setImage(image1);
                    }
                    System.out.println(rs.getString("PRODUCTNAME"));
                    productName.setText(rs.getString("PRODUCTNAME"));
                    productCategory.setText(rs.getString("CATEGORY"));
                    productSupplier.setText(rs.getString("BRAND"));
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
