package Controller;

import DAO.BillDao;
import Model.Bill;
import Model.Product;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import javax.imageio.ImageIO;

public class BillController implements Initializable {


    @FXML
    private Button btn_prBill;

    @FXML
    private Label lb_billCode;

    @FXML
    private Label lb_customerName;

    @FXML
    private Label lb_discount;

    @FXML
    private Label lb_pay;

    @FXML
    private Label lb_purchaseDate;

    @FXML
    private Label lb_staffName;

    @FXML
    private Label lb_totalRevenue;

    @FXML
    private AnchorPane pane_DetailBill;

    @FXML
    private AnchorPane pane_bill;

    @FXML
    private TableColumn<?, ?> tc_ProductList;

    @FXML
    private TableColumn<?, ?> tc_STT;

    @FXML
    private TableColumn<?, ?> tc_StaffName;

    @FXML
    private TableColumn<?, ?> tc_billID;

    @FXML
    private TableColumn<?, ?> tc_billNumber;

    @FXML
    private TableColumn<?, ?> tc_createDate;

    @FXML
    private TableColumn<?, ?> tc_customerName;

    @FXML
    private TableColumn<?, ?> tc_productName;

    @FXML
    private TableColumn<?, ?> tc_productQuantity;

    @FXML
    private TableColumn<?, ?> tc_productRevenue;

    @FXML
    private TableColumn<?, ?> tc_revenue;

    @FXML
    private TableView<Product> tv_productList;

    @FXML
    private TableView<Bill> tv_showBill;
    @FXML
    private TableColumn<?,?>tc_productPrice;

    @FXML
    private ChoiceBox choiceBox_sort;
    @FXML
    private TextField txt_search;
    private ObservableList<Bill> billALLList;
    DecimalFormat formattera = new DecimalFormat("#,###");
    private ObservableList<String> listKetSearch;
    private Bill selectedBill;
    public Bill getSelectedBill() {
        return selectedBill;
    }

    public void setSelectedBill(Bill selectedBill) {
        this.selectedBill = selectedBill;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listKetSearch = FXCollections.observableArrayList("Tên khách hàng" , "Tên nhân viên", "Mã hóa đơn");
        choiceBox_sort.setItems(listKetSearch);
        choiceBox_sort.setValue("Tên khách hàng");
        search();
        showData();
        setActionOnProductList();
        btn_prBill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                selectedBill = tv_showBill.getSelectionModel().getSelectedItem();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/detail_bill.fxml"));
                DetailBillController controller = new DetailBillController(selectedBill);
                fxmlLoader.setController(controller);
                Stage stage = new Stage();
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 583, 838);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Detail Bill");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();


                //tạo Pdf
                File imageFile = new File("temp_image.png");

                try {
                    // Render the scene to an image
                    WritableImage image = scene.snapshot(null);
                    java.awt.image.BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image,null);
                    ImageIO.write(bufferedImage,"png",imageFile);

                    // Create a new PDF document
                    PDDocument document = new PDDocument();
                    PDPage page = new PDPage(new PDRectangle(583, 838));
                    document.addPage(page);

                    // Create a content stream for the page
                    PDPageContentStream contentStream = new PDPageContentStream(document, page);

                    // Load the image from the file and draw it on the page
                    BufferedImage awtImage = ImageIO.read(imageFile);
                    contentStream.drawImage(
                            org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory.createFromImage(document, awtImage),
                            (float) 0, (float) 0, (float) image.getWidth(), (float) image.getHeight()
                    );

                    contentStream.close();
                    document.save("DetailBill.pdf");
                    document.close();

                    // Delete the temporary image file
                    imageFile.delete();
                } catch ( IOException e) {
                    e.printStackTrace();
                }
            }
        });





    }
    private void showData(){
        tc_STT.setCellValueFactory(new PropertyValueFactory<>("sequence"));
        tc_billNumber.setCellValueFactory(new PropertyValueFactory<>("billCode"));
        tc_createDate.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        tc_revenue.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        tc_billID.setCellValueFactory(new PropertyValueFactory<>("billID"));
        tc_StaffName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        tc_customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        tc_ProductList.setCellValueFactory(new PropertyValueFactory<>("productList"));
        billALLList =tv_showBill.getItems();
        billALLList=FXCollections.observableArrayList(new BillDao().selectALL1());
        tv_showBill.setItems(billALLList);
    }
    private void setActionOnProductList(){
        tv_showBill.setOnMouseClicked(mouseEvent -> {
            clearBill();
            showDetailBill();
        });
        tv_showBill.setOnKeyPressed(keyPressed ->{
            clearBill();
            showDetailBill();
        });
    }
    public void search(){

        txt_search.setOnKeyReleased(keyEvent ->  {

            // Khởi tạo FilteredList và gán nó với danh sách positionListz
            FilteredList<Bill> filteredList = new FilteredList<>(billALLList, p -> true);
            tv_showBill.setItems(filteredList);
            // Gán FilteredList làm nguồn dữ liệu cho TableView
            filteredList.setPredicate(p -> {
                if (txt_search.getText().isEmpty()) {
                    return true;
                }
                if (choiceBox_sort.getValue().equals("Tên khách hàng")) {
                    return p.getCustomerName().toLowerCase().contains(txt_search.getText().toLowerCase());
                }
                if (choiceBox_sort.getValue().equals("Tên nhân viên")) {
                    return p.getStaffName().toLowerCase().contains(txt_search.getText().toLowerCase());

                }

                return p.getBillCode().toLowerCase().contains(txt_search.getText().toLowerCase());

            });
            if(tv_showBill.getSelectionModel() != null) {
                tv_showBill.getSelectionModel().selectFirst();
            }
            });


    }
    private void showDetailBill(){
        tc_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tc_productQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tc_productPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        tc_productRevenue.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        Bill bill = tv_showBill.getSelectionModel().getSelectedItem();
        ObservableList<Product> productList = tv_productList.getItems();
        lb_billCode.setText(bill.getBillCode());
        lb_purchaseDate.setText(String.valueOf(bill.getPurchaseDate()));
        lb_staffName.setText(bill.getStaffName());
        lb_customerName.setText(bill.getCustomerName());
        lb_discount.setText("0%");
        lb_totalRevenue.setText(bill.getRevenue());
        lb_pay.setText(String.valueOf(bill.getRevenue()));
        productList = FXCollections.observableArrayList(bill.getProductList());
        tv_productList.setItems(productList);
    }
    private void clearBill(){
        lb_billCode.setText("");
        lb_purchaseDate.setText("");
        lb_staffName.setText("");
        lb_customerName.setText("");
        tv_productList.getItems().clear();
        tc_productName.setCellValueFactory(new PropertyValueFactory<>(""));
        tc_productQuantity.setCellValueFactory(new PropertyValueFactory<>(""));
        tc_productRevenue.setCellValueFactory(new PropertyValueFactory<>(""));
    }




}
