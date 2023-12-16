package src;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private  String author;
    private  String courseName;
    private int capacity;
    private Date startDate;
    private Date endDate;
    private String courseDescription;
    private String lectureHallLocation;

    private String[] kurset = new String[20];

    Course() {

    }
    Course(String courseName){
        this.courseName=courseName;
    }
    public Course(String courseName, String  author, Date startDate, Date endDate, int capacity,String courseDescription, String lectureHallLocation, String[] kurset) {
        super();
        this.courseName =courseName ;
        this.author =author ;
        this.startDate=startDate ;
        this.endDate=endDate;
        this.capacity=capacity;
        this.courseDescription=courseDescription;
        this.lectureHallLocation = lectureHallLocation;
        this.kurset=kurset;

    }
    public String[] kurset() {
        return kurset;
    }
    public void setKurset(String[] kurset) {
        this.kurset = kurset;
    }

    public String getAuthor() {
        return author;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public Date getStartDate() {
        return startDate;
    }
    public String getCourseDescription(){return courseDescription;}
    public String getLectureHallLocation(){return lectureHallLocation;}
    public void setCourseDescription(String courseDescription){this.courseDescription=courseDescription;}
    public void setLectureHallLocation(String lectureHallLocation){this.lectureHallLocation=lectureHallLocation;}

    public Date getEndDate() {
        return endDate;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setCourseName(String courseName){
        this.courseName=courseName;
    }
    public void setStartDate(Date startDate){
        this.startDate=startDate;
    }
    public void setEndDate(Date endDate){
        this.endDate=endDate;
    }
    public void setCapacity(int i) {
        this.capacity=i;
    }



    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("| %-10s | %-18s | %-8d | %-13s | %-13s | | %-13s | | %-13s |",
                getAuthor(), getCourseName(), getCapacity(),
                dateFormat.format(getStartDate()), dateFormat.format(getEndDate()),getCourseDescription(),getLectureHallLocation());
    }


}

