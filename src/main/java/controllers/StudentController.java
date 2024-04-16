package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'studentView.fxml'.";
        assert courseSearchButton != null : "fx:id=\"courseSearchButton\" was not injected: check your FXML file 'studentView.fxml'.";
        assert courseSearchText != null : "fx:id=\"courseSearchText\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester1 != null : "fx:id=\"semester1\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester1courses != null : "fx:id=\"semester1courses\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester2 != null : "fx:id=\"semester2\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester2courses != null : "fx:id=\"semester2courses\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester3 != null : "fx:id=\"semester3\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester3courses != null : "fx:id=\"semester3courses\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester4 != null : "fx:id=\"semester4\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester4courses != null : "fx:id=\"semester4courses\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester5 != null : "fx:id=\"semester5\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester5courses != null : "fx:id=\"semester5courses\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester6 != null : "fx:id=\"semester6\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester6courses != null : "fx:id=\"semester6courses\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester7 != null : "fx:id=\"semester7\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester7courses != null : "fx:id=\"semester7courses\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester8 != null : "fx:id=\"semester8\" was not injected: check your FXML file 'studentView.fxml'.";
        assert semester8courses != null : "fx:id=\"semester8courses\" was not injected: check your FXML file 'studentView.fxml'.";

    }

}
