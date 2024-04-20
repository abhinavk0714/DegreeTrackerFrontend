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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import library.App;
import model.*;

public class AdvisorController implements Initializable {
   
    private GradeSystemFACADE facade;
    private UserList userList;
    private User currentUser;
    private CourseList courseList;
    private MajorList majorList;
    
    @FXML
    private Button LOButton;
    
    @FXML
    private Button studentSearchButton;
    
    @FXML
    private TextField studentSearchText;

    @FXML
    private Text studentSearchMessage;
    
    @FXML
    private Label welcomeUserLabel;

    @FXML
    private ImageView braxWestImage;

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

    // For the student search button
    @FXML
    void switchToStudentView(ActionEvent event) {
        try {
            App.setRoot("studentView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // For clicking on the image
    @FXML
    void switchToStudentViewFromImage(MouseEvent event) {
        try {
            App.setRoot("studentView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void searchForStudent(ActionEvent event) {
        String searchedStudent = studentSearchText.getText();
        Student tempStudent;
    
        // Split the searchedStudent string into first name and last name
        String[] names = searchedStudent.split(" ");
        if (names.length >= 2) {
            String firstName = names[0];
            String lastName = names[1];
    
            // Using the first and last names to find the student
            tempStudent = facade.findStudentbyName(firstName, lastName);
    
            if (tempStudent != null) {
                // Student found, you can handle the student object here
                System.out.println("Student found: " + tempStudent.toString());
            } else {
                System.out.println("This is not a valid student");
            }
        } else {
            System.out.println("Please enter both a first and a last name");
        }
    }
    
}

