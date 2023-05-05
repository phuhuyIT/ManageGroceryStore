package Model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import org.bytedeco.javacv.*;

public class CameraApp {
    public static String scan() throws Exception {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(1); // truy cập camera laptop
        grabber.start();
        CanvasFrame canvasFrame = new CanvasFrame("Barcode Scanner");
        canvasFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Result result = null;
        boolean isNotHasBarCode=true;
        while (isNotHasBarCode) {
            Frame frame = grabber.grab();
            BufferedImage image = convertFrameToImage(frame);
            result = scanBarcode(image);
            if (result != null) {
                System.out.println("Barcode: " + result.getText());
                isNotHasBarCode=false;
                canvasFrame.dispose();
            }
            canvasFrame.showImage(frame);
        }
        return result.getText();
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
}

