package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.MainApplication.addCourse;

public class NavBarPanel extends JPanel {
    private JFrame parentFrame;
    private JFrame frame;
    private JTextField titleField;
    private JTextField descripField;
    private JTextField author1Field;
    private JTextField dateStringField;
    private JTextField locateField;

    public NavBarPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setBackground(Color.DARK_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Initialize text fields
        titleField = new JTextField();
        descripField = new JTextField();
        author1Field = new JTextField();
        dateStringField = new JTextField();
        locateField = new JTextField();

        JButton homeButton = createNavBarButton("Home");
        JButton calendarButton = createNavBarButton("Calendar");
        JButton addButton = new JButton("Add Course");
        JButton logoutButton = createNavBarButton("Log Out");

        add(homeButton);
        add(calendarButton);
        add(logoutButton);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input from GUI components
                String title = titleField.getText();
                String descrip = descripField.getText();
                String author1 = author1Field.getText();
                String dateString = dateStringField.getText();
                String locate = locateField.getText();

                // Call the addCourse method
                addCourse(title, descrip, author1, dateString, locate);
            }
        });
    }

    private JButton createNavBarButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setFocusPainted(false);
        // Add action listener if needed
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame parentFrame = new JFrame("Parent Frame");
            parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            parentFrame.setSize(800, 600);
            parentFrame.setLocationRelativeTo(null);

            NavBarPanel navBarPanel = new NavBarPanel(parentFrame);
            parentFrame.add(navBarPanel);

            parentFrame.setVisible(true);
        });
    }
}
