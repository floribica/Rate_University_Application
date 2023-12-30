package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavBarPanel extends JPanel {
    private JFrame parentFrame;

    public NavBarPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setBackground(Color.DARK_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton homeButton = createNavBarButton("Home");
        JButton calendarButton = createNavBarButton("Calendar");
        JButton logoutButton = createNavBarButton("Log Out");

        add(homeButton);
        add(calendarButton);
        add(logoutButton);
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
