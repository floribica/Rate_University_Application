package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class MainApplication implements Methods {
    private static List<Student> studentList = new ArrayList<Student>();
    private static List<Course> Kurset = new ArrayList<Course>();
    //private Map<String, Feedback> courseFeedbackMap;
    private static Map<String, List<Course>> courseRegistrations = new HashMap<>();

    private int nr_Studenteve;
    private int nr_Kurseve;

    public static void main(String[] args) {
        MainApplication APP = new MainApplication();
        int zgjedhja = 0;
        Scanner input = new Scanner(System.in);
        int i = APP.Lexo_Studentet();  // ben leximin nga file i studenteve dhe kthen numrin e studenteve ne file
        int j = APP.lexo_Kurset();
        APP.setNumriStudenteve(i);
        //System.out.println("Studentet: "+APP.nr_Studenteve);
        String emri;
        String Id;
        String courseNa;
        String studentName;
        do {
            //shfaq menune
            APP.Menu();

            zgjedhja = input.nextInt();
            //Zgjedhja e opsioneve te menuse nga perdoruesi
            switch (zgjedhja) {

                case 1:
                    //ruan studentet ne nje file dhe shton nje student
                    APP.Shto_Student();
                    break;
                case 2:
                    for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext(); ) {
                        Student obj = iterator.next();
                        System.out.print("\nEmri:\t\t\t" + obj.getStudentName());
                        System.out.print("\nID e Studentit:\t\t" + obj.getStudentId());
                    }

                    break;
                case 3:
                    //shto kursin

                    Scanner scan = new Scanner(System.in);
                    String courseName;
                    Date date;
                    String courseDescription;
                    String lectureHallLocation;
                    String[] kurset = new String[10];

                    System.out.print("\nJepni Emrin e Kursit:\n\n ");
                    courseName = scan.nextLine();

                    System.out.print("\nJepni Autorin e Kursit:\n\n ");
                    String author = scan.nextLine();

                    System.out.print("\nJepni Kapacitetin e Kursit: \n\n");
                    int capacity = scan.nextInt();

                    scan.nextLine();
                    System.out.print("\nJepni klasen ne te cilen zhvillohet kursi: \n\n");
                     lectureHallLocation = scan.nextLine();

                    System.out.print("\nJepni pershkrimin e kursit: \n\n");
                     courseDescription = scan.nextLine();


                    System.out.print("\nJepni Fillimin e Dates se Kursit: (YY-MM-DD) ");
                    SimpleDateFormat dateForma = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = scan.nextLine();
                    Date date1 = null;
                    try {
                        date1 = dateForma.parse(dateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");

                    }

                    System.out.print("\nJepni Fundin e Dates se Kursit:(YY-MM-DD) ");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateSt = scan.nextLine();
                    Date date2 = null;
                    try {
                        date2 = dateFormat.parse(dateSt);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");

                    }


                    Course course = new Course(courseName, author, date1, date2, capacity, courseDescription, lectureHallLocation, kurset);
                    APP.Shto_Kurs(course);                        //shton nje gare ne liste
                    System.out.println("\n\tKursi u shtua me Sukses!\n\n");

                    break;

                case 4:
                    //fshin kursin

                    System.out.print("\nJepni emrin e kursit qe doni te fshini: ");
                    emri = input.next();
                    j = APP.dropCourse(emri, j);                //fshin shoferin me emrin e dhene nga perdoruesi nese ekziston dhe ull me nje nr e kurseve
                    break;

                case 5:
                    boolean isEmpty = APP.isFileEmpty("Kurset.txt");
                    if (isEmpty) {
                         System.out.println("Nuk ka kurs te rregjistruar!");

                        }
                    else {

                        APP.tableCourse();

                    }
                    //FR2: Search for available courses: A student can see all courses. He is able to join a course. He can also drop a
                    //course.
                    break;
                case 6:
                    //shfaq detajet e nje kursi
                    /*FR3: Check course details: A student can see details about a course such as a description of the course, the course
                    lecturer, the course times, the location of the lecture hall, and also the number of registered students.*/
                    Scanner in= new Scanner(System.in);
                    System.out.print("\nZgjidh nje kurs: ");
                    emri = input.next();						//shfaq statistikat per nje shofer
                    boolean ndodhet = false;
                    for (Iterator<Course> iterator = Kurset.iterator(); iterator.hasNext();) {
                        Course obj= iterator.next();
                        if (obj.getCourseName().equals(emri)) {
                            System.out.print("\nEmri:\t\t\t"+obj.getCourseName());
                            System.out.print("\nMbiemri:\t\t"+obj.getAuthor());
                            System.out.print("\nVenddodhja:\t\t"+obj.getCapacity());
                            System.out.print("\nMosha:\t\t\t"+obj.getStartDate());
                            System.out.print("\nEkipi:\t\t\t"+obj.getEndDate());
                            System.out.print("\nVendi Pare:\t\t"+obj.getCourseDescription());
                            System.out.print("\nVendi Dyte:\t\t"+obj.getLectureHallLocation());
                            ndodhet = true;
                        }
                    }
                    if(!ndodhet) {
                        System.err.println("\n\tKursi "+emri+" nuk ndodhet ne Liste!\n");
                    }

                    break;

                case 7:
                    //FR4: Leave feedback: The student can leave feedback for a course. The feedback consists of a description (not
                    //more than 1000 characters) and a rating (from 1 to 5). It is possible only to leave feedback for the courses where
                    //the student is already registered. A student can only leave one feedback for a course.
                    /*Scanner in= new Scanner(System.in);
                    System.out.print("\nZgjidh nje kursID: ");
                    APP.tableCourse();
                    String courseDescriptionn=in.next();
                    if(courseDescriptionn.length()>=1000){
                        System.out.println("Jo me shume se 1000 characters");}
                    else {
                        System.out.println("Jepni nje Rate nga 1-5");
                        int rate=in.nextInt();
                        APP.leaveFeedback(String courseName, String courseDescriptionn, int rating);
                    }

                    APP.leaveFeedback(String courseName, String courseDescriptionn, int rating);*/
                    System.out.print("\nZgjidh nje kursID per ta vleresuar ate kurs: ");
                    APP.tableCourse();

                    System.out.println("Enter feedback description (not more than 1000 characters):");
                    Scanner scanner= new Scanner(System.in);
                    String courseDescriptionn=scanner.next();
                    System.out.println("Jepni emrin e kursit qe doni te shtoni:");
                    String courseN=scanner.nextLine();

                    try {
                        APP.validateDescriptionLength(courseDescriptionn);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        return;  // Exit the program if the description is too long
                    }

                    // Get user input for rating
                    System.out.println("Enter feedback rating (1 to 5):");
                    int rate = scanner.nextInt();

                    // Validate rating
                    try {
                        APP.validateRating(rate);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        return;  // Exit the program if the rating is invalid
                    }

                    // Continue processing feedback...
                    System.out.println("Feedback submitted successfully!");
                    APP.leaveFeedback(courseN,courseDescriptionn,rate);
                    break;

                case 8:
                    Scanner nu=new Scanner(System.in);
                    System.out.println("Jepni emrin e kursit ne te cilin do shtoni studentin!\n");
                     courseNa=nu.next();
                    System.out.println("Jepni Studentin(ID-e tij) te cilin doni te shtoni! \n");
                    nu.nextLine();
                    studentName=nu.nextLine();
                    boolean studentFound = false;
                    for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext();) {
                        Student obj1= iterator.next();
                        if (obj1.getStudentName().equals(studentName)) {
                            APP.registerStudent(courseNa,obj1);
                            studentFound = true;
                            System.out.println("Studenti u rregjistrua te kursi me sukses");
                            break;
                        }
                    }
                    if(!studentFound) {
                        System.err.println("\n\tStudenti "+studentName+" nuk ndodhet ne Liste!\n");
                    }


                 break;


                default:
                    System.out.println("\nInput i gabuar. Provo perseri !\n\n");
                    break;
            }
        } while (zgjedhja != 0);
    }

      @Override
      public void validateDescriptionLength(String description) {
          if (description.length() > 1000) {
              throw new IllegalArgumentException("Jo më shumë se 1000 fjalë është e lejuar.");
          }
      }
      @Override
      public void validateRating(int rating) {
          if (rating < 1 || rating > 5) {
              throw new IllegalArgumentException("Rating should be between 1 and 5.");
          }
      }
    @Override
    public void Shto_Student() {
        Scanner scan = new Scanner(System.in);
        String studentName;
        String studentId;

        boolean ekziston = false;

        Student student = new Student();

        System.out.print("\nJepni emrin e studentit qe doni te shtoni: ");
        studentName = scan.nextLine();
        System.out.print("\nJepni ID e studenit qe doni te shtoni: ");
        studentId = scan.nextLine();

        try {
            for (Iterator<Student> iterator = studentList.iterator(); iterator.hasNext(); ) {
                Student obj = iterator.next();
                if (obj.getStudentName().equals(studentName) || obj.getStudentId().equals(studentId)) {
                    ekziston = true;
                    throw new Exception("\n\tEkziston nje student me kete emer!\n");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        if (!ekziston) {
            student.setStudentId(studentId);  // Set studentId directly or use a setter method
            student.setStudentName(studentName);  // Set studentName directly or use a setter method
            studentList.add(student);
            this.nr_Studenteve += 1;
            ruaj_Studentet();
            System.out.println(studentList);
        }
    }
    @Override
    public void registerStudent(String courseName, Student student) {
        // Check if the course exists in the registrations map
        if (courseRegistrations.containsKey(courseName)) {
            // If the course exists, add the student to the list of registered students for that course
            List<Course> courses = courseRegistrations.get(courseName);
            courses.add(findCourse(courseName));
            studentList.add(student);

        } else {
            // If the course doesn't exist, create a new entry with an empty list of courses
            List<Course> newCourseList = new ArrayList<>();
            newCourseList.add(findCourse(courseName)); // Assuming findCourse returns a Course object
            courseRegistrations.put(courseName, newCourseList);
            studentList.add(student);
        }
    }

    @Override

    public Course findCourse(String courseName) {
        // Assuming you have a method to find a course by name in the Kurset list
        for (Course cours : Kurset) {
            if (cours.getCourseName().equals(courseName)) {
                return cours;
            }
        }
        return null;
    }




    @Override
    public int dropCourse(String emri, int nrKurseve) {
        boolean isCourse = false;
        for (Iterator<Course> iterator = Kurset.iterator(); iterator.hasNext(); ) {
            Course obj = iterator.next();
            if (obj.getCourseName().equals(emri)) {
                isCourse = true;
            }
        }

        if (isCourse) {
            for (Iterator<Course> iterator = Kurset.iterator(); iterator.hasNext(); ) {
                Course obj = iterator.next();
                if (obj.getCourseName().equals(emri)) {
                    iterator.remove();
                }
            }
            System.out.println("\n\tKursi " + emri + " u fshi nga lista!!\n\n");
            nr_Kurseve--;
            ruaj_Kurset();
        } else if (!isCourse)
            System.err.println("\n\tNuk ekziston asnje Kurs me emrin " + emri + "!\n\n");
        return nrKurseve;
    }

    @Override
    public void Shto_Kurs(Course course) {

        Kurset.add(course);
        ruaj_Kurset();
        this.nr_Kurseve += 1;
        for (Course cour : Kurset) {
            courseRegistrations.put(cour.getCourseName(), new ArrayList<>());
        }
    }


    @Override
    public int Lexo_Studentet() {
        boolean cont = true;
        int i = 0;
        try {
            ObjectInputStream lexo = new ObjectInputStream(new FileInputStream("Studentet.txt"));
            while (cont) {
                Object obj = null;
                try {
                    obj = lexo.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException e) {
                    break;
                }

                if (obj != null) {
                    studentList.add((Student) obj);
                    i++;
                } else {
                    cont = false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public void ruaj_Kurset() {
        emptyKurset();
        try {
            FileOutputStream ruaj = new FileOutputStream("Kurset.txt", true);
            try {
                ObjectOutputStream ruajKurs = new ObjectOutputStream(ruaj);
                for (Object o : Kurset) {
                    try {
                        ruajKurs.writeObject(o);

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
    public void ruaj_Studentet() {
        empty();
        try {
            FileOutputStream ruaj = new FileOutputStream("Studentet.txt", true);
            try {
                ObjectOutputStream ruajStudent = new ObjectOutputStream(ruaj);
                for (Object obj : studentList) {
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

    public int getNumriShofereve() {
        //	System.out.println("nr studenteve "+nr_Studenteve);
        return nr_Studenteve;
    }

    public void setNumriStudenteve(int nr) {
        this.nr_Studenteve = nr;
    }

    public List<Student> getStudentet() {
        return this.studentList;
    }

    @Override
    public void Menu() {
        System.out.print("\n\n--------------------*****Menuja*****--------------------\n\n"
                + "1 --> Shto nje student\n"
                + "2 --> Shfaq Studentet\n"
                + "3 -->  Shto Kursin\n"
                + "4 -->  Fshi nje Kurs \n"
                + "5 -->  Shfaq Kurset\n"
                + "6 --> Shfaq detajet e nje kursi\n"
                + "7 --> Leave a Feedback\n"
                + "8 --> Register a Student to Course\n"
                + "0 --> Dil\n\n"
                + "Zgjedhja: ");
    }

    @Override
    public void empty() {
        File file = new File("Studentet.txt");
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leaveFeedback(String courseName, String description, int rating) {

    }

    @Override
    public int lexo_Kurset() {
        boolean cont = true;
        int j = 0;
        try {
            ObjectInputStream lexo = new ObjectInputStream(new FileInputStream("Kurset.txt"));
            while (cont) {
                Object obj = null;
                try {
                    obj = lexo.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException e) {
                    break;
                }

                if (obj != null) {
                    Kurset.add((Course) obj);
                    j++;
                } else {
                    cont = false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return j;
    }

    @Override
    public boolean isFileEmpty(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Kurset.txt"))) {
            String line = reader.readLine();

            // Check if there is at least one line
            if (line == null) {
                return true;
            }
            // If there is content, return a message indicating it
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void emptyKurset() {
        File file = new File("Kurset.txt");
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isStudentRegistered(String courseName, String studentId) {
        return false;
    }

    @Override
    public void tableCourse() {
        // Provide implementation for the tableCourse method

            System.out.println("Tabla e Kurseve:");
            for (Iterator<Course> iterator = Kurset.iterator(); iterator.hasNext(); ) {
                Course obj = iterator.next();
                System.out.print("\nTitulli i Kursit:\t\t\t" + obj.getCourseName());
                System.out.print("\nAutori i Kursit:\t\t" + obj.getAuthor());
                System.out.print("\nKapaciteti i Kursit:\t\t" + obj.getCapacity());
                System.out.print("\nFillimi i Kursit:\t\t" + obj.getStartDate());
                System.out.print("\nFundi i Kursit:\t\t" + obj.getEndDate());
                System.out.print("\nPershkrimi  i Kursit:\t\t" + obj.getCourseDescription());
                System.out.print("\nVendi ku zhvillohet Kursi:\t\t" + obj.getLectureHallLocation());
               // duhet implementuar feedback System.out.println("\nFeedback i ketij kursi eshte:\t\t" +obj.)
            }
        }


    }

