package course;

import login.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoinedCourseReaderTest {

    @Test
    public void checkuserExist() {
        JoinedCourseReader reader = new JoinedCourseReader();
        User user = new User("test", "test", "test", "test", 1);
        String courseCode = "test";
        Boolean result = reader.checkuserExist(user, courseCode);
        assertEquals(false, result);
    }

}