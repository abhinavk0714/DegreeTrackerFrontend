module salt.frontend {
    requires javafx.controls;
    requires javafx.fxml;

    opens library.main to javafx.fxml;
    exports library.main;
}
