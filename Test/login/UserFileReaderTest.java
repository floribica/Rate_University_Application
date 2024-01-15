package login;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserFileReaderTest {

    @Test
    public void readUserFromFile() {
        User user = UserFileReader.readUserFromFile("fbica", "a26f4721fbacc763aaaee044dccc3bdafeef1925851f36ebe291bd0b43143c08");
        assertEquals("fbica", user.getUsername());
        assertEquals("a26f4721fbacc763aaaee044dccc3bdafeef1925851f36ebe291bd0b43143c08", user.getPassword());
        assertEquals("Flori", user.getFirstName());
        assertEquals("Bica", user.getLastName());
    }

    @Test
    public void testReadUserFromFile() {
        User user = UserFileReader.readUserFromFile("fbica");
        assertEquals("fbica", user.getUsername());
        assertEquals("a26f4721fbacc763aaaee044dccc3bdafeef1925851f36ebe291bd0b43143c08", user.getPassword());
        assertEquals("Flori", user.getFirstName());
        assertEquals("Bica", user.getLastName());

    }
}