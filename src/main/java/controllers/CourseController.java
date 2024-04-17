package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import library.App;
import model.CourseList;
import model.GradeSystemFACADE;
import model.MajorList;
import model.UserList;
import model.Course;

public class CourseController implements Initializable{
    private GradeSystemFACADE facade;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;
    private Course course;

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
        
       if(facade.validCourse(department,number)){
        course = facade.findCourse(department, number);
        if(course instanceof Course){
            course.viewCourseDetails();
        }
        else{
            System.out.println("Invalid Course");
        }
       }
       else{
        System.out.println("Invalid Course");
       }
    }
}