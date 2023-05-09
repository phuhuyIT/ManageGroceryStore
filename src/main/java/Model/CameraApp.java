package Model;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.AlertAndVerifyController;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.oned.Code128Writer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.bytedeco.javacv.*;
import org.bytedeco.javacv.Frame;


public class CameraApp extends Thread{
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
    @Override
    public void run() {

        isRunning.set(true);
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(1); // truy cập camera laptop
        try {
            grabber.start();

        CanvasFrame canvasFrame = new CanvasFrame("Barcode Scanner");
        //canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    isRunning.set(false);
                    canvasFrame.dispose();
                    try {
                        grabber.release();
                        interrupt();
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
                Result finalResult = result;
                tf_addProductUPC.setText(finalResult.getText());
                result=null;
            }
            if (result != null ) {
                isNotHasBarCode=false;
                barCode= result.getText();
                Result finalResult = result;
                Platform.runLater(() -> {

                    String[] parts =splitString(finalResult.getText());
                    txt_fullNameCustomer.setText(parts[1]);
                    txt_IndentifierCustomer.setText(parts[0]);
                    cb_customerGender.setValue(parts[3]);
                    dp_customerBirthdate.setValue(LocalDate.parse(parts[2]));
                    txt_locationCustomer.setText(parts[4]);
                });
                Thread.sleep(3000);
                System.out.println("Barcode: " + finalResult.getText());
            }
            canvasFrame.showImage(frame);

        }
        } catch (FrameGrabber.Exception e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
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

