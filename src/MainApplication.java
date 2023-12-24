package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class MainApplication implements Methods {
    private List<Course> courses; // Assume this is initialized with all available courses
    private List<Student> students;
    public MainApplication() {
        // Initialize courses and students lists
        courses = new ArrayList<>();
        students = new ArrayList<>();
        // Populate with test data

    }


    public static void main(String[] args) {
        MainApplication APP = new MainApplication();


        int zgjedhja = 0;
        Scanner input = new Scanner(System.in);
        // int i = APP.Lexo_Studentet();  // ben leximin nga file i studenteve dhe kthen numrin e studenteve ne file
        // int j = APP.lexo_Kurset();
        // APP.setNumriStudenteve(i);
        //System.out.println("Studentet: "+APP.nr_Studenteve);


        do {
            //shfaq menune
            APP.Menu();

            zgjedhja = input.nextInt();
            //Zgjedhja e opsioneve te menuse nga perdoruesi
            switch (zgjedhja) {

                case 1:


                    //A student can join a course

                    Scanner in = new Scanner(System.in);
                    System.out.println("\n\nJepni ID-ne per kete student!");
                    String studentID=in.nextLine();

                    Student student = new Student(studentID);


                    System.out.println("\n\nJepni titullin e kursit!");
                    String title=in.nextLine();
                    System.out.println("\n\nDetajet e ketij kursi");
                    String descrip=in.nextLine();
                    System.out.println("\n\nJepni autorin e ketij kursi");
                    String author1=in.nextLine();
                    System.out.println("\n\nJepni daten e zhvillimit te ketij kursi:");
                    String dateString = in.nextLine();

                    try {
                        // Parse the user input into a Date object
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = dateFormat.parse(dateString);

                        // Use the parsed Date object as needed
                        System.out.println("Parsed Date: " + date);

                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                    }


                    System.out.println("Jepni location e zhvillimit te ketij kursi:");
                    String locate=in.nextLine();


                    Course mathCourse = new Course(title,descrip,author1,dateString,locate);

                    student.joinCourse(mathCourse);
                    APP.writeCourse();


                    //APP.viewTopRatedCourses(APP.allCourses, 5);
                    break;
                case 2:
                    // A student can drop a course




                    break;
                case 3:
                    // View Course Details

                    break;

                case 4:
                    //Leave a feedback

                    break;

                case 5:
                    //View A Feedback
                    break;
                case 6:
                    // View top-rated courses

                    break;

                case 7:
                    //See course calendar


                    break;

                case 8:
                    //Remove old feedback

                    break;

                default:
                    System.out.println("\nInput i gabuar. Provo perseri !\n\n");
                    break;
            }
        } while (zgjedhja != 0);
    }

    public void studentsEnrolled(Course course) {
        List<Student> enrolledStudents = new ArrayList<>();
        for (Student student : students) { // Assuming students is the list of students
            if (student.getCourses().contains(course)) {
                enrolledStudents.add(student);
            }
        }

        System.out.println("Students enrolled in the course: " + course.getName());
        for (Student student : enrolledStudents) {
            System.out.println(student.getName());
        }
    }

    // @SuppressWarnings("resource")

    @Override
    public void Menu () {
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
                for (Object obj : students){
                    try {
                        ruajStudent.writeObject(obj);
                        // System.out.println("saved");
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
        // Return a list of all available courses
        return courses;
    }

    @Override
    public void joinCourse(Student student, Course course) {
        // Student joins a course
        student.joinCourse(course);
    }

    @Override
    public void dropCourse(Student student, Course course) {
        // Student drops a course
        student.dropCourse(course);
    }


    @Override
    public List<Feedback> viewFeedback(Course course) {
        // Return a list of feedback for a course, ordered by date
        return course.getFeedbacks();
    }

    @Override
    public void displayCourseDetails() {
        /////////////////////////////////////////////////////////////////////
    }

    @Override
    public void leaveFeedback(Student student, Course course, String description, int rating) {
//////////////////////////////////////////////////////////////
    }
}

