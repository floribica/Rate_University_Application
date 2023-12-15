package src;

import javax.swing.*;
import java.awt.*;

public class NavBarPanel extends JPanel {
    public NavBarPanel() {
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
}
