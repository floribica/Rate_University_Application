package src;

import java.util.List;

public interface Methods  {
    //duhet implementuar
    void Menu();        //duhet implementuar

    // FR2: Search for available courses and join or drop a course
    List<Course> searchAvailableCourses();
    void joinCourse(Student student, Course course);
    void dropCourse(Student student, Course course);
    // FR3: Check course details

    void dropCourse(Course course);

    void joinCourse(Course course);

    List<Course> getCourses();

    void displayCourseDetails();

}
