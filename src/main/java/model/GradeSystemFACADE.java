package model;

//import java.util.ArrayList;
import java.util.UUID;
public class GradeSystemFACADE {
    
    private static GradeSystemFACADE facade;
    private UserList userList;
    private User currentUser;
    private CourseList courseList;
    private MajorList majorList;
    
    
    private GradeSystemFACADE(UserList userList, CourseList courseList, MajorList majorList) {
        this.userList = userList;
        this.courseList = courseList;
        this.majorList = majorList;
        this.currentUser = null;
    }
    
    public static GradeSystemFACADE getFacadeInstance(UserList userList, CourseList courseList, MajorList majorList) {
        if (facade == null) {
            facade = new GradeSystemFACADE(userList, courseList, majorList);
        }
        return facade;
    }
    
    public User getUser()
    {
        return this.currentUser;
    }
    
    public void setUserList(UserList userList) {
        this.userList = userList;
    }
    
    public void setCourseList(CourseList courseList) {
        this.courseList = courseList;
    }
    
    public void setMajorList(MajorList majorList) {
        this.majorList = majorList;
    }
    
    
    /**
    * This method is to search through the course list and find a course by department and number
    * @param number - the course number as in 247 in CSCE 247
    * @param department - the department of the course as in the CSCE in CSCE 247
    * @return - the course with the matching department and number
    */
    public Course findCourse(String department, String number) {
        return courseList.getCourseByNumber(department, number);
    }
    
    /**
    * This method is to login to the system when given the username and password
    * @param username - the user's entered username
    * @param password - the user's entered password
    * @return - A boolean on wether the login was successful or not
    */
    public boolean login(String username, String password) {
        User user = userList.getUser(username);
        if (user == null || !user.getUsername().equals(username) || !user.getPassword().equals(password))
        return false;
        setCurrentUser(user);
        currentUser.facadeLogin(username, password);
        return true;    
    }
    
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    
    public void addCourse(Course course) {
        courseList.addCourse(course);
    }
    
    public User findUser(String username) {
        return userList.getUser(username);
    }
    
    public String getCourseDetails(Course course) {
        return course.viewCourseDetails();
    }
    
    public String getUserDetails(String username) {
        return userList.getUser(username).toString();
    }
    
    // HIGHES PRIORITY METHODS TO COMPLETE
    // Methods below are for scenario 1
    public String viewStudentDetails(Student student) {
        return student.toString();
    }
    
    public Student findStudent(String username) {
        // Assuming userList is an instance of UserList class
        User user = userList.getUser(username);
        if (user instanceof Student) {
            return (Student) user;
        } else {
            System.out.println("User with username " + username + " is not a Student or doesn't exist.");
            return null;
        }
    }    
    
    public EightSemesterPlan viewEightSemesterPlan(EightSemesterPlan eightSemesterPlan) {
        return eightSemesterPlan;
    }
    
    // Methods below are for scenario 2
    public Advisor createAdvisorAccount(Advisor advisor) {
        userList.addAdvisor(advisor);
        return advisor;
    }
    
    public String viewAdvisorDetails(Advisor advisor) {
        return advisor.toString();
    }
    
    public Student findStudent(UUID studentID) {
        return UserList.getInstance().findStudentById(studentID);
    }
    
    // use view student details with the student being tawnie hill instead of brax west
    
    public EightSemesterPlan viewStudentsEightSemesterPlan(Student student) {
        return student.getEightSemesterPlan();
    }
    
    public void writePlantoTextFile(Student student)
    {
        student.writePlantoText(student);
    }
    
    // added a logout mehtod but not confident in the logic behind it
    public boolean Logout()
    {
        if (currentUser != null)
        {
            currentUser = null;
            return true;
        }
        else
        {
            return true;
        }
        
    }
    
    //added a create new student method
    public void newStudentUser(String fn,String ln, String userName, String password)
    {
        userList.addStudent(new Student(UUID.randomUUID(), userName, password, userName, password));
    }
    
    // added a create new advisor method
    public void newAdvisorUser(String fn,String ln, String userName, String password)
    {
        userList.addAdvisor(new Advisor(UUID.randomUUID(), fn, ln, userName, password, null));
    }

}
