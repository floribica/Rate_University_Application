package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Feedback {
    private String description;
    private List<String> feedbacks; //list of feedback descriptions
    private int rating;
    private LocalDate creationDate;
    private String studentId;
    private String courseId;

    public Feedback(String description, int rating, String studentUsername, String courseId) {
        this.description = description;
        this.rating = rating;
        this.creationDate = LocalDate.now();
        this.studentId = studentUsername;
        this.courseId = courseId;
        this.feedbacks = new ArrayList<>();
    }

    // Getter methods
    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getFeedbacks() {
        return feedbacks;
    }

    public String getCourseId() {
        return courseId;
    }

    // Setter methods
    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFeedbacks(List<String> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

//    @Override
//    public String toString() {
//        return "Feedback{" +
//                "description='" + description + '\'' +
//                ", rating=" + rating +
//                ", creationDate=" + creationDate +
//                ", studentId='" + studentId + '\'' +
//                ", courseId='" + courseId + '\'' +
//                '}';
//    }
//
//    public static void leaveFeedback(List<Feedback> feedbacks, String courseId, String studentId, String description, int rating) {
//        // Check if the student is registered for the course before allowing feedback
//        if (isStudentRegisteredForCourse(feedbacks, courseId, studentId)) {
//            Feedback newFeedback = new Feedback(description, rating, studentId, courseId);
//            feedbacks.add(newFeedback);
//            System.out.println("Feedback submitted successfully for course " + courseId);
//        } else {
//            System.out.println("Error: Student with ID " + studentId + " is not registered for course " + courseId + ". Cannot leave feedback.");
//        }
//    }
//
//    public static double getAverageRatingForCourse(List<Feedback> feedbacks, String courseId) {
//        int totalRating = 0;
//        int totalFeedbacks = 0;
//
//        for (Feedback feedback : feedbacks) {
//            if (feedback.getCourseId().equals(courseId)) {
//                totalRating += feedback.getRating();
//                totalFeedbacks++;
//            }
//        }
//
//        return totalFeedbacks > 0 ? (double) totalRating / totalFeedbacks : 0.0;
//    }
//
//    public static List<Feedback> filterFeedbacksByDate(List<Feedback> feedbacks, LocalDate startDate, LocalDate endDate) {
//        List<Feedback> filteredFeedbacks = new ArrayList<>();
//
//        for (Feedback feedback : feedbacks) {
//            LocalDate creationDate = feedback.getCreationDate();
//            if (creationDate.isAfter(startDate) && creationDate.isBefore(endDate)) {
//                filteredFeedbacks.add(feedback);
//            }
//        }
//
//        return filteredFeedbacks;
//    }
//
//    public static List<Feedback> removeOldFeedbacks(List<Feedback> feedbacks) {
//        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
//
//        Iterator<Feedback> iterator = feedbacks.iterator();
//        while (iterator.hasNext()) {
//            Feedback feedback = iterator.next();
//            if (feedback.getCreationDate().isBefore(oneYearAgo)) {
//                iterator.remove();
//            }
//        }
//
//        return feedbacks;
//    }
//
//    private static boolean isStudentRegisteredForCourse(List<Feedback> feedbacks, String courseId, String studentId) {
//        for (Feedback feedback : feedbacks) {
//            if (feedback.getCourseId().equals(courseId) && feedback.getStudentId().equals(studentId)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
