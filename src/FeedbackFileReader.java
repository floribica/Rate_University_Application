package src;

public class FeedbackFileReader {

    public static void showDiscription(String courseName) {
        String discription[] = new String[2];
        try {
            java.io.File file = new java.io.File("Rate_University_Application/feedback.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                if (courseArray[0].equals(courseName)) {
                    discription[0] = courseArray[1];
                    discription[1] = courseArray[2];
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //call the form method to show the discription

    }

    public static void showRate(String courseName) {
        String discription[] = new String[2];
        try {
            java.io.File file = new java.io.File("Rate_University_Application/feedback.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                if (courseArray[0].equals(courseName)) {
                    discription[0] = courseArray[1];
                    discription[1] = courseArray[3];
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //call the form method to show the discription()

    }

}