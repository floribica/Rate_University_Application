package src;
public interface Methods  {
    void tableCourse();    //duhet implementuar
    void Menu();        //duhet implementuar
    void Shto_Student();   //u implementua
     int dropCourse(String emri, int nrKurseve);
     void Shto_Kurs(Course course); // duhet implementuar   //u implementua
     void ruaj_Kurset();
     int lexo_Kurset();
    int Lexo_Studentet();  //u implementua
    void ruaj_Studentet();   //u implementua
    void empty();
    void emptyKurset();
    boolean isFileEmpty(String filePath);// u implementua
   // public void detailCourse(String comments,String author,int date,String location,int Students_Id);

}
