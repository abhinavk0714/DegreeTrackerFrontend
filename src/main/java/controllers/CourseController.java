package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private Button backButton;

    @FXML
    private Label error;

    @FXML
    private TableView<Course> courseTable;

    @FXML
    private Label lbl_coreq;

    @FXML
    private Label lbl_description;

    @FXML
    private Label lbl_prereq;

    @FXML
    private Label lbl_availability;

    @FXML
    private Label lbl_courseName;

    @FXML
    private Label lbl_courseNumber;

    @FXML
    private Label lbl_creditHours;

    @FXML
    private Label lbl_department;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Course");
    }

    @FXML
    void switchToStudentView(ActionEvent event) {
        try {
            App.setRoot("studentView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.userList = UserList.getInstance();
        this.courseList = CourseList.getInstance();
        this.majorList = MajorList.getInstance();
        this.facade = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);
        error.setText("Enter Course Details");
    }
    @FXML
    void courseSearch(ActionEvent event) {
        String department = txt_department.getText();
        String number = txt_courseNumber.getText();

        if(facade.validCourse(department, number)){
            course = facade.findCourse(department, number);
            if(course instanceof Course){
                lbl_courseName.setText(course.getName());
                lbl_courseNumber.setText(course.getNumber());
                lbl_availability.setText("Availability: " + course.getAvailablity());
                lbl_prereq.setText("Prerequesites: " + facade.formatPrerequisites(course.getPrerequisite()));
                lbl_coreq.setText("Corequesites: " + facade.formatCorequisites(course.getCorequisite()));
                lbl_creditHours.setText("Credit Hours: " + course.getCreditHours());
                lbl_department.setText(course.getDepartment());
                lbl_description.setText(course.getDescription());
                error.setText("");
                
            }
            
        } else {
            error.setText("Invalid Course");
        }
    }
}
