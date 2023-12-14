package main;

import javax.swing.*;
import java.awt.*;

public class checkValidation extends Component {
    public void checkValidation(String firstName, String lastName, String username, String password,String confirmPassword){
        // Validate password
        boolean isValidPassword = validation.validatePassword(password);
        if (!isValidPassword) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
            return;
        }


        // Confirm password
        boolean isConfirmedPassword = validation.confirmPassword(password, confirmPassword);
        if (!isConfirmedPassword) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }
        // Validate name
        boolean isValidName = validation.validateName(firstName);
        if (!isValidName) {
            JOptionPane.showMessageDialog(this, "Name must be at least 2 characters long and contain only letters.");
            return;
        }

        // Validate last name
        boolean isValidLastName = validation.validateName(lastName);
        if (!isValidLastName) {
            JOptionPane.showMessageDialog(this, "Last name must be at least 2 characters long and contain only letters.");
            return;
        }

        // Validate username
        boolean isValidUsername = validation.validateUsername(username);
        if (!isValidUsername) {
            JOptionPane.showMessageDialog(this, "Username must be at least 6 characters long and contain only letters and numbers.");
            return;
        }
    }
}
