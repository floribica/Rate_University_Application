package course;

import login.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CoursePersonalPage {


    //open frame for each course
    public static void course(String [] course, User user) {

        JFrame frame = new JFrame();
        frame.setTitle(course[0]);
        frame.setSize(1070, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        JLabel courseName = new JLabel(course[0]);
        courseName.setBounds(10, 10, 1000, 50);
        courseName.setFont(new java.awt.Font("Hannotate SC", 0, 40));
        frame.add(courseName);

        JLabel courseNumber = new JLabel(course[1]);
        courseNumber.setBounds(10, 60, 1000, 50);
        courseNumber.setFont(new java.awt.Font("Hannotate SC", 0, 40));
        frame.add(courseNumber);

        JLabel courseCredit = new JLabel(course[2]);
        courseCredit.setBounds(10, 110, 1000, 50);
        courseCredit.setFont(new java.awt.Font("Hannotate SC", 0, 40));
        frame.add(courseCredit);

        JLabel courseDescription = new JLabel(course[3]);
        courseDescription.setBounds(10, 160, 1000, 400);
        courseDescription.setFont(new java.awt.Font("Hannotate SC", 0, 20));
        frame.add(courseDescription);

        ;

        //add button to join course if user is not already joined and drop course if user is already joined
        JoinedCourseReader joinedCourseReader = new JoinedCourseReader();
        if (joinedCourseReader.checkuserExist(user, course[1])) {
            JButton dropCourse = new JButton("Drop Course");
            dropCourse.setBounds(10, 500, 200, 50);
            dropCourse.setFont(new java.awt.Font("Hannotate SC", 0, 20));
            frame.add(dropCourse);

            //add action listener to drop course
            dropCourse.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    try {
                        DroppedCourse.dropCourse(user, course[1]);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(null, "Course dropped successfully");
                    returnToMainPageActionPerformed(evt, user);
                }
            });
        } else {
            JButton joinCourse = new JButton("Join Course");
            joinCourse.setBounds(10, 500, 200, 50);
            joinCourse.setFont(new java.awt.Font("Hannotate SC", 0, 20));
            frame.add(joinCourse);

            //add action listener to join course
            joinCourse.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        JoinedCoursWritter.course(course, user);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(null, "Course joined successfully");
                    returnToMainPageActionPerformed(evt, user);
                }
            });
        }

        //add button to rate course
        JButton rateCourse = new JButton("Rate Course");
        rateCourse.setBounds(220, 500, 200, 50);
        rateCourse.setFont(new java.awt.Font("Hannotate SC", 0, 20));
        frame.add(rateCourse);

        //add button to view course ratings
        JButton viewCourseRatings = new JButton("Course Ratings");
        viewCourseRatings.setBounds(430, 500, 200, 50);
        viewCourseRatings.setFont(new java.awt.Font("Hannotate SC", 0, 20));
        frame.add(viewCourseRatings);

        //add button to view course comments
        JButton viewCourseComments = new JButton("Course Comments");
        viewCourseComments.setBounds(640, 500, 200, 50);
        viewCourseComments.setFont(new java.awt.Font("Hannotate SC", 0, 20));
        frame.add(viewCourseComments);

        //add button to return to main page
        JButton returnToMainPage = new JButton("Return");
        returnToMainPage.setBounds(850, 500, 200, 50);
        returnToMainPage.setFont(new java.awt.Font("Hannotate SC", 0, 20));
        frame.add(returnToMainPage);



        //add action listener to view course ratings
        viewCourseRatings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackFileReader.showRate(course[1]);
            }
        });

        //add action listener to view course comments
        viewCourseComments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FeedbackFileReader.showDescription(course[1]);
            }
        });
        //add action listener to rate course
        rateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackForm.leaveFeedback(user, course[1]);
            }
        });

        //add action listener to return to coursespage1 with the same user
        returnToMainPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnToMainPageActionPerformed(evt, user);
            }
        });

    }

    //return to CoursesPage1
    private static void returnToMainPageActionPerformed(java.awt.event.ActionEvent evt, User user) {
        CoursePage1 coursePage1 = new CoursePage1(user);
        coursePage1.setVisible(true);
        coursePage1.pack();
        coursePage1.setLocationRelativeTo(null);

        //close the current frame
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JButton) evt.getSource());
        frame.dispose();


    }

}
