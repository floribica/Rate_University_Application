package course;

import login.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeedbackFormTest {

    @Test
    public void leaveFeedback() {
        User user = new User("test", "test", "test", "test", 1);
        String courseID = "test";
        FeedbackForm.leaveFeedback(user, courseID);

    }
}