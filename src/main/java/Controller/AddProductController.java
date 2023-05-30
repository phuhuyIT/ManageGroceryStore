package Controller;

import DAO.CategoryDao;
import DAO.ProductDAO;
import DAO.SupplierDAO;
import Model.Product;
import Model.Supplier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Controller.InventoryAlert.errorAlert;
import static Controller.InventoryAlert.informationAlert;

public class AddProductController extends ProductController implements Initializable {
    @FXML
    private DatePicker dp_addProductManufractureDate;

    @FXML
    private DatePicker dp_addProductExpireDate;

    @FXML
    private Button btn_back;
    @FXML
    private Button btn_addThumnail;
    @FXML
    private AnchorPane pane;
    private File filePath;
    private FileChooser fileChooser;
    @FXML
    private ImageView image_product;
    @FXML
    private TextField tf_addProductName;
    @FXML
    private TextField tf_addProductSupplierName;
    @FXML
    private TextField tf_addProductSupplierLocation;
    @FXML
    private TextField tf_addProductSupplierPhone;
    @FXML
    private TextField tf_addProductQuantity;
    @FXML
    private TextField tf_addProductUPC;
    @FXML
    private TextField tf_addProductCostPrice;
    @FXML
    private TextField tf_addProductSellingPrice;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_addProductUPCScan;

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
        image_product.setImage(image);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Định dạng DatePicker thành dd/mm/yyyy
        setDatePickerConverter(dp_addProductManufractureDate);
        setDatePickerConverter(dp_addProductExpireDate);
//        cb_addProductCategory.getItems().addAll("Thực phẩm tươi sống","Thực phẩm chế biến sẵn","Hàng gia dụng", "Đồ dùng cá nhân","Vật dụng học tập và văn phòng phẩm",
//                "Hóa phẩm và chất tẩy rửa","Đồ chơi và quà tặng","Thuốc và vật dụng y tế");
        setBtnBackAction();

        setUpMenuAdd();
        btn_save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addProduct();
            }
        });
        btn_addProductUPCScan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runnable clock = new Runnable() {
                        @Override
                        public void run() {
                            CameraApp barCodeScanner= new CameraApp();
                            barCodeScanner.setTextField(tf_addProductUPC);
                            barCodeScanner.run();
                        }
                    };

                    Thread newClock = new Thread(clock); //Creating new thread
                    newClock.setDaemon(true); //Thread will automatically close on applications closing
                    newClock.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
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




    private void setDatePickerConverter(DatePicker datePicker) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                return date == null ? "" : dateFormatter.format(date);
            }
            @Override
            public LocalDate fromString(String string) {
                return string == null || string.isEmpty() ? null : LocalDate.parse(string, dateFormatter);
            }
        };

        datePicker.setConverter(converter);
    }
    private void addProduct(){
        if(filePath==null)
            filePath = new File("D:/java/ManageGroceryStore/src/main/resources/Controller/image/PHMart.jpg");
        if(tf_addProductName.getText().isEmpty()||lb_Category.getText()==null||tf_addProductQuantity.getText().isEmpty()||
        tf_addProductUPC.getText().isEmpty()||dp_addProductManufractureDate.getValue()==null||dp_addProductExpireDate.getValue()==null||
                tf_addProductCostPrice.getText().isEmpty()||tf_addProductSellingPrice.getText().isEmpty()){
            errorAlert("Empty field","PLEASE FILL IN ALL NECESSARY INFORMATION!");
        }else{
            Supplier supplier = new Supplier(tf_addProductSupplierName.getText(),tf_addProductSupplierLocation.getText(),tf_addProductSupplierPhone.getText());
            SupplierDAO supplierDAO = new SupplierDAO();
            int sid = supplierDAO.insert(supplier);

            CategoryDao categoryDao= new CategoryDao();
            int categoryId =categoryDao.getCategoryIDByName(lb_Category.getText());
            ProductDAO productdao = new ProductDAO();
            Product product = new Product(tf_addProductName.getText(),categoryId,tf_addProductUPC.getText(),filePath.toString(),sid,Double.parseDouble(tf_addProductCostPrice.getText()),Double.parseDouble(tf_addProductSellingPrice.getText()),
                    dp_addProductManufractureDate.getValue(),dp_addProductExpireDate.getValue(),Integer.parseInt(tf_addProductQuantity.getText()));
            int isAdded=productdao.insert(product);

            if(isAdded!=0)
                informationAlert("Successful addition","THIS PRODUCT HAS BEEN ADDED");
        }
    }
}
