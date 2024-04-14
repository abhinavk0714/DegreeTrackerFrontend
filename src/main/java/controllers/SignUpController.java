package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library.App;
import model.*;

public class SignUpController implements Initializable {

    private GradeSystemFACADE facade;
    private UserList userList;
   // private User currentUser;
    private CourseList courseList;
    private MajorList majorList;

    
    @FXML
    private TextField txt_firstname;
    
    @FXML
    private TextField txt_lastname;
    
    @FXML
    private TextField txt_username;
    
    @FXML
    private TextField txt_password;

    @FXML
    private Button registerButton;


    public void initialize(URL url, ResourceBundle rb) {
        this.userList = UserList.getInstance();
        this.courseList = CourseList.getInstance();
        this.majorList = MajorList.getInstance();
        this.facade = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);
    }

    @FXML
    void studentRegister(ActionEvent event) {
        String firstName = txt_firstname.getText();
        String lastName = txt_lastname.getText();
        String username = txt_username.getText();
        String password = txt_password.getText();

        facade.newStudentUser(firstName, lastName, username, password);
        switchToLogInScreen(event);
    }

    @FXML 
    void advisorRegister(ActionEvent event)
    {
        String firstName = txt_firstname.getText();
        String lastName = txt_lastname.getText();
        String username = txt_username.getText();
        String password = txt_password.getText();
        facade.newAdvisorUser(firstName, lastName, username, password);
        switchToLogInScreen(event);
    }

    @FXML
    private void switchToLogInScreen(ActionEvent event){
        try {
            App.setRoot("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}