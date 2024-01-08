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
            while (input.hasNext()) {
                String line = input.nextLine();
                String[] feedbackArray = line.split(" ");
                // Assuming appropriate constructor exists in the Feedback class
                Feedback feedback = new Feedback(feedbackArray[0], Integer.parseInt(feedbackArray[1]),
                        feedbackArray[2], feedbackArray[3]);
                feedbacks.add(feedback);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
