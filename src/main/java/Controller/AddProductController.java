package Controller;

import DAO.CategoryDao;
import DAO.ProductDAO;
import DAO.SupplierDAO;
import Model.CameraApp;
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
import java.util.ResourceBundle;

public class AddProductController extends DetailProductController implements Initializable {
    @FXML
    private MenuButton mbCategory;
    @FXML
    private Label lb_Category;
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
    private ChoiceBox cb_addProductCategory;
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

        //Menu cấp 1
        Menu foodRefesh = new Menu("Thực phẩm tươi sống");
        Menu processFood = new Menu("Thực phẩm chế biến sẵn");
        MenuItem vegestable = new MenuItem("Rau củ quả");
        Menu drink = new Menu("Đồ uống");
        Menu icecream = new Menu("Kem");
        Menu houseHold = new Menu("Hàng gia dụng");
        Menu personalItem = new Menu("Đồ dùng cá nhân");
        Menu officeItem = new Menu("Vật dụng học tập và văn phòng phẩm");
        Menu chemicalItem = new Menu("Hóa phẩm và chất tẩy rửa");
        Menu toy = new Menu("Đồ chơi và quà tặng");
        Menu medical = new Menu("Thuốc và vật dụng y tế");

        //set font size
        foodRefesh.setStyle("-fx-font-size : 18px");
        processFood.setStyle("-fx-font-size : 18px");
        houseHold.setStyle("-fx-font-size : 18px");
        personalItem.setStyle("-fx-font-size : 18px");
        officeItem.setStyle("-fx-font-size : 18px");
        chemicalItem.setStyle("-fx-font-size : 18px");
        toy.setStyle("-fx-font-size : 18px");
        medical.setStyle("-fx-font-size : 18px");
        vegestable.setStyle("-fx-font-size : 18px");
        drink.setStyle("-fx-font-size : 18px");
        icecream.setStyle("-fx-font-size : 18px");

        //Menu cấp 2
        MenuItem meat = new MenuItem("Thịt");
        MenuItem seaFood = new MenuItem("Hải sản");
        meat.setOnAction(event -> {
            lb_Category.setText(meat.getText());
        });
        seaFood.setOnAction(event -> {
            lb_Category.setText(seaFood.getText());
        });
        meat.setStyle("-fx-font-size : 18px");
        seaFood.setStyle("-fx-font-size : 18px");

        vegestable.setOnAction(event -> {
            lb_Category.setText(vegestable.getText());
        });


        MenuItem hotDrink = new MenuItem("Đồ uống nóng");
        MenuItem coldDrink = new MenuItem("Đồ uống lạnh");
        //set font size
        hotDrink.setStyle("-fx-font-size : 18px");
        coldDrink.setStyle("-fx-font-size : 18px");
        //set sự kiện
        hotDrink.setOnAction(event -> {
            lb_Category.setText(hotDrink.getText());
        });
        coldDrink.setOnAction(event -> {
            lb_Category.setText(coldDrink.getText());
        });

        MenuItem boxCream = new MenuItem("Kem hộp");
        MenuItem cupCream = new MenuItem("Kem cốc");
        //set font size
        boxCream.setStyle("-fx-font-size : 18px");
        cupCream.setStyle("-fx-font-size : 18px");
        //set sự kiện
        boxCream.setOnAction(event -> {
            lb_Category.setText(boxCream.getText());
        });
        cupCream.setOnAction(event -> {
            lb_Category.setText(cupCream.getText());
        });

        mbCategory.getItems().addAll(foodRefesh,processFood,houseHold,personalItem,medical,officeItem,chemicalItem,toy,vegestable,drink,icecream);
        foodRefesh.getItems().addAll(meat,seaFood);
        drink.getItems().addAll(hotDrink,coldDrink);
        icecream.getItems().addAll(boxCream,cupCream);






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
                    CameraApp barCodeScanner= new CameraApp();
                    barCodeScanner.getTextField(tf_addProductUPC);
                    barCodeScanner.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
        if(tf_addProductName.getText().isEmpty()||cb_addProductCategory.getValue()==null||tf_addProductQuantity.getText().isEmpty()||
        tf_addProductUPC.getText().isEmpty()||dp_addProductManufractureDate.getValue()==null||dp_addProductExpireDate.getValue()==null||
                tf_addProductCostPrice.getText().isEmpty()||tf_addProductSellingPrice.getText().isEmpty()){
            errorAlert("Empty field","PLEASE FILL IN ALL INFORMATION!");
        }else{
            Supplier supplier = new Supplier(tf_addProductSupplierName.getText(),tf_addProductSupplierLocation.getText(),tf_addProductSupplierPhone.getText());
            SupplierDAO supplierDAO = new SupplierDAO();
            int sid = supplierDAO.insert(supplier);

            CategoryDao categoryDao= new CategoryDao();
            int categoryId =categoryDao.getCategoryIDByName(cb_addProductCategory.getValue().toString());
            ProductDAO productdao = new ProductDAO();
            Product product = new Product(tf_addProductName.getText(),categoryId,tf_addProductUPC.getText(),filePath.toString(),sid,Double.parseDouble(tf_addProductCostPrice.getText()),Double.parseDouble(tf_addProductSellingPrice.getText()),
                    dp_addProductManufractureDate.getValue(),dp_addProductExpireDate.getValue(),Integer.parseInt(tf_addProductQuantity.getText()));
            int isAdded=productdao.insert(product);

            if(isAdded!=0)
                informationAlert("Successful addition","THIS PRODUCT HAS BEEN ADDED");
        }
    }
}
