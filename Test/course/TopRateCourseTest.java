package course;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopRateCourseTest {

    @Test
    public void getTopRateCourse() {
        TopRateCourse topRateCourse = new TopRateCourse();
        assertEquals(9, topRateCourse.getTopRateCourse().size());

    }
}