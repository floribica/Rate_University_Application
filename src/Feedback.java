package src;

import java.util.Date;

class Feedback {
    private Date date;
    private String description;
    private int rating;

    public Feedback(String date, String description, int rating) {
        this.date = new Date();
        this.description = description;
        this.rating = rating;
    }



    public Feedback(String description2, int rating2) {
        this.description = description;
        this.rating = rating;
    }



    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
}


