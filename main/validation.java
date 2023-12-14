package main;

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
    


}
