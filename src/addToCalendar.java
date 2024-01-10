
package src;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addToCalendar {


    public static void generate() {
        generateCalendarFile();
    }

    private static void generateCalendarFile() {
        // SimpleDateFormat for parsing and formatting dates
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");

        CoursesDetails coursesDetails = new CoursesDetails();
        String[][] courses = coursesDetails.courses;

        // Output file path
        String filePath = "Rate_University_Application/src/course_schedule.ics";

        // Create a StringBuilder to store the iCalendar data
        StringBuilder icalData = new StringBuilder();

        // iCalendar header
        icalData.append("BEGIN:VCALENDAR\n");
        icalData.append("VERSION:2.0\n");
        icalData.append("PRODID:-//Your Organization//Your App//EN\n");

        // Loop through courses and add events
        for (String[] course : courses) {
            try {
                // Extract start and end dates from the course array
                String[] dateRange = course[2].split("-");
                Date startDate = inputDateFormat.parse(dateRange[0]);
                Date endDate = inputDateFormat.parse(dateRange[1]);

                icalData.append("BEGIN:VEVENT\n");
                icalData.append("SUMMARY:" + course[0] + " - " + course[1] + "\n");
                icalData.append("DTSTART:" + outputDateFormat.format(startDate) + "\n");
                icalData.append("DTEND:" + outputDateFormat.format(endDate) + "\n");
                icalData.append("DESCRIPTION:" + course[3] + "\n");
                icalData.append("LOCATION:" + "Classroom " + course[1].substring(course[1].lastIndexOf(' ') + 1) + "\n");
                icalData.append("END:VEVENT\n");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // iCalendar footer
        icalData.append("END:VCALENDAR");

        // Write the iCalendar data to file
        try {
            Path path = Paths.get(filePath);
            FileWriter fileWriter = new FileWriter(path.toString());
            fileWriter.write(icalData.toString());
            fileWriter.close();
            System.out.println("Calendar file generated: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
