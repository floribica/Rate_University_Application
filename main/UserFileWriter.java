package main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserFileWriter {
    public static void writeUserToFile(User user, boolean isStudent) {
        String filename = isStudent ? "students.txt" : "courses.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Format the user information
            String userInfo = String.format("%s,%s,%s,%s,%d", user.getFirstName(), user.getLastName(),
                    user.getUsername(), user.getPassword(), user.getId());

            // Append "01" for students or "02" for courses
            userInfo += isStudent ? ",01" : ",02";

            // Write to the file
            writer.write(userInfo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
