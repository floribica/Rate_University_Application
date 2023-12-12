package src;
import java.util.Date;

public class MainApplication {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();

        // Adding sample courses
        courseService.addCourse("John Doe", "Java Programming", 30, new Date(), new Date());
        courseService.addCourse("Jane Smith", "Web Development", 25, new Date(), new Date());

        // Display available courses
        courseService.tableCourse();

    }
}

