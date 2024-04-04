module salt.frontend {
    requires javafx.controls;
    requires javafx.fxml;

    opens salt.frontend to javafx.fxml;
    exports salt.frontend;
}
