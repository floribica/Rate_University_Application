package src;

import login.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JoinedCoursWritter {

public static void course(String [] course, User user)throws IOException {

            //write in file
            BufferedWriter writer = new BufferedWriter(new FileWriter("Rate_University_Application/file/courses.txt", true));
            writer.write(user.getUsername()+"◊"+course[0]+"◊" + course[1]+"◊"+ course[2]);
            writer.newLine();
            writer.close();
        }
    }


