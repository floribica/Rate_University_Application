package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class validation {

    public static boolean validatePassword(String password) {
        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter
        boolean hasUppercase = !password.equals(password.toLowerCase());
        if (!hasUppercase) {
            return false;
        }

        // Check if password contains at least one lowercase letter
        boolean hasLowercase = !password.equals(password.toUpperCase());
        if (!hasLowercase) {
            return false;
        }

        // Check if password contains at least one number
        boolean hasNumber = password.matches(".*\\d.*");
        if (!hasNumber) {
            return false;
        }

        // Check if password contains at least one special character
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9 ]*");
        if (!hasSpecialChar) {
            return false;
        }

        return true;
    }

    public static boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
    // encrypts the password
    public static String encryptPassword(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert bytes to hexadecimal representation
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle the exception based on your application's needs
            return null;
        }
    }




    //validates the name
    public static boolean validateName(String name) {
        // Check if name is at least 2 characters long
        if (name.length() < 2) {
            return false;
        }

        // Check if name contains only letters
        boolean hasOnlyLetters = name.matches("[A-Za-z ]*");
        if (!hasOnlyLetters) {
            return false;
        }

        return true;
    }

    //validates the last name
    public static boolean validateLastName(String lastName) {
        // Check if name is at least 2 characters long
        if (lastName.length() < 2) {
            return false;
        }

        // Check if name contains only letters
        boolean hasOnlyLetters = lastName.matches("[A-Za-z ]*");
        if (!hasOnlyLetters) {
            return false;
        }

        return true;
    }

    //validates the username
    public static boolean validateUsername(String username) {
        // Check if username is at least 5 characters long
        if (username.length() < 5) {
            return false;
        }

        // Check if username contains only letters and numbers
        boolean hasOnlyLettersAndNumbers = username.matches("[A-Za-z0-9]*");
        if (!hasOnlyLettersAndNumbers) {
            return false;
        }



        return true;
    }

}
