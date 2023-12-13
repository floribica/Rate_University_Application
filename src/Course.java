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

    private String[] Kurset = new String[10];

    Course() {

    }
    public Course(String courseName,String  author,  Date startDate,Date endDate,int capacity, String[] Kurset) {
        super();
        this.courseName =courseName ;
        this.author =author ;
        this.startDate=startDate ;
        this.endDate=endDate;
        this.capacity=capacity;
        this.Kurset=Kurset;

    }
    public String[] Kurset() {
        return Kurset;
    }
    public void setKurset(String[] Kurset) {
        this.Kurset = Kurset;
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
        return String.format("| %-10s | %-18s | %-8d | %-13s | %-13s |",
                getAuthor(), getCourseName(), getCapacity(),
                dateFormat.format(getStartDate()), dateFormat.format(getEndDate()));
    }


}

