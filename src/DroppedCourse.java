package src;

import login.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DroppedCourse {
    //create a method to dropped course
    public static void course(String [] course, User user) throws IOException {
        //write in file
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\klaud\\OneDrive\\Documents\\GitHub\\Rate_University_Application\\dropped.txt", true));
        writer.write(course[0] + course[1]+ course[2]+ "◊" + user.getUsername());
        writer.newLine();
        writer.close();
    }


}
