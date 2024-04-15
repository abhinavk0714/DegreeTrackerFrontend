package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library.App;

public class AdvisorController {

    @FXML
    private Button backButton;

    @FXML
    private Button studentSearchButton;

    @FXML
    private TextField studentSearchText;

    @FXML
    void backToLogin(ActionEvent event) {
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
