package Controller;

import DAO.CategoryDao;
import DAO.ProductDAO;
import DAO.SupplierDAO;
import Model.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class DetailProductController extends ProductController implements Initializable {
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
    private Map<LocalDate, LocalDate> batchList = new HashMap<>();

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
       // setBtnBackAction();

        btn_update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateDetailProduct();
            }
        });
        showProduct();
        setUpMenuAdd();
    }

    private void updateDetailProduct(){
        int categoryID=new CategoryDao().getCategoryIDByName(lb_Category.getText());
        if(filePath==null)
            filePath = new File("D:/java/ManageGroceryStore/src/main/resources/Controller/image/PHMart.jpg");
        System.out.println(filePath.toString());
        Product product=new Product(lb_detailProductName.getText(),ProductController.getCurrentItemID(),categoryID,Integer.parseInt(lb_detailProductQuantity.getText()),
                filePath.toString(), Double.parseDouble(tf_detailProductCostPrice.getText()),Double.parseDouble(tf_detailProductSellingPrice.getText()));
        new ProductDAO().update(product);
    }
    protected void showProduct(){
        ProductDAO product=new ProductDAO();

        ResultSet rs = product.selectByID(ProductController.getCurrentItemID());

        CategoryDao categoryDao = new CategoryDao();

        try {
            if(rs.next()){
                System.out.println("CUR productID: "+ProductController.getCurrentItemID());
                lb_detailProductName.setText(rs.getString("PRODUCTNAME"));
                int categoryID=rs.getInt("Categoryid");
                lb_Category.setText(categoryDao.getNameByCategoryID(categoryID));
                lb_detailProductQuantity.setText(String.valueOf(product.getQuantity(rs.getInt("P.Pid"))));
                tf_detailProductCostPrice.setText(String.valueOf(rs.getDouble("COSTPRICE")));
                tf_detailProductSellingPrice.setText(String.valueOf(rs.getDouble("SELLINGPRICE")));
                lb_detailProductUPC.setText(rs.getString("PRODUCTSKU"));
                cb_mfgDate.setValue("Chọn nsx để xem hsd");

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

        //Cho tất cả ngày sản xuất vào choiceBox
        ResultSet rs1 = new ProductDAO().getAllDateByID(ProductController.getCurrentItemID());
        try {
            while(rs1.next()) {
                cb_mfgDate.getItems().add(rs1.getString("manufractureDate"));
                batchList.put(rs1.getDate("manufractureDate").toLocalDate(), rs1.getDate("expirationDate").toLocalDate());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //SetAction chọn ngày sản xuất thì hiển thị hạn sử dụng tương ứng
        cb_mfgDate.setOnAction(ActionEvent -> {
            for (LocalDate key : batchList.keySet()) {
                if (key.equals(LocalDate.parse(cb_mfgDate.getValue().toString()))) {
                    lb_expDate.setText(String.valueOf(batchList.get(key)));
                    break;
                }
            }
        });
    }
}
