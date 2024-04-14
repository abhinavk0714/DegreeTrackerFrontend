package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import library.App;
import model.Availablity;

public class CourseController implements Initializable{
    private UUID id;
    private String name;
    private String department;
    private String number;
    private String description;
    private long creditHours;
    private ArrayList<Availablity> availablity;
    private HashMap<UUID, String> prerequisite;
    private ArrayList<UUID> corequisite;

    @FXML
    private TextField txt_department;
    
    @FXML
    private TextField txt_courseNumber;
   
    @FXML
    private Button searchButton;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Course");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}