package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
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
    private TableView<Course> semester1Table;

    @FXML
    private TableView<Course> semester2Table;

    @FXML
    private TableView<Course> semester3Table;

    @FXML
    private TableView<Course> semester4Table;

    @FXML
    private TableView<Course> semester5Table;

    @FXML
    private TableView<Course> semester6Table;

    @FXML
    private TableView<Course> semester7Table;

    @FXML
    private TableView<Course> semester8Table;

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
        this.student = facade.findStudent("HTawnie");
        EightSemesterPlan eightSemesterPlan = student.getEightSemesterPlan();
        if (eightSemesterPlan != null) {
            populateSemesterTable(semester1Table, eightSemesterPlan.getSemesters().get(0));
            populateSemesterTable(semester2Table, eightSemesterPlan.getSemesters().get(1));
            populateSemesterTable(semester3Table, eightSemesterPlan.getSemesters().get(2));
            populateSemesterTable(semester4Table, eightSemesterPlan.getSemesters().get(3));
            populateSemesterTable(semester5Table, eightSemesterPlan.getSemesters().get(4));
            populateSemesterTable(semester6Table, eightSemesterPlan.getSemesters().get(5));
            populateSemesterTable(semester7Table, eightSemesterPlan.getSemesters().get(6));
            populateSemesterTable(semester8Table, eightSemesterPlan.getSemesters().get(7));

        }
    }

    private void populateSemesterTable(TableView<Course> table, ArrayList<Course> courses) {
        TableView<Course> tableView = new TableView<>();

        TableColumn<Course, String> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDepartment()));

        TableColumn<Course, String> numberColumn = new TableColumn<>("Number");
        departmentColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumber()));

        TableColumn<Course, String> nameColumn = new TableColumn<>("Name");
        departmentColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Course, Long> creditHoursColumn = new TableColumn<>("Credit Hours");
        creditHoursColumn.setCellValueFactory(data -> new SimpleLongProperty(data.getValue().getCreditHours()).asObject());

        TableColumn<Course, String> descriptionColumn = new TableColumn<>("Description");
        departmentColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescription()));

        tableView.getColumns().addAll(departmentColumn, numberColumn, nameColumn, creditHoursColumn, descriptionColumn);
        table.getItems().addAll(courses);
    }

}
