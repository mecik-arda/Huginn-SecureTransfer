module huginn.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires huginn.client;
    requires huginn.core;

    opens com.ardamecik.huginn.ui to javafx.graphics, javafx.fxml;
    exports com.ardamecik.huginn.ui;
}