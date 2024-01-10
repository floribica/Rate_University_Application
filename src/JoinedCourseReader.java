package src;

import login.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class JoinedCourseReader {
    //create a method to read courses.txt

    private static final String FILE_PATH = "file/courses.txt";

    public static Boolean checkuserExist(User user, String courseCode) {
        boolean userExist = false;

        try {
            java.io.File file = new java.io.File(FILE_PATH);
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                if (courseArray[0].equals(user.getUsername()) && courseArray[2].equals(courseCode)) {
                    userExist = true;
                    break;
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return userExist;
    }


    public static List<String[]> getJoinedCourses(User user) {
        List<String[]> joinedCourses = new ArrayList<>();

        try {
            File file = new File(FILE_PATH);
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                if (courseArray[0].equals(user.getUsername())) {
                    joinedCourses.add(courseArray);
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return joinedCourses;
    }

}
