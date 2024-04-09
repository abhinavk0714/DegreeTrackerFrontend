package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import library.App;

public class StudentController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("Student");
    }
}