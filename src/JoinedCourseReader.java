package src;

public class JoinedCourseReader {
    //create a method to read the joined course
    public static String[] course(String course) {
        String[] courseInfo = course.split("◊");
        return courseInfo;
    }
}
