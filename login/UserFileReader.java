package login;

public class UserFileReader {

    //reads the user and password from the file
    public static User readUserFromFile(String username, String password) {
        User user = null;
        try {
            java.io.File file = new java.io.File("Rate_University_Application/file/users.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] userArray = line.split(" ");
                if (userArray[2].equals(username) && userArray[3].equals(password)) {
                    user = new User(userArray[0], userArray[1], userArray[2], userArray[3], Integer.parseInt(userArray[4]));
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    //reads the user from the file
    public static User readUserFromFile(String username) {
        User user = null;
        try {
            java.io.File file = new java.io.File("Rate_University_Application/login/users.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] userArray = line.split(" ");
                if (userArray[2].equals(username)) {
                    user = new User(userArray[0], userArray[1], userArray[2], userArray[3], Integer.parseInt(userArray[4]));
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }




}
