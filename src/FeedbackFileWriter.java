package src;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FeedbackFileWriter {

    public static void writeFeedbacksToFile(List<Feedback> feedbacks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\lenovo\\Desktop\\Rate_University_Application\\feedbacks.txt"))) {
            for (Feedback feedback : feedbacks) {
                writer.write(feedback.getDescription() + " " + feedback.getRating() + " "
                        + feedback.getStudentId() + " " + feedback.getCourseId());
                writer.newLine();
            }
            System.out.println("Feedbacks written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
