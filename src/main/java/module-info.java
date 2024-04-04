module salt.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens library.main to javafx.fxml;
    exports library.main;
}
