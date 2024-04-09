package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import library.App;

public class AdvisorController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("AdvisorView");
    }
}