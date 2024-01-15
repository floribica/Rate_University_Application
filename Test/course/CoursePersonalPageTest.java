package course;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoursePersonalPageTest {

    @Test
    public void course() {
        CoursePersonalPage coursePersonalPage = new CoursePersonalPage();
        String[] course = {"CSE 110", "Introduction to Programming", "Fall 2018", "4.0", "4.0", "4.0", "4.0", "4.0", "4.0"};
        String[] course2 = {"CSE 110", "Introduction to Programming", "Fall 2018", "4.0", "4.0", "4.0", "4.0", "4.0", "4.0"};
        assertArrayEquals(course, course2);
    }
}