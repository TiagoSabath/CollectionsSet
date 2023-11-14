module com.example.collectionsset {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.collectionsset to javafx.fxml;
    exports com.example.collectionsset;
}