package login;

import org.junit.Test;

import static org.junit.Assert.*;

public class validationTest {

    @Test
    public void validatePassword() {
        validation validation = new validation();
        boolean result = validation.validatePassword("FloriBica2!");
        assertEquals(true, result);

    }

    @Test
    public void confirmPassword() {
        validation validation = new validation();
        boolean result = validation.confirmPassword("FloriBica2!", "FloriBica2!");
        assertEquals(true, result);

    }

    @Test
    public void encryptPassword() {
        validation validation = new validation();
        String result = validation.encryptPassword("FloriBica2!");
        assertEquals("9492874f4a59d1fca51a2d4ec3b064ce8a906c7f92b6a4b3027af169c967541e", result);
    }

    @Test
    public void validateName() {
        validation validation = new validation();
        boolean result = validation.validateName("Flori");
        assertEquals(true, result);

    }

    @Test
    public void validateLastName() {
        validation validation = new validation();
        boolean result = validation.validateLastName("Bica");
        assertEquals(true, result);

    }

    @Test
    public void validateUsername() {
        validation validation = new validation();
        boolean result = validation.validateUsername("fbica2");
        assertEquals(true, result);

    }
}