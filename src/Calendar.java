package src;

public class Calendar {

    //open "Rate_University_Application/src/course_schedule.ics"
    public static void openCalendar() {
        try {
            Runtime.getRuntime().exec("open Rate_University_Application/src/course_schedule.ics");
        } catch (Exception e) {
            System.out.println("Error opening calendar");
        }
    }
}
