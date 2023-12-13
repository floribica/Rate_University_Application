package src;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainApplication implements Methods {
    private static List<Student> studentList = new ArrayList<Student>();
    private int nr_Studenteve;

    public static void main(String[] args) {
        MainApplication APP = new MainApplication();
        int zgjedhja = 0;
        Scanner input = new Scanner(System.in);
        int i = APP.Lexo_Studentet();  // ben leximin nga file i studenteve dhe kthen numrin e studenteve ne file

        APP.setNumriStudenteve(i);
        //System.out.println("Studentet: "+APP.nr_Studenteve);
        String emri;
        String Id;
        do {
            //shfaq menune
            APP.Menu();

            zgjedhja = input.nextInt();
            //Zgjedhja e opsioneve te menuse nga perdoruesi
            switch (zgjedhja) {

                case 1:
                    APP.Shto_Student();
                    break;
                case 2:                //ruan shoferet ne nje file
                    APP.ruaj_Studentet();
                    break;
                case 3:
                    //shto kursin

                    break;
                case 4:
                    //ruaj kursin
                    break;
                default:
                    System.out.println("\nInput i gabuar. Provo perseri !\n\n");
                    break;
            }
        } while (zgjedhja != 0);
    }




    @SuppressWarnings("resource")
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
    public void Shto_Kurs(Course course) {

        Kurset.add(course);
        ruaj_Kurset();            ////////////////////////////////DUHET IMPLEMENTUAR///////////////////
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
        this.nr_Studenteve=nr;
    }
    public List<Student> getStudentet(){
        return this.studentList;
    }
    @Override
    public void Menu() {
        System.out.print("\n\n--------------------*****Menuja*****--------------------\n\n"
                + "1 --> Shto nje student\n"
                + "2 --> Ruaj Student \n"
                + "3 -->  Shto Kursin\n"
                + "4 -->  Ruaj Kursin\n"
                + "5 -->  \n"
                + "6 --> \n"
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
    public void tableCourse() {
        // Provide implementation for the tableCourse method
        System.out.println("Implementation for tableCourse method");
    }

}
