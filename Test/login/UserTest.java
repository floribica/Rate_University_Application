package login;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

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

}