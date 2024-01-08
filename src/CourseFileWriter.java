package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CourseFileWriter {

    public static void writeCoursesToFile(List<Course> courses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\lenovo\\Desktop\\Rate_University_Application\\courses.txt"))) {
            for (Course course : courses) {
                writer.write(course.getName() + " " + course.getDescription() + " " + course.getLecturer() + " "
                        + course.getTimes() + " " + course.getLocation());
                writer.newLine();
            }
            System.out.println("Courses written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
