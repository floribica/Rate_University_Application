package course;

import org.junit.Test;

import static org.junit.Assert.*;

public class DescriptionDisplayFormTest {

    @Test
    public void showDescription() {
        DescriptionDisplayForm descriptionDisplayForm = new DescriptionDisplayForm("courseName", "description");
        descriptionDisplayForm.setVisible(true);
        assertTrue(descriptionDisplayForm.isVisible());
    }
}