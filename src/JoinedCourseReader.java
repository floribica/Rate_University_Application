package src;

import login.User;

import javax.swing.*;

public class JoinedCourseReader {
    //create a method to read courses.txt

    private static final String FILE_PATH = "Rate_University_Application/file/courses.txt";

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

}
