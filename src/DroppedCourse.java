package src;

import login.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DroppedCourse {

    //create a method to dropped course
    public static void dropCourse(User user, String courseCode) throws IOException {
        //read courses.txt
        java.io.File file = new java.io.File("Rate_University_Application/file/courses.txt");
        java.util.Scanner input = new java.util.Scanner(file);
        //create a string to store all the courses
        String courses = "";
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] courseArray = line.split("◊");
            if (courseArray[0].equals(user.getUsername()) && courseArray[2].equals(courseCode)) {
                continue;
            }
            courses += line + "\n";
        }

        input.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter("Rate_University_Application/file/courses.txt"));
        writer.write(courses);
        writer.close();



    }


}
