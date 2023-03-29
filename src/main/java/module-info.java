module com.example.btl_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.btl_demo to javafx.fxml;
    exports com.example.btl_demo;
}