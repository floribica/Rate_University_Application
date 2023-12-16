package src;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseGUI extends JFrame {
    private Map<String, CourseDetails> courseDetailsMap;
    private Map<String, Boolean> joinedCoursesMap;

    public CourseGUI(List<String> courses) {
        setTitle("University Course Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initializeCourseDetails();
        initializeJoinedCoursesMap(courses);

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
        JLabel headerLabel = new JLabel("Available Courses");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        mainPanel.add(headerPanel, BorderLayout.CENTER);

        JPanel coursePanel = new JPanel(new GridLayout(4, 2, 20, 20));

        for (String course : courses) {
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

        JPanel buttonPanel = new JPanel();
        JButton joinButton = new JButton("Join");
        JButton dropButton = new JButton("Drop");

        if (joinedCoursesMap.getOrDefault(courseName, false)) {
            joinButton.setEnabled(false);
        }

        joinButton.addActionListener(e -> handleJoinButton(courseName));
        dropButton.addActionListener(e -> handleDropButton(courseName));

        buttonPanel.add(joinButton);
        buttonPanel.add(dropButton);

        courseCard.add(detailsArea, BorderLayout.CENTER);
        courseCard.add(buttonPanel, BorderLayout.SOUTH);

        return courseCard;
    }

    private void handleJoinButton(String courseName) {
        joinedCoursesMap.put(courseName, true);
        JOptionPane.showMessageDialog(this, "Joined course: " + courseName);
        refreshCoursePanel();
    }

    private void handleDropButton(String courseName) {
        joinedCoursesMap.put(courseName, false);
        JOptionPane.showMessageDialog(this, "Dropped course: " + courseName);
        refreshCoursePanel();
    }

    private void refreshCoursePanel() {
        // Refresh the course panel after joining or dropping a course
        getContentPane().removeAll();
        List<String> courses = List.of("Computer Science", "Physics", "Mathematics", "History");
        initializeJoinedCoursesMap(courses);
        createAndShowGUI(courses);
    }

    private void initializeCourseDetails() {
        // Initialize course details map with sample data
        courseDetailsMap = new HashMap<>();
        courseDetailsMap.put("Computer Science", new CourseDetails("John Doe", 30, "2023-01-15", "2023-05-15"));
        courseDetailsMap.put("Physics", new CourseDetails("Jane Smith", 25, "2023-01-20", "2023-05-20"));
        courseDetailsMap.put("Mathematics", new CourseDetails("Bob Johnson", 20, "2023-01-25", "2023-05-25"));
        courseDetailsMap.put("History", new CourseDetails("Alice Brown", 22, "2023-02-01", "2023-06-01"));
    }

    private void initializeJoinedCoursesMap(List<String> courses) {
        joinedCoursesMap = new HashMap<>();
        for (String course : courses) {
            joinedCoursesMap.put(course, false);
        }
    }

    private void createAndShowGUI(List<String> courses) {
        CourseGUI courseGUI = new CourseGUI(courses);
        courseGUI.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                List<String> courses = List.of("Computer Science", "Physics", "Mathematics", "History");

                CourseGUI courseGUI = new CourseGUI(courses);
                courseGUI.setVisible(true);

                System.out.println("GUI created and set visible.");
            }
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
