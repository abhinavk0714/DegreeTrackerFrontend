package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import library.App;
import model.*;

public class AdvisorController implements Initializable {
   
    private GradeSystemFACADE facade;
    private UserList userList;
    private User currentUser;
    private CourseList courseList;
    private MajorList majorList;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button studentSearchButton;
    
    @FXML
    private TextField studentSearchText;
    
    @FXML
    private Label welcomeUserLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.userList = UserList.getInstance();
        this.courseList = CourseList.getInstance();
        this.majorList = MajorList.getInstance();
        this.facade = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);

        welcomeUserLabel.setText("Welcome, " + facade.getUser().getFirstName() + " " + facade.getUser().getLastName() + "!");
    }
    
    @FXML
    void backToLogin(ActionEvent event) {
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchForStudent(ActionEvent event){
        String student = studentSearchText.getText();
        Student searchedStudent;
        
        if(facade.findStudent(student) != null){
            searchedStudent = facade.findStudent(student);

        } else {
            System.out.println("This is not a valid student");
        }
        
    }
}

