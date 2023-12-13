/*package src;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CourseService {

    private List<Course> allCourses;


    public CourseService() {

        this.allCourses = new ArrayList<>();
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(allCourses);
    }

    public boolean enrollStudent(Course course, Student student) {
        // Check if there's available capacity in the course
        if (course.getCapacity() > 0) {
            // Enroll the student

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your name:");
            String studentName = scanner.nextLine();

            System.out.println("Enter the author of the course:");
            String courseAuthor = scanner.nextLine();

            System.out.println("Enter the name of the course you want to enroll in:");
            String courseName = scanner.nextLine();

        }
        course.setCapacity(course.getCapacity() - 1);
        return true;
    }

    private int registeredStudents;

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void registerStudent() {
        registeredStudents++;
    }
    public void dropStudent(Course course, Student student) {
        // Implement logic to drop a student from a course
        // This might involve updating the course's capacity
        course.setCapacity(course.getCapacity() + 1);
    }
    public boolean isCourseAvailable(String courseName) {
        for (Course course : allCourses) {
            if (course.getCourseName().equals(courseName)) {
                return true; // Course found, so it is available
            }
        }
        return false; // Course not found, so it is not available
    }
    public void addCourse(String author, String courseName, int capacity, Date startDate, Date endDate) {
        Course newCourse = new Course(author, courseName, capacity, startDate, endDate);
        allCourses.add(newCourse);
    }
    public void tableCourse() {
        System.out.println("Course Table:");
        System.out.println("| Author     | Course Name        | Capacity | Start Date    | End Date      |");
        System.out.println("|------------|--------------------|----------|---------------|---------------|");

        for (Course course : allCourses) {
            System.out.println(course);
        }
    }

}
*/