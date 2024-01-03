package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainApplication implements Methods {

    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws ParseException {
        MainApplication APP = new MainApplication();
        APP.readCoursesFromCSV("resources/courses.csv");
        APP.readStudentsFromCSV("resources/students.csv");

        int zgjedhja = 0;
        Scanner input = new Scanner(System.in);

        do {
            APP.Menu();
            zgjedhja = input.nextInt();

            switch (zgjedhja) {
                case 1:
                    // A student can join a course
                    Scanner in = new Scanner(System.in);
                    System.out.println("\n\nJepni ID-ne per kete student!");
                    String studentID = in.nextLine();

                    Student student = new Student(studentID, "SomeStudentName");

                    System.out.println("\n\nJepni titullin e kursit!");
                    String title = in.nextLine();
                    System.out.println("\n\nDetajet e ketij kursi");
                    String descrip = in.nextLine();
                    System.out.println("\n\nJepni autorin e ketij kursi");
                    String author1 = in.nextLine();
                    System.out.println("\n\nJepni daten e zhvillimit te ketij kursi:");
                    String dateString = in.nextLine();

                    try {
                        // Parse the user input into a Date object
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = new Date(dateFormat.parse(dateString).getTime());
                        System.out.println("Parsed Date: " + date);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                    }

                    System.out.println("Jepni location e zhvillimit te ketij kursi:");
                    String locate = in.nextLine();

                    Course mathCourse = new Course(title, descrip, author1, dateString, locate);
                    students.add(student);
                    APP.joinCourse(mathCourse);
                    System.out.println(APP.getCourses());
                    APP.writeCourse();
                    break;
                // ... rest of the code
            }
        } while (zgjedhja != 0);
    }

    @Override
    public void Menu() {
        System.out.print("\n\n--------------------*****Menuja*****--------------------\n\n"
                + "1 --> Join a Course\n"
                + "2 --> Drop a Course\n"
                + "3 --> Course Details\n"
                + "4 -->  Leave Feedback\n"
                + "5 --> View Feedback\n"
                + "6 --> View top-rated courses\n"
                + "7 --> See course calendar\n"
                + "8 -->Remove old feedback\n"
                + "0 --> Dil\n\n"
                + "Zgjedhja: ");
    }

    public void writeCourse() {
        try {
            FileOutputStream ruaj = new FileOutputStream("Studentet.txt", true);
            try {
                ObjectOutputStream ruajStudent = new ObjectOutputStream(ruaj);
                for (Object obj : students) {
                    try {
                        ruajStudent.writeObject(obj);
                    } catch (NotSerializableException e) {
                        System.out.println("An object was not serializable, it has not been saved.");
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> searchAvailableCourses() {
        return courses;
    }

    @Override
    public void joinCourse(Student student, Course course) {
    }

    @Override
    public void dropCourse(Student student, Course course) {
    }

    @Override
    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.dropCourse();
            System.out.println(" dropped the course: " + course.getName());
        } else {
            System.out.println(" is not enrolled in the course: " + course.getName());
        }
    }

    @Override
    public void joinCourse(Course course) {
        courses.add(course);
        course.joinCourse();
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void displayCourseDetails() {
        /////////////////////////////////////////////////////////////////////
    }

    public static void addCourse(String title, String descrip, String author1, String dateString, String locate) {
        Course newCourse = new Course(title, descrip, author1, dateString, locate);
        courses.add(newCourse);
    }

    public void readCoursesFromCSV(String filePath) throws ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Course course = new Course(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    courses.add(course);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStudentsFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1) {
                    String studentID = parts[0];
                    Student student = new Student(studentID, "JohnDoe123");
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
