package src;

import java.util.List;

public interface Methods  {
    //duhet implementuar
    void Menu();        //duhet implementuar

    // FR2: Search for available courses and join or drop a course
    List<Course> searchAvailableCourses();
    void joinCourse(Student student, Course course);
    void dropCourse(Student student, Course course);
    // FR3: Check course details

    void joinCourse(Course course);

    List<Course> getCourses();
    // FR4: Leave feedback for a course
    //void leaveFeedback(Student student, Course course, String description, int rating);

    // FR5: View feedback for a course
    List<Feedback> viewFeedback(Course course);

    void viewFeedbacks(Course course);

    double calculateAverageRating(List<Feedback> feedbacks);

    void displayCourseDetails();

    void leaveFeedback(Student student, Course course, String description, int rating);

    abstract void viewTopRatedCourses(List<Course> courses, int count);

    void removeOldFeedbacks(List<Course> courses);

    void leaveFeedback(Course course, String description, int rating);
}
