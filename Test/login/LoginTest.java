package login;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void main() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { // Nimbus is a look and feel for Java Swing applications
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) { // If the look and feel is not supported
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

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

    @Test
    public void writeUserToFile() throws IOException {
        UserFileWriter.writeUserToFile(new User("Flori", "Bica", "fbica2", "a26f4721fbacc763aaaee044dccc3bdafeef1925851f36ebe291bd0b43143c08", 1));

    }

    @Test
    public void getFirstName() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void getLastName() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void getUsername() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        assertEquals("jdoe", user.getUsername());
    }

    @Test
    public void getPassword() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        assertEquals("password", user.getPassword());
    }

    @Test
    public void getId() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        assertEquals(1, user.getId());
    }

    @Test
    public void setFirstName() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        user.setFirstName("Jane");
        assertEquals("Jane", user.getFirstName());
    }

    @Test
    public void setLastName() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        user.setLastName("Doe");
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void setUsername() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        user.setUsername("jdoe");
        assertEquals("jdoe", user.getUsername());

    }

    @Test
    public void setPassword() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        user.setPassword("password");
        assertEquals("password", user.getPassword());
    }

    @Test
    public void setId() {
        User user = new User("John", "Doe", "jdoe", "password", 1);
        user.setId(1);
        assertEquals(1, user.getId());
    }

    @Test
    public void validatePassword() {
        validation validation = new validation();
        boolean result = validation.validatePassword("FloriBica2!");
        assertEquals(true, result);

    }

    @Test
    public void confirmPassword() {
        validation validation = new validation();
        boolean result = validation.confirmPassword("FloriBica2!", "FloriBica2!");
        assertEquals(true, result);

    }

    @Test
    public void encryptPassword() {
        validation validation = new validation();
        String result = validation.encryptPassword("FloriBica2!");
        assertEquals("9492874f4a59d1fca51a2d4ec3b064ce8a906c7f92b6a4b3027af169c967541e", result);
    }

    @Test
    public void validateName() {
        validation validation = new validation();
        boolean result = validation.validateName("Flori");
        assertEquals(true, result);

    }

    @Test
    public void validateLastName() {
        validation validation = new validation();
        boolean result = validation.validateLastName("Bica");
        assertEquals(true, result);

    }

    @Test
    public void validateUsername() {
        validation validation = new validation();
        boolean result = validation.validateUsername("fbica2");
        assertEquals(true, result);

    }

}