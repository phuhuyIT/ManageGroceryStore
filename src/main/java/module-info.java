module com.example.btl_demo {
    exports Model;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;
    requires com.google.zxing;
    requires com.google.protobuf;
    requires com.google.zxing.javase;
    requires javafx.media;
    requires org.bytedeco.javacpp;
    requires org.bytedeco.javacv;
    requires org.bytedeco.opencv;
    requires java.mail;
    requires itextpdf;
    requires javafx.swing;
    requires pdfbox;
    requires webcam.capture;
    opens Controller to javafx.fxml;
    exports Controller;
    opens Model to javafx.fxml;
    exports Oauth2;
    opens Oauth2 to javafx.fxml;
}