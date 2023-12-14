package main;

import javax.swing.*;
import java.awt.*;

public class checkValidation extends Component {
    public void checkValidation(String password,String confirmPassword){
        // Validate password
        boolean isValidPassword = validation.validatePassword(password);
        if (!isValidPassword) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
            return;
        }

        // Encrypt password
        password = validation.encryptPassword(password);
        confirmPassword = validation.encryptPassword(confirmPassword);

        // Confirm password
        boolean isConfirmedPassword = validation.confirmPassword(password, confirmPassword);
        if (!isConfirmedPassword) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }
    }
}
