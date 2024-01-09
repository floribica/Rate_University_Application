package src;

import login.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FeedbackFileWriter{
    public void writeInFile(String courseName, User user, String feedback, int rating) throws IOException {
        //write in file
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\lenovo\\Desktop\\Rate_University_Application\\feedbacks.txt", true));
        writer.write(courseName + "◊" + user.getUsername() + "◊" + feedback + "◊" + rating);
        writer.newLine();
        writer.close();




    }
}
