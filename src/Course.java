package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;




   // private List<Feedback> feedbacks;

    //public void joinCourse() {
    //    registeredStudents++;
    // }
    public class Course {
        private String name;
        private String description;
        private String lecturer;
        private String times;
        private String location;
        private List<String> registeredStudents;
        private List<String> feedbacks;
        private String title;
        private String author;
        private String startDate;

        public Course(String name, String description, String lecturer, String times, String location) {
            this.name = name;
            this.description = description;
            this.lecturer = lecturer;
            this.times = times;
            this.location = location;
            this.registeredStudents = new ArrayList<>();
            this.feedbacks = new ArrayList<>();

            this.title = "";
            this.author = "";
            this.startDate = "";
        }

        // Getter methods
        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getLecturer() {
            return lecturer;
        }

        public String getTimes() {
            return times;
        }

        public String getLocation() {
            return location;
        }

        public List<String> getRegisteredStudents() {
            return registeredStudents;
        }

        public List<String> getFeedbacks() {
            return feedbacks;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getStartDate() {
            return startDate;
        }

        // Setter methods
        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setLecturer(String lecturer) {
            this.lecturer = lecturer;
        }

        public void setTimes(String times) {
            this.times = times;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setRegisteredStudents(List<String> registeredStudents) {
            this.registeredStudents = registeredStudents;
        }

        public void setFeedbacks(List<String> feedbacks) {
            this.feedbacks = feedbacks;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        // toString method
        @Override
        public String toString() {
            return "Course{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", lecturer='" + lecturer + '\'' +
                    ", times='" + times + '\'' +
                    ", location='" + location + '\'' +
                    ", registeredStudents=" + registeredStudents +
                    ", feedbacks=" + feedbacks +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", startDate='" + startDate + '\'' +
                    '}';
        }

   /* public void addFeedback(Feedback feedback) {
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
    } */


        public static List<Course> searchAvailableCourses(List<Course> allCourses, String studentId) {
            List<Course> availableCourses = new ArrayList<>();

            // Iterate through all courses and check if the student is not registered
            for (Course course : allCourses) {
                if (!course.isStudentRegistered(studentId)) {
                    availableCourses.add(course);
                }
            }

            return availableCourses;
        }

        private boolean isStudentRegistered(String studentId) {

            return registeredStudents.contains(studentId);
        }

        public static void displayJoinedCourses(List<Course> allCourses, String studentId) {
            System.out.println("Courses joined by student with ID " + studentId + ":");
            for (Course course : allCourses) {
                if (course.isStudentRegistered(studentId)) {
                    System.out.println("- " + course.getName()); // Assuming Course has a getName() method
                }
            }
        }

        public void joinCourse(String studentId) {
            if (!isStudentRegistered(studentId)) {
                registeredStudents.add(studentId);
                System.out.println("Student with ID " + studentId + " has joined the course " + getName());
            } else {
                System.out.println("Student with ID " + studentId + " is already registered for the course " + getName());
            }
        }

        public void dropCourse(String studentId) {
            if (isStudentRegistered(studentId)) {
                registeredStudents.remove(studentId);
                System.out.println("Student with ID " + studentId + " has dropped the course " + getName());
            } else {
                System.out.println("Student with ID " + studentId + " is not registered for the course " + getName());
            }
        }

    }
