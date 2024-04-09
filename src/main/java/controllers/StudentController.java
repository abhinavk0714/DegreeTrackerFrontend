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
    private UserList userList;
    private User currentUser;
    private CourseList courseList;
    private MajorList majorList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GradeSystemFACADE facade = GradeSystemFACADE.getFacadeInstance(userList, courseList,majorList);
        User user = currentUser;
        
        screen_title.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
        
        getUserItems();
    }

    private void getUserItems()
    {
        VBox vbox = new VBox();
        

    }
   
}