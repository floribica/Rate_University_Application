package course;

import login.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackFileReader {

    private static final String FILE_PATH = "Rate_University_Application/file/feedbacks.txt";

    public static void showDescription(String courseName) {
        StringBuilder comments = new StringBuilder();
        try {
            java.io.File file = new java.io.File(FILE_PATH);
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                if (courseArray[0].equals(courseName)) {
                    comments.append(courseArray[1]).append(" => ").append(courseArray[2]).append("\n");
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (comments.length() > 0) {
            // Call the form method to show the description
            DescriptionDisplayForm.showDescription(courseName, comments.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No comments available for this course.");
        }
    }

    public static void showRate(String courseName) {
        List<String> ratingsList = new ArrayList<>();
        try {
            java.io.File file = new java.io.File("Rate_University_Application/file/feedbacks.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                if (courseArray[0].equals(courseName)) {
                    String username = courseArray[1];
                    int rating = Integer.parseInt(courseArray[3]);

                    // Create a string with username and star symbols based on the rating
                    String ratingString = username + " => " + "★".repeat(Math.max(0, rating));

                    ratingsList.add(ratingString);
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (!ratingsList.isEmpty()) {
            // Call the form method to show the ratings
            RatingDisplayForm.showRating(courseName, String.join("\n", ratingsList));
        } else {
            JOptionPane.showMessageDialog(null, "No ratings available for this course.");
        }
    }



    public static ArrayList<String> getAllFeedback(){

        //create an array list that will hold all the feedbacks
        ArrayList<String> feedbacks = new ArrayList<>();

        //read the feedbacks from the file

        try {
            java.io.File file = new java.io.File("Rate_University_Application/file/feedbacks.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                String feedback = courseArray[0] + "," + courseArray[3];

                feedbacks.add(feedback);

            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return feedbacks;
    }




    //control if user have already left a feedback for a course
    public static boolean check(User user, String courseCode){
        boolean check = false;
        try {
            java.io.File file = new java.io.File("Rate_University_Application/file/feedbacks.txt");
            java.util.Scanner input = new java.util.Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] courseArray = line.split("◊");
                if (courseArray[0].equals(courseCode) && courseArray[1].equals(user.getUsername())) {
                    check = true;
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }




}