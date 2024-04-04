module salt.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens salt.frontend to javafx.fxml;
    exports salt.frontend;
}
