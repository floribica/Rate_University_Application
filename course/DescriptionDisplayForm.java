package course;

import javax.swing.*;
import java.awt.*;

public class DescriptionDisplayForm extends JFrame {

    public DescriptionDisplayForm(String courseName, String description) {
        initComponents(courseName, description);
    }

    private void initComponents(String courseName, String description) {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setPreferredSize(new Dimension(500, 300));
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        add(descriptionPanel);

        JLabel courseNameLabel = new JLabel(courseName);
        courseNameLabel.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        courseNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionPanel.add(courseNameLabel);

        JTextArea descriptionTextArea = new JTextArea(description);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        descriptionTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionPanel.add(descriptionTextArea);

        pack();
        setLocationRelativeTo(null);
    }

    public static void showDescription(String courseName, String description) {
        DescriptionDisplayForm descriptionDisplayForm = new DescriptionDisplayForm(courseName, description);
        descriptionDisplayForm.setVisible(true);
    }
}
