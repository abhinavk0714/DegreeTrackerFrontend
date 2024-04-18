package model;

import java.util.ArrayList;
import java.util.HashMap;
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
    
    
    public Course findCourse(String department, String number) {
        return courseList.getCourseByNumber(department, number);
    }
    /**
     * This method is to check if the user's entered course for course search is valid
     * @param department the user's entered department
     * @param number the user's entered course number
     * @return A boolean on if the course is valid
     */
    public boolean validCourse(String department, String number){
        Course course = courseList.getCourseByNumber(department, number);
        if( course.getDepartment().equals(department) || course.getNumber().equals(number)){
        return true;
        }
        else{
            System.out.println("Invalid Course");
            return false;
        }
        
    }
    
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
        User user = userList.getUser(username);
        return user != null ? user.toString() : "User not found.";
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

    public String viewMajorDetails(){
        HashMap<UUID, Course> coursesMap = DataLoader.loadCourses();
        ArrayList<Major> majors = DataLoader.loadMajors(coursesMap);
        ArrayList<Student> students = DataLoader.loadStudents(coursesMap);
       
        // Printing majors
        System.out.println("\nMajors:");
        for (Major major : majors) {
            String majorInfo = major.toString();
            return majorInfo;
        }
        return null;
    }


    
    //added a create new student method
    public void newStudentUser(String fn,String ln, String userName, String password)
    {
        userList.addStudent(new Student(UUID.randomUUID(), userName, password, userName, password));
        userList.saveStudents();
    }
    
    // added a create new advisor method
    public void newAdvisorUser(String fn,String ln, String userName, String password)
    {
        userList.addAdvisor(new Advisor(UUID.randomUUID(), fn, ln, userName, password, null));
        userList.saveAdvisors();
    }

    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        MajorList majorList = MajorList.getInstance();
        CourseList courseList = CourseList.getInstance();
        GradeSystemFACADE facadeInstance = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);
        if(!facadeInstance.login("BWest", "12345")){
            System.out.println("LoginFailed");
        }
        String currentUsername = facadeInstance.currentUser.getUsername();
        System.out.println(currentUsername);
        String majorDetails = facadeInstance.viewMajorDetails();
        System.out.println("starts here.......");
        System.out.println(majorDetails);

    } 
}
