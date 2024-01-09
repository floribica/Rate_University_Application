package src;

import javax.swing.*;
import java.awt.*;

public class RatingDisplayForm extends JFrame {

    public RatingDisplayForm(String courseName, String rating) {
        initComponents(courseName, rating);
    }

    private void initComponents(String courseName, String rating) {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel ratingPanel = new JPanel();
        ratingPanel.setPreferredSize(new Dimension(300, 200));
        ratingPanel.setLayout(new BoxLayout(ratingPanel, BoxLayout.Y_AXIS));
        add(ratingPanel);

        JLabel courseNameLabel = new JLabel(courseName);
        courseNameLabel.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        courseNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingPanel.add(courseNameLabel);

        JLabel ratingLabel = new JLabel("Rating: " + rating);
        ratingLabel.setFont(new Font("Hannotate TC", Font.PLAIN, 18));
        ratingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingPanel.add(ratingLabel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void showRating(String courseName, String rating) {
        RatingDisplayForm ratingDisplayForm = new RatingDisplayForm(courseName, rating);
        ratingDisplayForm.setVisible(true);
    }
}
