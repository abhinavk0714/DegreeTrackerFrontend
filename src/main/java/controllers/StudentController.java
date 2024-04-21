package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import library.App;
import model.*;

public class StudentController {
    
    private GradeSystemFACADE facade;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;
    private Student student;
    
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    
    @FXML
    private Button LOButton;
    
    @FXML
    private ProgressBar degreeProgressBar;
    
    @FXML
    private Button courseSearchButton;
    
    @FXML
    private TextField courseSearchText;
    
    @FXML
    private Label studentAdvisorLabel;
    
    @FXML
    private Label studentClassificationLabel;
    
    @FXML
    private Label studentFlagsLabel;
    
    @FXML
    private Label studentGPALabel;
    
    @FXML
    private Label studentIDLabel;
    
    @FXML
    private Label studentMajorLabel;
    
    @FXML
    private Label studentNameLabel;
    
    @FXML
    private Text eightSemesterPlanText;
    
    @FXML
    private Text completedCoursesText;
    
    @FXML
    void switchToCourseView(ActionEvent event) {
        try {
            App.setRoot("Course");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void switchToLogin(ActionEvent event) {
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void initialize() {
        this.userList = UserList.getInstance();
        this.courseList = CourseList.getInstance();
        this.majorList = MajorList.getInstance();
        this.facade = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);
        this.student = facade.findStudent("BWest");
        studentAdvisorLabel.setText("Advisor: " + student.getAdvisor().getFirstName() + " " + student.getAdvisor().getLastName());
        studentClassificationLabel.setText("Classification: " + student.getClassification());
        studentFlagsLabel.setText("Flags: " + student.getFlag());
        studentGPALabel.setText("GPA: " + student.getOverallGPA());
        studentIDLabel.setText("ID: " + student.getUUID());
        studentMajorLabel.setText("Major: Computer Science");
        studentNameLabel.setText("Name: " + student.getFirstName() + " " + student.getLastName());
        
        displayEightSemesterPlan();
        displayCompletedCourses();
    }
    
    private void displayEightSemesterPlan() {
        EightSemesterPlan eightSemesterPlan = student.getEightSemesterPlan();
        if (eightSemesterPlan != null) {
            eightSemesterPlanText.setText(eightSemesterPlan.toString());
        } else {
            eightSemesterPlanText.setText("No eight-semester plan available.");
        }
    }
    
    private void displayCompletedCourses() {
        ArrayList<CompletedCourse> completedCourses = student.getCompletedCourses();
        StringBuilder completedCoursesString = new StringBuilder();
        completedCoursesString.append("Completed Courses:\n");
        for (CompletedCourse completedCourse : completedCourses) {
            completedCoursesString.append(completedCourse.toString()).append("\n");
        }
        completedCoursesText.setText(completedCoursesString.toString());
    }
    
}
