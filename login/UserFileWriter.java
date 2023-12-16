package login;
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

}

