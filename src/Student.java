package src;
import java.io.Serializable;
public class Student extends StudentAbstract implements Serializable {
    private String studentId;
    private String studentName;

    public Student() {
        super();
    }

    public Student(String studentId, String studentName) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String Id){
        this.studentId=Id;
    }
    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Student Name: " + studentName;
    }
}
