package src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Student {
    private String studentName;
    private String studentId; // Assuming you have a student ID

    public Student() {
        this.studentName = studentName;
    }

    public Student(String name, String id) {
        this.studentName = name;
        this.studentId = id;
    }

    public String getName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public static void writeStudentsToCSV(List<Student> students, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.println(student.getStudentId()); // Use the actual method to get student ID
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
