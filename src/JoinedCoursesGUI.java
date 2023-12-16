package src;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinedCoursesGUI extends JFrame {
    private Map<String, CourseDetails> courseDetailsMap;
    private Map<String, Boolean> joinedCoursesMap;

    public JoinedCoursesGUI(List<String> joinedCourses) {
        setTitle("Your Joined Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initializeCourseDetails();
        initializeJoinedCoursesMap(joinedCourses);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Navigation Bar
        JPanel navBarPanel = new JPanel();
        navBarPanel.setBackground(Color.DARK_GRAY);
        navBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton homeButton = createNavBarButton("Home");
        JButton calendarButton = createNavBarButton("Calendar");
        JButton logoutButton = createNavBarButton("Log Out");

        navBarPanel.add(homeButton);
        navBarPanel.add(calendarButton);
        navBarPanel.add(logoutButton);

        mainPanel.add(navBarPanel, BorderLayout.NORTH);

        // Header Panel
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Your Joined Courses");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        mainPanel.add(headerPanel, BorderLayout.CENTER);

        JPanel coursePanel = new JPanel(new GridLayout(4, 2, 20, 20));

        for (String course : joinedCourses) {
            CourseDetails details = courseDetailsMap.get(course);
            if (details != null) {
                JPanel courseCard = createCourseCard(course, details);
                coursePanel.add(courseCard);
            }
        }

        JScrollPane scrollPane = new JScrollPane(coursePanel);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JButton createNavBarButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setFocusPainted(false);
        button.addActionListener(e -> handleNavBarButtonClick(text));
        return button;
    }

    private void handleNavBarButtonClick(String buttonName) {
        JOptionPane.showMessageDialog(this, "You clicked: " + buttonName);
        // Implement navigation logic based on the button clicked
    }

    private JPanel createCourseCard(String courseName, CourseDetails details) {
        JPanel courseCard = new JPanel(new BorderLayout());
        courseCard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JLabel courseLabel = new JLabel(courseName);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 18));
        courseCard.add(courseLabel, BorderLayout.NORTH);

        JTextArea detailsArea = new JTextArea();
        detailsArea.append("Author: " + details.getAuthor() + "\n");
        detailsArea.append("Capacity: " + details.getCapacity() + "\n");
        detailsArea.append("Start Date: " + details.getStartDate() + "\n");
        detailsArea.append("End Date: " + details.getEndDate() + "\n");
        detailsArea.setEditable(false);

        courseCard.add(detailsArea, BorderLayout.CENTER);

        return courseCard;
    }

    private void initializeCourseDetails() {
        // Initialize course details map with sample data
        courseDetailsMap = new HashMap<>();
        courseDetailsMap.put("Computer Science", new CourseDetails("John Doe", 30, "2023-01-15", "2023-05-15"));
        courseDetailsMap.put("Physics", new CourseDetails("Jane Smith", 25, "2023-01-20", "2023-05-20"));
        courseDetailsMap.put("Mathematics", new CourseDetails("Bob Johnson", 20, "2023-01-25", "2023-05-25"));
        courseDetailsMap.put("History", new CourseDetails("Alice Brown", 22, "2023-02-01", "2023-06-01"));
    }

    private void initializeJoinedCoursesMap(List<String> joinedCourses) {
        joinedCoursesMap = new HashMap<>();
        for (String course : joinedCourses) {
            joinedCoursesMap.put(course, true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<String> joinedCourses = List.of("Computer Science", "Mathematics");
            JoinedCoursesGUI joinedCoursesGUI = new JoinedCoursesGUI(joinedCourses);
            joinedCoursesGUI.setVisible(true);

            System.out.println("JoinedCoursesGUI created and set visible.");
        });
    }

    private static class CourseDetails {
        private String author;
        private int capacity;
        private String startDate;
        private String endDate;

        public CourseDetails(String author, int capacity, String startDate, String endDate) {
            this.author = author;
            this.capacity = capacity;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public String getAuthor() {
            return author;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }
    }
}
