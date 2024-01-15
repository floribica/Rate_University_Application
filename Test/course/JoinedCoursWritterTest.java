package course;

import login.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoinedCoursWritterTest {

    @Test
    public void course() {
        User user = new User("test", "test", "test", "test", 1);
        String[] course = {"test", "test", "test"};
        JoinedCourseReader.checkuserExist(user, "test");
    }
}