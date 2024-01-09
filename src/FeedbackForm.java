package src;

import login.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FeedbackForm extends JFrame {

    CoursesDetails course = new CoursesDetails();

    public FeedbackForm(User user, String courseId) {
        initComponents(user, courseId);
    }




    private void initComponents(User user, String courseId) {

        //crete a feedback form panel with size 500x500
        JPanel feedbackFormPanel = new JPanel();
        feedbackFormPanel.setPreferredSize(new Dimension(500, 500));
        feedbackFormPanel.setLayout(new BoxLayout(feedbackFormPanel, BoxLayout.Y_AXIS));
        add(feedbackFormPanel);

        // add a label for course name and username in same line
        JPanel courseNamePanel = new JPanel();
        courseNamePanel.setLayout(new BoxLayout(courseNamePanel, BoxLayout.X_AXIS));
        courseNamePanel.setPreferredSize(new Dimension(400, 50));
        feedbackFormPanel.add(courseNamePanel);

        //create a label for course name
        JLabel courseNameLabel = new JLabel(courseId);
        courseNameLabel.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        courseNamePanel.add(courseNameLabel);

        //crate a label emty for space
        JLabel emptyLabel = new JLabel("                         ");
        emptyLabel.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        courseNamePanel.add(emptyLabel);


        //create a label for course name
        JLabel courseName = new JLabel(user.getFirstName() + " " + user.getLastName());
        courseName.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        courseName.setAlignmentX(Component.CENTER_ALIGNMENT);
        courseNamePanel.add(courseName);




        //create a text area for write my feedback
        JTextArea feedback = new JTextArea();
        feedback.setPreferredSize(new Dimension(400, 200));
        feedback.setLineWrap(true);
        feedback.setWrapStyleWord(true);
        feedback.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        feedback.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedbackFormPanel.add(feedback);

        //create a label for rating with max 5 stars
        JLabel ratingLabel = new JLabel("Rating");
        ratingLabel.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        ratingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedbackFormPanel.add(ratingLabel);

        //create a rating panel with 5 stars
        JPanel ratingPanel = new JPanel();
        ratingPanel.setLayout(new BoxLayout(ratingPanel, BoxLayout.X_AXIS));
        ratingPanel.setPreferredSize(new Dimension(400, 50));
        ratingPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedbackFormPanel.add(ratingPanel);

        //create 5 stars with button transparent background
        JButton star1 = new JButton("★");
        star1.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        star1.setBackground(new Color(0, 0, 0, 0));
        star1.setBorderPainted(false);
        star1.setFocusPainted(false);
        star1.setContentAreaFilled(false);
        star1.setPreferredSize(new Dimension(50, 50));
        star1.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingPanel.add(star1);

        JButton star2 = new JButton("★");
        star2.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        star2.setBackground(new Color(0, 0, 0, 0));
        star2.setBorderPainted(false);
        star2.setFocusPainted(false);
        star2.setContentAreaFilled(false);
        star2.setPreferredSize(new Dimension(50, 50));
        star2.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingPanel.add(star2);

        JButton star3 = new JButton("★");
        star3.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        star3.setBackground(new Color(0, 0, 0, 0));
        star3.setBorderPainted(false);
        star3.setFocusPainted(false);
        star3.setContentAreaFilled(false);
        star3.setPreferredSize(new Dimension(50, 50));
        star3.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingPanel.add(star3);

        JButton star4 = new JButton("★");
        star4.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        star4.setBackground(new Color(0, 0, 0, 0));
        star4.setBorderPainted(false);
        star4.setFocusPainted(false);
        star4.setContentAreaFilled(false);
        star4.setPreferredSize(new Dimension(50, 50));
        star4.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingPanel.add(star4);

        JButton star5 = new JButton("★");
        star5.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        star5.setBackground(new Color(0, 0, 0, 0));
        star5.setBorderPainted(false);
        star5.setFocusPainted(false);
        star5.setContentAreaFilled(false);
        star5.setPreferredSize(new Dimension(50, 50));
        star5.setAlignmentX(Component.CENTER_ALIGNMENT);
        ratingPanel.add(star5);





        //create submit button and exit button side to side
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setPreferredSize(new Dimension(400, 50));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedbackFormPanel.add(buttonPanel);

        //create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(submitButton);

        //create exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Hannotate TC", Font.PLAIN, 20));
        exitButton.setPreferredSize(new Dimension(200, 50));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(exitButton);


        //add action listener for rating stars
        star1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1.setForeground(Color.YELLOW);

            }
        });

        star2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1.setForeground(Color.YELLOW);
                star2.setForeground(Color.YELLOW);
            }
        });

        star3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1.setForeground(Color.YELLOW);
                star2.setForeground(Color.YELLOW);
                star3.setForeground(Color.YELLOW);
            }
        });

        star4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1.setForeground(Color.YELLOW);
                star2.setForeground(Color.YELLOW);
                star3.setForeground(Color.YELLOW);
                star4.setForeground(Color.YELLOW);
            }
        });

        star5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1.setForeground(Color.YELLOW);
                star2.setForeground(Color.YELLOW);
                star3.setForeground(Color.YELLOW);
                star4.setForeground(Color.YELLOW);
                star5.setForeground(Color.YELLOW);
            }
        });


        //add action listener for submit button
        

        //add action listener for exit button
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //close the feedback form
                dispose();
            }
        });





        pack();
        setLocationRelativeTo(null);
    }


    public static void leaveFeedback(User user, String courseID){
        FeedbackForm feedbackForm = new FeedbackForm(user, courseID);
        feedbackForm.setVisible(true);
    }
}
