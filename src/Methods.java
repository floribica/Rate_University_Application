package src;
public interface Methods  {
    void tableCourse();    //duhet implementuar
    void Menu();        //duhet implementuar
    void Shto_Student();   //u implementua
     int dropCourse(String emri, int nrKurseve);
    void dropCourse(String courseName, Student student);
    void Shto_Kurs(Course course); // duhet implementuar   //u implementua
     void ruaj_Kurset();
     int lexo_Kurset();
     void increaseCapacity();
     void decreaseCapacity();
    int Lexo_Studentet();  //u implementua
    void ruaj_Studentet();   //u implementua
    void empty();
    void leaveFeedback(String courseName, String description, int rating);///////////////////////////////
    void registerStudent(String courseName, Student student);///////////////////////////
    void emptyKurset();
    boolean isStudentRegistered(String courseName, String studentId);/////////////////////////////
    boolean isFileEmpty(String filePath);// u implementua
    void validateDescriptionLength(String description);
     void validateRating(int rating);
    Course findCourse(String courseName);
    // public void detailCourse(String comments,String author,int date,String location,int Students_Id);

}
