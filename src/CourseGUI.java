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

        // Header Panel
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Available Courses");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel coursePanel = new JPanel(new GridLayout(0, 2, 20, 20));

        for (String course : courses) {
            CourseDetails details = courseDetailsMap.get(course);
            if (details != null) {
                JPanel courseCard = createCourseCard(course, details);
                coursePanel.add(courseCard);
            }
        }

        JScrollPane scrollPane = new JScrollPane(coursePanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JPanel createCourseCard(String courseName, CourseDetails details) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        card.setBackground(new Color(255, 223, 186)); // Moccasin

        // Add some padding
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nameLabel = new JLabel(courseName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(nameLabel);

        JLabel authorLabel = new JLabel("Author: " + details.getAuthor());
        JLabel capacityLabel = new JLabel("Capacity: " + details.getCapacity());
        JLabel startDateLabel = new JLabel("Start Date: " + details.getStartDate());
        JLabel endDateLabel = new JLabel("End Date: " + details.getEndDate());

        // Center the information
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        capacityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        endDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(authorLabel);
        card.add(capacityLabel);
        card.add(startDateLabel);
        card.add(endDateLabel);

        JButton joinButton = new JButton("Join Course");
        JButton dropButton = new JButton("Drop Course");

        joinButton.setBackground(new Color(50, 205, 50)); // Lime Green
        dropButton.setBackground(new Color(255, 69, 0)); // Red-Orange

        // Add some spacing between buttons and information
        card.add(Box.createRigidArea(new Dimension(0, 10)));

        // Disable Join button if already joined
        if (joinedCoursesMap.get(courseName)) {
            joinButton.setEnabled(false);
        } else {
            joinButton.addActionListener(e -> handleCourseAction("Joined", courseName, joinButton, dropButton));
        }

        // Disable Drop button if not joined
        dropButton.setEnabled(joinedCoursesMap.get(courseName));
        dropButton.addActionListener(e -> handleCourseAction("Dropped", courseName, joinButton, dropButton));

        card.add(joinButton);
        card.add(dropButton);

        return card;
    }

    private void handleCourseAction(String action, String courseName, JButton joinButton, JButton dropButton) {
        int response = JOptionPane.showConfirmDialog(this,
                "Do you want to " + action.toLowerCase() + " the course: " + courseName + "?",
                "Confirmation", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            if (action.equals("Joined")) {
                joinedCoursesMap.put(courseName, true);
                joinButton.setEnabled(false); // Disable Join button after joining
            } else if (action.equals("Dropped")) {
                joinedCoursesMap.put(courseName, false);
                dropButton.setEnabled(false); // Disable Drop button after dropping
            }

            JOptionPane.showMessageDialog(this, action + " course: " + courseName);
        }
    }

    private void initializeCourseDetails() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<String> courses = List.of("Computer Science", "Physics", "Mathematics", "History");

            CourseGUI courseGUI = new CourseGUI(courses);
            courseGUI.setVisible(true);
        });
    }
}

