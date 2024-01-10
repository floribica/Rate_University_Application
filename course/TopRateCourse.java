package course;

import java.util.ArrayList;

public class TopRateCourse {

    public static ArrayList<String> getTopRateCourse() {
        FeedbackFileReader feedbackFileReader = new FeedbackFileReader();
        ArrayList<String> courseNames = feedbackFileReader.getAllFeedback();
        ArrayList<String> topRateCourseNames = new ArrayList<>();

        //calculet average rating for each course split by","
        for (String courseName : courseNames) {
            String[] courseArray = courseName.split(",");
            String courseName1 = courseArray[0];
            int sum = 0;
            int count = 0;
            for (String courseName2 : courseNames) {
                String[] courseArray2 = courseName2.split(",");
                String courseName3 = courseArray2[0];
                if (courseName1.equals(courseName3)) {
                    sum += Integer.parseInt(courseArray2[1]);
                    count++;
                }
            }
            double average = (double) sum / count;
            if (average >= 4) {
                topRateCourseNames.add(courseName1 + " => " + average);
            }
        }

        //sort the topRateCourseNames by average rating
        for (int i = 0; i < topRateCourseNames.size(); i++) {
            for (int j = i + 1; j < topRateCourseNames.size(); j++) {
                String[] courseArray1 = topRateCourseNames.get(i).split("=>");
                String[] courseArray2 = topRateCourseNames.get(j).split("=>");
                double average1 = Double.parseDouble(courseArray1[1]);
                double average2 = Double.parseDouble(courseArray2[1]);
                if (average1 < average2) {
                    String temp = topRateCourseNames.get(i);
                    topRateCourseNames.set(i, topRateCourseNames.get(j));
                    topRateCourseNames.set(j, temp);
                }
            }
        }



        return topRateCourseNames;


    }
}
