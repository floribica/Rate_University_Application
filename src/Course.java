package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;


public class Course  {
    private String name;
    private String description;
    private String lecturer;
    private String times;
    private String location;
    private String title;
    private String author;
    private String startDate;
    private int registeredStudents;
    private List<Feedback> feedbacks;


    public Course(String name, String description, String lecturer, String times, String location) {
        this.name = name;
        this.description = description;
        this.lecturer = lecturer;
        this.times = times;
        this.location = location;
        this.registeredStudents = 0; // Initially no students registered
        this.feedbacks = new ArrayList<>();
    }

    public void joinCourse() {
        registeredStudents++;
    }

    public String getDescription() {
        return description;
    }
    public void dropCourse() {
        if (registeredStudents > 0) {
            registeredStudents--;
        }
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
    public void displayCourseDetails() {
        System.out.println("Course: " + name);
        System.out.println("Description: " + description);
        System.out.println("Lecturer: " + lecturer);
        System.out.println("Times: " + times);
        System.out.println("Location: " + location);
        System.out.println("Registered Students: " + registeredStudents);
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public String getAuthor() {
        return author;
    }

    public String getStartDate() {
        return startDate;
    }


    public String getLocation() {
        return location;
    }

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public String getCourseId() {
        return name; // Consider renaming to getName() for consistency
    }

    public static void writeCoursesToCSV(List<Course> courses, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Course course : courses) {
                writer.println(course.getTitle() + "," + course.getDescription() + "," +
                        course.getAuthor() + "," + course.getStartDate() + "," + course.getLocation());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
