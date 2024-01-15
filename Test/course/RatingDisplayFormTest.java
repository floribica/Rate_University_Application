package course;

import org.junit.Test;

import static org.junit.Assert.*;

public class RatingDisplayFormTest {

    @Test
    public void showRating() {
        String courseName = "CZ2002";
        String ratings = "4.5";
        RatingDisplayForm.showRating(courseName, ratings);
    }
}