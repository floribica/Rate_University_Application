package course;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeedbackFileReaderTest {

    @Test
    public void showDescription() {
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
}