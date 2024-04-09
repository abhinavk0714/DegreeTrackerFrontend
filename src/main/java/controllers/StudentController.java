package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.*;

public class StudentController implements Initializable{

    @FXML private Label screen_title;
    private GradeSystemFACADE facade;
    private User user;
    private UserList userList;
    private User currentUser;
    private CourseList courseList;
    private MajorList majorList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GradeSystemFACADE facade = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);
        User user = currentUser;
        
        screen_title.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
        
        getUserItems();
        getEightSemesterPlan();
    }

    private void getUserItems()
    {
        VBox vbox = new VBox();
        Student currStudent = facade.findStudent(user.getUsername());
        Label studentID = new Label(currStudent.getUUID().toString());
        Label classifaction = new Label(currStudent.getClassification().toString());
        Label major = new Label(currStudent.getMajor().getMajorName());
        //Label appArea = new Label(); not sure how to do this one
        Label advisor = new Label(currStudent.getAdvisor().getFirstName() + " " + currStudent.getAdvisor().getLastName());
        Label gpa= new Label(String.valueOf(currStudent.getOverallGPA()));
        Label flag = new Label(currStudent.getFlag().toString());
        //Label currentSemester = new Label()
        Label FERPA = new Label(currStudent.getFEPRA().toString());


    }

    private void getEightSemesterPlan()
    {
        EightSemesterPlan courses = facade.findStudent(user.getUsername()).getEightSemesterPlan();

    }
   
}