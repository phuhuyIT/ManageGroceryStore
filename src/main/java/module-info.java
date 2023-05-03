module com.example.btl_demo {
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

    opens Controller to javafx.fxml;
    exports Controller;
}