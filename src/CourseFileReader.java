package src;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseFileReader {

    public static List<Course> readCoursesFromFile() {
        List<Course> courses = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\lenovo\\Desktop\\Rate_University_Application\\courses.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split(" ");
                // Assuming appropriate constructor exists in the Course class
                Course course = new Course(courseArray[0], courseArray[1], courseArray[2], courseArray[3], courseArray[4]);
                courses.add(course);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
