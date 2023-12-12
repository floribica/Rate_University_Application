import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

class Course {
    private String author;
    private String courseName;
    private int capacity;
    private Date startDate;
    private Date endDate;

    public Course(String author, String courseName, int capacity, Date startDate, Date endDate) {
        this.author = author;
        this.courseName = courseName;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
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

