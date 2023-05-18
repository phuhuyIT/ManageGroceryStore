package Model;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import DAO.ProductDAO;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.oned.Code128Writer;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.bytedeco.javacv.*;
import org.bytedeco.javacv.Frame;


public class CameraApp {
    private  String barCode;
    private TextField tf_addProductUPC;
    private TextField txt_fullNameCustomer;
    private TextField txt_IndentifierCustomer;
    private ChoiceBox cb_customerGender;
    private  DatePicker dp_customerBirthdate;
    private TextField txt_locationCustomer;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public String getBarcode() {
        return barCode;
    }
    public void run1(VBox vb_productList, Label lb_totalCost,TextField txt_search) {

        isRunning.set(true);
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(1); // truy cập camera laptop
        try {
            grabber.start();

            CanvasFrame canvasFrame = new CanvasFrame("Barcode Scanner");
            canvasFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    isRunning.set(false);
                    canvasFrame.dispose();
                    try {
                        grabber.release();
                    } catch (FrameGrabber.Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            Result result = null;
            Boolean isHasbarcode=false;
            while (true) {
                Frame frame = grabber.grab();
                BufferedImage image = convertFrameToImage(frame);
                result = scanBarcode(image);
                if (result != null ) {
                    isHasbarcode=true;
                    barCode= result.getText();
                    ResultSet rs =new ProductDAO().getProductBySKU(barCode);
                    Platform.runLater(() -> {
                        txt_search.setText(barCode);
                        try {
                            if(rs.next()){
                                HBox hbox = new HBox();
                                Label nameLabel = new Label(rs.getString("productName"));
                                nameLabel.setPrefWidth(229);
                                nameLabel.setPrefHeight(38);

                                // Thiết lập kích thước chữ của Label
                                nameLabel.setStyle("-fx-font-size: 18;");

                                // Thiết lập vị trí chữ của Label là trung tâm
                                nameLabel.setAlignment(Pos.CENTER);
                                // Tạo label cho giá cả
                                Label priceLabel = new Label(String.valueOf(rs.getDouble("sellingPrice")));
                                priceLabel.setId("priceLabel");
                                priceLabel.setPrefWidth(91);
                                priceLabel.setPrefHeight(38);

                                // Thiết lập kích thước chữ của Label
                                priceLabel.setStyle("-fx-font-size: 18;");

                                // Thiết lập vị trí chữ của Label là trung tâm
                                priceLabel.setAlignment(Pos.CENTER);

                                // Tạo textField cho số lượng
                                TextField quantityTextField = new TextField();
                                quantityTextField.setId("quantityTextField");
                                quantityTextField.setPrefWidth(101);
                                quantityTextField.setPrefHeight(38);
                                quantityTextField.setStyle("-fx-font-size: 18;");
                                quantityTextField.setAlignment(Pos.CENTER);
                                javafx.scene.control.Button btnDelete = new Button();
                                btnDelete.setId("btn_deleteCaculator");
                                btnDelete.setPrefWidth(52);
                                btnDelete.setPrefHeight(38);
                                btnDelete.setStyle("-fx-font-size: 12;");
                                btnDelete.setAlignment(Pos.CENTER);
                                btnDelete.setText("Delete");
                                hbox.setOnMouseClicked(event -> {

                                });
                                hbox.getChildren().addAll(btnDelete,nameLabel, priceLabel, quantityTextField);
                                vb_productList.getChildren().add(hbox);
                                btnDelete.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        // Lấy danh sách các node con trong VBox
                                        ObservableList<Node> children = vb_productList.getChildren();

                                        // Lấy chỉ mục của HBox trong danh sách
                                        int index = children.indexOf(hbox);
                                        if (index >= 0 && index < vb_productList.getChildren().size()) {
                                            // Xóa HBox khỏi danh sách
                                            HBox productHBox = (HBox) vb_productList.getChildren().get(index);

                                            double totalCost= Double.parseDouble(lb_totalCost.getText());
                                            Label lookupPrice = (Label) productHBox.lookup("#priceLabel");
                                            TextField lookupQuantity = (TextField) productHBox.lookup("#quantityTextField");
                                            totalCost-=Double.parseDouble(lookupPrice.getText())*Integer.parseInt(lookupQuantity.getText());
                                            lb_totalCost.setText(String.valueOf(totalCost));
                                            vb_productList.getChildren().remove(productHBox);
                                        }
                                    }
                                });
                                quantityTextField.setOnKeyReleased(keyEvent ->  {
                                    double totalCost = 0;
                                    int i=0;
                                    for (Node node : vb_productList.getChildren()) {
                                        if (node instanceof HBox) {
                                            HBox hboxa = (HBox) node;
                                            Label lookupPrice = (Label) hboxa.lookup("#priceLabel");
                                            TextField lookupQuantity = (TextField) hboxa.lookup("#quantityTextField");
                                            double sellingPrice = Double.parseDouble(lookupPrice.getText());
                                            int quantityInHBox = Integer.parseInt(lookupQuantity.getText());
                                            System.out.println("quantity: "+i+" "+quantityInHBox);

                                            totalCost += sellingPrice * quantityInHBox;
                                            i++;
                                        }
                                    }
                                    System.out.println(totalCost);
                                    lb_totalCost.setText(String.valueOf(totalCost));
                                });
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }


                    });
                }
                canvasFrame.showImage(frame);
                if(isHasbarcode)
                    Thread.sleep(1500);
            }
        } catch (FrameGrabber.Exception e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {

        isRunning.set(true);
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(1); // truy cập camera laptop
        try {
            grabber.start();

        CanvasFrame canvasFrame = new CanvasFrame("Barcode Scanner");
        canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    isRunning.set(false);
                    canvasFrame.dispose();
                    try {
                        grabber.release();
                    } catch (FrameGrabber.Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        Result result = null;
        boolean isNotHasBarCode=true;
        while (isNotHasBarCode) {
            Frame frame = grabber.grab();
            BufferedImage image = convertFrameToImage(frame);
            result = scanBarcode(image);
            if(result!=null && tf_addProductUPC !=null){
                isNotHasBarCode=false;
                Result finalResult = result;
                tf_addProductUPC.setText(finalResult.getText());
                result=null;
            }
            if (result != null&&txt_IndentifierCustomer!=null ) {
                isNotHasBarCode=false;
                barCode= result.getText();
                Result finalResult = result;
                Platform.runLater(() -> {
                    String[] parts =splitString(finalResult.getText());
                    txt_IndentifierCustomer.setText(parts[0]);
                    txt_fullNameCustomer.setText(parts[1]);
                    cb_customerGender.setValue(parts[3]);
                    dp_customerBirthdate.setValue(LocalDate.parse(parts[2]));
                    txt_locationCustomer.setText(parts[4]);
                });
            }
            canvasFrame.showImage(frame);
        }
            grabber.release();
            grabber.release();
            canvasFrame.dispose();
        } catch (FrameGrabber.Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void addWindowListener(WindowAdapter windowAdapter) {
    }

    private static BufferedImage convertFrameToImage(Frame frame) {
        Java2DFrameConverter converter = new Java2DFrameConverter();
        return converter.getBufferedImage(frame);
    }

    private static Result scanBarcode(BufferedImage image) {
        try {
            MultiFormatReader reader = new MultiFormatReader();
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = reader.decode(bitmap);
            return result;
        } catch (NotFoundException e) {
            return null;
        } catch (ReaderException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String skuGenerate(String barcodeData, String fileName) throws WriterException, IOException {
        // Tạo mã vạch dưới dạng hình ảnh
        Code128Writer barcodeWriter = new Code128Writer();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeData, BarcodeFormat.CODE_128, 300, 150, hints);

        // Tạo hình ảnh mới chứa mã vạch và nội dung
        BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // Tạo hình ảnh mới chứa cả mã vạch và nội dung
        BufferedImage combined = new BufferedImage(400, 200, BufferedImage.TYPE_INT_RGB);

        // Vẽ mã vạch và nội dung lên hình ảnh mới
        Graphics2D g2d = (Graphics2D) combined.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 400, 200);
        g2d.drawImage(barcodeImage, 50, 10, null);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));

        // Tính toán vị trí của nội dung
        int stringWidth = g2d.getFontMetrics().stringWidth(barcodeData);
        int xCoordinate = (combined.getWidth() - stringWidth) / 2;
        int yCoordinate = 170;
        g2d.drawString(barcodeData, xCoordinate, yCoordinate);

        // Lưu hình ảnh dưới dạng tập tin PNG
        String filePath = "src/main/java/BarcodeImage/"+fileName;
        File outputFile = new File(filePath);
        ImageIO.write(combined, "PNG", outputFile);
        return filePath;
    }


    public void setTextField(TextField tf_addProductUPC) {
        this.tf_addProductUPC=tf_addProductUPC;
    }
    public void setTextFieldForCustomer(TextField txt_fullNameCustomer, TextField txt_IndentifierCustomer, ChoiceBox cb_customerGender,
                                        DatePicker dp_customerBirthdate, TextField txt_locationCustomer){
        this.txt_fullNameCustomer = txt_fullNameCustomer;
        this.txt_IndentifierCustomer = txt_IndentifierCustomer;
        this.cb_customerGender = cb_customerGender;
        this.dp_customerBirthdate =dp_customerBirthdate;
        this.txt_locationCustomer = txt_locationCustomer;
    }

    private String[] splitString(String customerInfo){

        String[] parts = customerInfo.split("\\|");
        String citizenIDNumber = parts[0].replaceAll("I", "");
        String fullname = parts[2].replaceAll("I", "");
        String birthdate = parts[3].replaceAll("I", "");
        //định dạng lại chuỗi birthdate
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(birthdate, inputFormatter);
            birthdate = date.toString();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        String gender = parts[4].replaceAll("I", "");
        String location = parts[5].replaceAll("I", "");
        String[] result = {citizenIDNumber, fullname, birthdate, gender, location};
        return result;
    }
}

