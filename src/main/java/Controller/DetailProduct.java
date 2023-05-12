package Controller;

import DAO.CategoryDao;
import DAO.ProductDAO;
import DAO.SupplierDAO;
import Model.InventoryAlert;
import Model.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DetailProduct extends InventoryAlert implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private Label lb_detailProductName;
    @FXML
    private Label lb_detailProductSupplierName;
    @FXML
    private Label lb_detailProductSupplierLocation;
    @FXML
    private Label lb_detailProductSupplierPhone;
    @FXML
    private ChoiceBox cb_detailProductCategory;
    @FXML
    private Label lb_detailProductQuantity;
    @FXML
    private Label lb_detailProductUPC;
    @FXML
    private ImageView iv_productThumbnail;
    @FXML
    private ChoiceBox cb_mfgDate;
    @FXML
    private Label lb_expDate;
    @FXML
    private TextField tf_detailProductCostPrice;
    @FXML
    private TextField tf_detailProductSellingPrice;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_update;
    private File filePath;
    private FileChooser fileChooser;

    @FXML
    public void chooseImageProduct(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Open image");

        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);


        fileChooser.setInitialDirectory(userDirectory);
        filePath = fileChooser.showOpenDialog(stage);

        //cập nhật ảnh mới
        Image image = new Image(String.valueOf(filePath));
        iv_productThumbnail.setImage(image);
    }

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle)  {
        cb_mfgDate.setStyle("-fx-font-size  :18px");
        cb_detailProductCategory.getItems().addAll("Thực phẩm tươi sống","Thực phẩm chế biến sẵn","Hàng gia dụng", "Đồ dùng cá nhân","Vật dụng học tập và văn phòng phẩm",
                "Hóa phẩm và chất tẩy rửa","Đồ chơi và quà tặng","Thuốc và vật dụng y tế");
        setBtnBackAction();

        btn_update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateDetailProduct();
            }
        });
        showProduct();
    }
    protected void setBtnBackAction(){
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("views/products.fxml"));
                Node node = null;
                try {
                    node = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pane.getChildren().add(node);
            }
        });
    }
    private void updateDetailProduct(){
        int categoryID=new CategoryDao().getCategoryIDByName(cb_detailProductCategory.getValue().toString());
        Product product=new Product(lb_detailProductName.getText(),ProductController.getCurrentItemID(),categoryID,Integer.parseInt(lb_detailProductQuantity.getText()),
                filePath.toString(), LocalDate.parse(cb_mfgDate.getValue().toString()),LocalDate.parse(lb_expDate.getText()),
                Double.parseDouble(tf_detailProductCostPrice.getText()),Double.parseDouble(tf_detailProductSellingPrice.getText()));
        new ProductDAO().update(product);
    }
    protected void showProduct(){
        ProductDAO product=new ProductDAO();
        System.out.println("CUR productID: "+ProductController.getCurrentItemID());
        ResultSet rs = product.selectByID(ProductController.getCurrentItemID());

        CategoryDao categoryDao = new CategoryDao();

        try {
            if(rs.next()){
                String img  = rs.getString("THUMBNAIL");
                if(img!=null) {
                    Image image1 = new Image(String.valueOf(img));
                    iv_productThumbnail.setImage(image1);
                }
                lb_detailProductName.setText(rs.getString("PRODUCTNAME"));
                int categoryID=rs.getInt("Categoryid");

                cb_detailProductCategory.setValue(categoryDao.getNameByCategoryID(categoryID));
                lb_detailProductQuantity.setText(String.valueOf(product.getQuantity(rs.getInt("Pid"))));
                tf_detailProductCostPrice.setText(String.valueOf(rs.getDouble("COSTPRICE")));
                tf_detailProductSellingPrice.setText(String.valueOf(rs.getDouble("SELLINGPRICE")));
                lb_detailProductUPC.setText(rs.getString("PRODUCTBARCODE"));
                cb_mfgDate.setValue(rs.getDate("manufractureDate").toLocalDate());
                lb_expDate.setText(String.valueOf(rs.getDate("expirationDate")));
                String thumbnailLink = rs.getString("THUMBNAIL");
                if(thumbnailLink!=null){
                    Image productThumnail = new Image(String.valueOf(thumbnailLink));
                    iv_productThumbnail.setImage(productThumnail);
                    filePath=new File(thumbnailLink);
                }
                ResultSet rs2 = new SupplierDAO().selectByID(rs.getInt("SID"));
                if(rs2.next()){
                    lb_detailProductSupplierName.setText(rs2.getString("FULLNAME"));
                    lb_detailProductSupplierLocation.setText(rs2.getString("LOCATION"));
                    lb_detailProductSupplierPhone.setText(rs2.getString("PHONE"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
