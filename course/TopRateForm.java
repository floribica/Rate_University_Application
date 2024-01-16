package course;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static course.TopRateCourse.getTop5RateCourse;
import static course.TopRateCourse.getTopRateCourse;

public class TopRateForm extends JFrame {

    private static final String FONT_NAME = "Hannotate TC";
    private static final int FONT_SIZE = 20;

    public void showTopRateCourse(ArrayList<String> courseNames) {
        JFrame frame = new JFrame();
        frame.setTitle("Top Rate Courses");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JPanel topRatePanel = new JPanel();
        topRatePanel.setPreferredSize(new Dimension(300, 200));
        topRatePanel.setLayout(new BoxLayout(topRatePanel, BoxLayout.Y_AXIS));
        frame.add(topRatePanel);

        for (String cn : courseNames) {
            JLabel courseNameLabel = new JLabel();
            courseNameLabel.setText(cn);
            courseNameLabel.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
            courseNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            topRatePanel.add(courseNameLabel);
        }

        frame.setVisible(true);
    }

    public void rateCourse() {
        SwingUtilities.invokeLater(() -> {
            TopRateForm topRateForm = new TopRateForm();
            ArrayList<String> courseNames = getTop5RateCourse();


            if (courseNames != null && !courseNames.isEmpty()) {
                topRateForm.showTopRateCourse(courseNames);
            } else {
                JOptionPane.showMessageDialog(null, "No top-rated courses available.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
