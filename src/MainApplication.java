//package src;
//
//import login.User;
//import src.Course;
//import src.Feedback;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class MainApplication {
//
//    public static void main(String[] args) {
//        // Create sample courses
//        Course course1 = new Course("Math101", "Introduction to Calculus", "Prof. Smith", "Mon-Wed 9:00-10:30", "Room 101");
//        Course course2 = new Course("CS101", "Introduction to Programming", "Prof. Johnson", "Tue-Thu 11:00-12:30", "Room 201");
//
//        // Create sample feedbacks
//        Feedback feedback1 = new Feedback("Great course!", 5, "student1", "Math101");
//        Feedback feedback2 = new Feedback("Enjoyed the programming assignments.", 4, "student2", "CS101");
//
//        // Create sample users
//        User user1 = new User("John", "Doe", "john", "password1", 1);
//        User user2 = new User("Jane", "Smith", "jane", "password2", 2);
//
//        // Write courses and feedbacks to files
//        List<Course> courses = new ArrayList<>();
//        courses.add(course1);
//        courses.add(course2);
//        CourseFileWriter.writeCoursesToFile(courses);
//
//        List<Feedback> feedbacks = new ArrayList<>();
//        feedbacks.add(feedback1);
//        feedbacks.add(feedback2);
//        FeedbackFileWriter.writeFeedbacksToFile(feedbacks);
//
//        // Read courses and feedbacks from files
//        List<Course> coursesFromFile = CourseFileReader.readCoursesFromFile();
//        List<Feedback> feedbacksFromFile = FeedbackFileReader.readFeedbacksFromFile();
//
//        // Display courses and feedbacks
//        displayCourses(coursesFromFile);
//        displayFeedbacks(feedbacksFromFile);
//
//        // Add more operations as needed for your program
//    }
//
//    private static void displayCourses(List<Course> courses) {
//        System.out.println("Courses:");
//        for (Course course : courses) {
//            System.out.println(course);
//        }
//        System.out.println();
//    }
//
//    private static void displayFeedbacks(List<Feedback> feedbacks) {
//        System.out.println("Feedbacks:");
//        for (Feedback feedback : feedbacks) {
//            System.out.println(feedback);
//        }
//        System.out.println();
//    }
//}
