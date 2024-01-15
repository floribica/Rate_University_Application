package course;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopRateFormTest {

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
}