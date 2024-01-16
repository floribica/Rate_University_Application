package course;

import login.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void pg1() {
        User user = new User("test", "test", "test", "test", 1);
        CoursePage1 pg1 = new CoursePage1(user);
        pg1.setVisible(true);
        assertTrue(pg1.isVisible());

    }

    @Test
    public void openCalendar() {
        Calendar calendar = new Calendar();
        calendar.openCalendar();
    }

    @Test
    public void course() {
        CoursePersonalPage coursePersonalPage = new CoursePersonalPage();
        String[] course = {"CSE 110", "Introduction to Programming", "Fall 2018", "4.0", "4.0", "4.0", "4.0", "4.0", "4.0"};
        String[] course2 = {"CSE 110", "Introduction to Programming", "Fall 2018", "4.0", "4.0", "4.0", "4.0", "4.0", "4.0"};
        assertArrayEquals(course, course2);
    }

    @Test
    public void showDescription() {
        DescriptionDisplayForm descriptionDisplayForm = new DescriptionDisplayForm("courseName", "description");
        descriptionDisplayForm.setVisible(true);
        assertTrue(descriptionDisplayForm.isVisible());
    }

    @Test
    public void showDescription2() {
        FeedbackFileReader.showDescription("CSE1001");
    }

    @Test
    public void showRate() {
        FeedbackFileReader.showRate("CSE1001");
    }

    @Test
    public void getAllFeedback() {
        FeedbackFileReader.getAllFeedback();
    }

    @Test
    public void leaveFeedback() {
        User user = new User("test", "test", "test", "test", 1);
        String courseID = "test";
        FeedbackForm.leaveFeedback(user, courseID);

    }

    @Test
    public void checkuserExist() {
        JoinedCourseReader reader = new JoinedCourseReader();
        User user = new User("test", "test", "test", "test", 1);
        String courseCode = "test";
        Boolean result = reader.checkuserExist(user, courseCode);
        assertEquals(false, result);
    }

    @Test
    public void course2() {
        User user = new User("test", "test", "test", "test", 1);
        JoinedCourseReader.checkuserExist(user, "test");
    }

    @Test
    public void showRating() {
        String courseName = "CZ2002";
        String ratings = "4.5";
        RatingDisplayForm.showRating(courseName, ratings);
    }

    @Test
    public void getTopRateCourse() {
        TopRateCourse topRateCourse = new TopRateCourse();
        assertEquals(4, topRateCourse.getTopRateCourse().size());

    }

    @Test
    public void showTopRateCourse() {
        TopRateCourse topRateCourse = new TopRateCourse();
        topRateCourse.getTopRateCourse();

    }

    @Test
    public void rateCourse() {
        TopRateForm topRateForm = new TopRateForm();
        topRateForm.rateCourse();
    }

    @Test
    public void check() {
        User user = new User("test", "test", "test", "test", 1);
        String courseID = "test";
        FeedbackFileReader.check(user, courseID);
    }

    @Test
    public void removeFeedback() {
        removeFeedback removeFeedback = new removeFeedback();
        removeFeedback.removeFeedback();

    }

}