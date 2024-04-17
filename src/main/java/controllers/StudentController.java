package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import library.App;
import model.*;

public class StudentController {

    private GradeSystemFACADE facade;
    private UserList userList;
    private User currentUser;
    private CourseList courseList;
    private MajorList majorList;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button courseSearchButton;

    @FXML
    private TextField courseSearchText;

    @FXML
    private TitledPane semester1;

    @FXML
    private AnchorPane semester1courses;

    @FXML
    private TitledPane semester2;

    @FXML
    private AnchorPane semester2courses;

    @FXML
    private TitledPane semester3;

    @FXML
    private AnchorPane semester3courses;

    @FXML
    private TitledPane semester4;

    @FXML
    private AnchorPane semester4courses;

    @FXML
    private TitledPane semester5;

    @FXML
    private AnchorPane semester5courses;

    @FXML
    private TitledPane semester6;

    @FXML
    private AnchorPane semester6courses;

    @FXML
    private TitledPane semester7;

    @FXML
    private AnchorPane semester7courses;

    @FXML
    private TitledPane semester8;

    @FXML
    private AnchorPane semester8courses;

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
        this.currentUser = facade.getUser();
    }
    
}
