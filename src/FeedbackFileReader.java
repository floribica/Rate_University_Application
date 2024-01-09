package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeedbackFileReader {

    public static List<Feedback> readFeedbacksFromFile() {
        List<Feedback> feedbacks = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\lenovo\\Desktop\\Rate_University_Application\\feedbacks.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] feedbackArray = line.split(" ", 4); // Assuming the first three elements represent the feedback attributes
                if (feedbackArray.length >= 4) {
                    // Assuming appropriate constructor exists in the Feedback class
                    Feedback feedback = new Feedback(feedbackArray[0], Integer.parseInt(feedbackArray[1]), feedbackArray[2], feedbackArray[3]);
                    feedbacks.add(feedback);
                } else {
                    System.err.println("Error: Incomplete feedback data for line: " + line);
                }
            }
            input.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
