package login;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserFileWriterTest {

    @Test
    public void writeUserToFile() throws IOException {
        UserFileWriter.writeUserToFile(new User("Flori", "Bica", "fbica2", "a26f4721fbacc763aaaee044dccc3bdafeef1925851f36ebe291bd0b43143c08", 1));

    }
}