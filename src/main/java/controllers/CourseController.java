package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import library.App;
import model.CourseList;
import model.GradeSystemFACADE;
import model.MajorList;
import model.Student;
import model.UserList;

public class CourseController implements Initializable{
    private static GradeSystemFACADE facade;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;

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
        this.userList = UserList.getInstance();
        this.courseList = CourseList.getInstance();
        this.majorList = MajorList.getInstance();
        this.facade = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);
    }
    @FXML
    void courseSearch(ActionEvent event) {
        String department = txt_department.getText();
        String number = txt_courseNumber.getText();
        
       
    }
}