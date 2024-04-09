package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import library.App;

public class CourseController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Course");
    }
}