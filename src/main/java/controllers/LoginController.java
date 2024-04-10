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

public class LoginController implements Initializable {

    private GradeSystemFACADE facade;
    private UserList userList;
    private User currentUser;
    private CourseList courseList;
    private MajorList majorList;
    
    @FXML
    private TextField txt_username;
    
    @FXML
    private TextField txt_password;
    
    @FXML
    private Button advisorLoginButton;
    
    @FXML
    private Button createAccountButton;
    
    @FXML
    private Button studentLoginButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.userList = UserList.getInstance();
        this.courseList = CourseList.getInstance();
        this.majorList = MajorList.getInstance();
        this.facade = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);
    }
    
    @FXML
    void switchToAdvisorView(ActionEvent event) {
        try {
            App.setRoot("advisorView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void switchToStudentView(ActionEvent event) {
        try {
            App.setRoot("studentView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void switchToCreateAnAccountView(ActionEvent event) {
        try {
            App.setRoot("signUp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void studentLogin(ActionEvent event) {
        String username = txt_username.getText();
        String password = txt_password.getText();
        
        if(facade.login(username, password)) {
            currentUser = facade.getUser();
            if (currentUser instanceof Student) {
                switchToStudentView(event);
            } else {
                System.out.println("The user is not a student.");
            }
        } else {
            System.out.println("Login failed.");
        }
    }
    
    @FXML
    void advisorLogin(ActionEvent event) {
        String username = txt_username.getText();
        String password = txt_password.getText();
        
        if(facade.login(username, password)) {
            currentUser = facade.getUser();
            if (currentUser instanceof Advisor) {
                switchToAdvisorView(event);
            } else {
                System.out.println("The user is not an advisor.");
            }
        } else {
            System.out.println("Login failed.");
        }
    }
    
}
