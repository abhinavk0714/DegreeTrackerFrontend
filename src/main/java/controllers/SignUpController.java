package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import library.App;

public class SignUpController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Sign up");
    }
}