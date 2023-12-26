package src;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Student  {
    private String studentName;
    private List<Course> courses;

    public Student(String name) {
        this.studentName = name;
        this.courses = new ArrayList<>();
    }

    public void joinCourse(Course course) {
        courses.add(course);
        course.joinCourse();
        System.out.println(studentName + " joined the course: " + course.getName());
    }

    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.dropCourse();
            System.out.println(studentName + " dropped the course: " + course.getName());
        } else {
            System.out.println(studentName + " is not enrolled in the course: " + course.getName());
        }
    }



    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return studentName;
    }

    public void leaveFeedback(Course course, String description, int rating) {
        Feedback feedback = new Feedback(description, rating);
        course.addFeedback(feedback);
        System.out.println("Feedback left for course " + course.getName());
    }

    public void viewFeedbacks(Course course) {
        List<Feedback> feedbacks = course.getFeedbacks();

        if (feedbacks.isEmpty()) {
            System.out.println("No feedback available for the course: " + course.getName());
        } else {
            Collections.sort(feedbacks, Comparator.comparing(Feedback::getDate).reversed());

            System.out.println("Feedbacks for Course: " + course.getName());
            for (Feedback f : feedbacks) {
                System.out.println("Date: " + f.getDate());
                System.out.println("Description: " + f.getDescription());
                System.out.println("Rating: " + f.getRating());
                System.out.println();
            }

            double averageRating = calculateAverageRating(feedbacks);
            System.out.println("Average Rating: " + averageRating);
        }
    }

    private double calculateAverageRating(List<Feedback> feedbacks) {
        int totalRating = 0;
        for (Feedback f : feedbacks) {
            totalRating += f.getRating();
        }

        return (double) totalRating / feedbacks.size();
    }

    public void viewTopRatedCourses(List<Course> courses, int count) {
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            // Use Comparator.comparingDouble with a lambda expression for clarity
            courses.sort(Comparator.comparingDouble(course -> calculateAverageRating((List<Feedback>) course)).reversed());

            System.out.println("Top Rated Courses:");

            // Use Math.min to avoid IndexOutOfBoundsException if count is greater than the list size
            int displayCount = Math.min(count, courses.size());

            for (int i = 0; i < displayCount; i++) {
                Course course = courses.get(i);
                // Ensure course is not null before displaying details
                if (course != null) {
                    course.displayCourseDetails();
                    System.out.println();
                }
            }
        }
    }


    public void removeOldFeedbacks(List<Course> courses) {
        Date currentDate = new Date(0, 0, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Date oneYearAgo = (Date) calendar.getTime();

        for (Course course : courses) {
            List<Feedback> feedbacks = course.getFeedbacks();

            Iterator<Feedback> iterator = feedbacks.iterator();
            while (iterator.hasNext()) {
                Feedback feedback = iterator.next();
                if (feedback.getDate().before(oneYearAgo)) {
                    iterator.remove();
                    System.out.println("Removed old feedback for the course: " + course.getName());
                }
            }
        }
    }

    public String getStudentId() {
        return studentName;
    }
}
