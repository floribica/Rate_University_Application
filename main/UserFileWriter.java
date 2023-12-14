package main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserFileWriter {
    public static void writeUserToFile(User user) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
        writer.write(user.getFirstName() + " " + user.getLastName() + " " + user.getUsername() + " " + user.getPassword() + " " + user.getId());
        writer.newLine();
        writer.close();
    }


    //toStrig method
    public static String toString(User user) {
        return "Name: "+user.getFirstName() +" LastName: "+user.getLastName() + " Username: " + user.getUsername() + " Password: " + user.getPassword() + " Id: " + user.getId();
    }
}
