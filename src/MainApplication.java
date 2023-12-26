package src;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MainApplication implements Methods {

    Student student = new Student();

    private static List<Course> courses = new ArrayList<>();// Assume this is initialized with all available courses
    private static List<Student> students = new ArrayList<>();

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
                    students.add(student);
                    student.joinCourse(mathCourse);
                    System.out.println(APP.getCourses());
                    APP.writeCourse();


                    //APP.viewTopRatedCourses(APP.allCourses, 5);
                    break;
                case 2:
                    // A student can drop a course
                System.out.println("Jepni emrin e kursit te cilit doni te largoni Studentin!");




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
    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.dropCourse();
            System.out.println(studentName + " dropped the course: " + course.getName());
        } else {
            System.out.println(studentName + " is not enrolled in the course: " + course.getName());
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
    @Override
    public double calculateAverageRating(List<Feedback> feedbacks) {
        int totalRating = 0;
        for (Feedback f : feedbacks) {
            totalRating += f.getRating();
        }

        return (double) totalRating / feedbacks.size();
    }

    @Override
    public void displayCourseDetails() {
        /////////////////////////////////////////////////////////////////////
    }
    @Override
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




    @Override

    public void removeOldFeedbacks(List<Course> courses) {
    java.sql.Date currentDate = new java.sql.Date(0, 0, 0);
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, -1);
    java.sql.Date oneYearAgo = (java.sql.Date) calendar.getTime();

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

    @Override
    public void leaveFeedback(Course course, String description, int rating) {
        Feedback feedback = new Feedback(description, rating);
        course.addFeedback(feedback);
        System.out.println("Feedback left for course " + course.getName());
    }
}

