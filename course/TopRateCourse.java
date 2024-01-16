package course;

import java.util.ArrayList;

public class TopRateCourse {

    public static ArrayList<String> getTopRateCourse() {

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

    //sort the feedbacks
    public static ArrayList<String> sortFeedbacks(ArrayList<String> feedbacks) {
        ArrayList<String> sortedFeedbacks = new ArrayList<>();
        for (int i = 0; i < feedbacks.size(); i++) {
            String[] feedbackArray = feedbacks.get(i).split(",");
            int rate = Integer.parseInt(feedbackArray[1]);
            if (rate >= 4) {
                sortedFeedbacks.add(feedbacks.get(i));
            }
        }
        return sortedFeedbacks;
    }

    //get the top 5 rate courses in format courseCode => rate
    public static ArrayList<String> getTop5RateCourse() {
        ArrayList<String> top5RateCourse = new ArrayList<>();
        ArrayList<String> sortedFeedbacks = sortFeedbacks(getTopRateCourse());
        if (sortedFeedbacks.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                String[] feedbackArray = sortedFeedbacks.get(i).split(",");
                top5RateCourse.add(feedbackArray[0] + " => " + feedbackArray[1]);
            }

            return top5RateCourse;
        } else if (sortedFeedbacks.size() > 0 && sortedFeedbacks.size() < 5) {
            for (int i = 0; i < sortedFeedbacks.size(); i++) {
                String[] feedbackArray = sortedFeedbacks.get(i).split(",");
                top5RateCourse.add(feedbackArray[0] + " => " + feedbackArray[1]);
            }
            return top5RateCourse;
        } else {
            return null;
        }
    }
}
