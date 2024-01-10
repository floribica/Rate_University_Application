package course;

public class Feedback {
    private String description;
    private int rating;


    public Feedback(String description, int rating ) {
        this.description = description;
        this.rating = rating;

    }

    // Getter methods
    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }






    // Setter methods
    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }




//    @Override
//    public String toString() {
//        return "Feedback{" +
//                "description='" + description + '\'' +
//                ", rating=" + rating +
//                ", creationDate=" + creationDate +
//                ", studentId='" + studentId + '\'' +
//                ", courseId='" + courseId + '\'' +
//                '}';
//    }
//
}
