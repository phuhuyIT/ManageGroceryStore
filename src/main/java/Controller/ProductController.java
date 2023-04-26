package Controller;

import DAO.ProductDAO;
import Model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private Label product1_code;
    private Label product2_code;
    private Label product3_code;
    private Label product4_code;
    private Label product5_code;
    private Label product6_code;
    private Label product7_code;

    private String[] choice = {"Tăng theo giá ", "Giảm theo giá" , "A->Z" , "Z->A"};

    private String[] list = {"Cake", "Noodle" , "Fast Food" , "Drinking" , "Ice Cream" , "Vegetable"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList <HBox> hboxList= new ArrayList<HBox>();
        choiceBox_sort.getItems().addAll(choice);
        choiceBox_list.getItems().addAll(list);
        ProductDAO pdao=new ProductDAO();
        ResultSet rs=pdao.selectALL();
        try {
            rs.next();
            String code =rs.getString("PRODUCTCODE");
            String thumbnail=rs.getString("THUMBNAIL");
            String  name=rs.getString("PRODUCTNAME");
            String costPrice=rs.getString("COSTPRICE");
            String category= rs.getString("CATEGORY");
            String supplier =rs.getString("BRAND");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
