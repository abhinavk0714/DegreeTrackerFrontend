module salt.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires javafx.graphics;

    opens library to javafx.fxml;
    exports library;
    opens controllers to javafx.fxml;
    exports controllers;
    opens model to javafx.fxml;
    exports model;
}
