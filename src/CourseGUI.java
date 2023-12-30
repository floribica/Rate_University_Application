package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import src.NavBarPanel;

public class CourseGUI extends JFrame {
    private List<String> userAddedCourses;

    public CourseGUI() {
        setTitle("User Added Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        userAddedCourses = new ArrayList<>();

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Navigation Bar
        JPanel navBarPanel = new NavBarPanel(this);  // Assuming you have a NavBarPanel class
        mainPanel.add(navBarPanel, BorderLayout.NORTH);

        // Header Panel
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("User Added Courses");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        mainPanel.add(headerPanel, BorderLayout.CENTER);

        // Panel for adding courses
        JPanel addCoursePanel = new JPanel(new FlowLayout());
        JTextField courseField = new JTextField(20);
        JButton addButton = new JButton("Add Course");
        addButton.addActionListener(e -> {
            String course = courseField.getText().trim();
            if (!course.isEmpty()) {
                userAddedCourses.add(course);
                updateCoursePanel(mainPanel);
                courseField.setText("");
            }
        });

        addCoursePanel.add(courseField);
        addCoursePanel.add(addButton);

        mainPanel.add(addCoursePanel, BorderLayout.SOUTH);

        updateCoursePanel(mainPanel);

        add(mainPanel);
    }

    private void updateCoursePanel(JPanel mainPanel) {
        JPanel coursePanel = new JPanel(new GridLayout(userAddedCourses.size(), 2, 20, 20));

        for (String course : userAddedCourses) {
            JPanel courseCard = createCourseCard(course);
            coursePanel.add(courseCard);
        }

        JScrollPane scrollPane = new JScrollPane(coursePanel);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private JPanel createCourseCard(String courseName) {
        JPanel courseCard = new JPanel(new BorderLayout());
        courseCard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JLabel courseLabel = new JLabel(courseName);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 18));
        courseCard.add(courseLabel, BorderLayout.NORTH);

        return courseCard;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CourseGUI courseGUI = new CourseGUI();
            courseGUI.setVisible(true);

            System.out.println("CourseGUI created and set visible.");
        });
    }
}
