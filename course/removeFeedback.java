package course;

public class removeFeedback {

    public static void removeFeedback() {
        FeedbackFileReader feedbackFileReader = new FeedbackFileReader();
        feedbackFileReader.getAllFeedback();

        //get current date
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(date);

        //get feedbacks
        java.util.ArrayList<String> feedbacks = feedbackFileReader.getAllFeedback();

        //remove feedbacks that are one year old
        for (int i = 0; i < feedbacks.size(); i++) {
            String[] feedback = feedbacks.get(i).split(",");
            String feedbackDate = feedback[feedback.length - 1];
            if (feedbackDate.equals(currentDate)) {
                feedbacks.remove(i);
            }
        }
    }
}
