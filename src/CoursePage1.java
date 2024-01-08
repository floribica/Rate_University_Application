package src;

import login.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CoursePage1 extends JFrame {

    CoursesDetails course = new CoursesDetails();

    public CoursePage1(User user) {
        initComponents(user);
    }




    private void initComponents(User user) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        setTitle("Course UPT");
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 10, 10)); // 3x3 grid with gaps

        //set size of main page
        buttonPanel.setPreferredSize(new Dimension(1000, 600));
        //SET PAGE NAME



        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();
        JButton jButton5 = new JButton();
        JButton jButton6 = new JButton();
        JButton jButton7 = new JButton();
        JButton jButton8 = new JButton();
        JButton jButton9 = new JButton();

        jButton1.setBackground(new Color(135, 206, 250));
        jButton1.setText("<html><center>Artificial Intelligence</center></html>");
        jButton1.setFont(new Font("Arial", Font.BOLD, 30));
        jButton1.setForeground(Color.WHITE);
        jButton1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton1.setFocusPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);

        jButton2.setBackground(new Color(135, 206, 250));
        jButton2.setText("<html><center>Software Engineering</center></html>");
        jButton2.setFont(new Font("Arial", Font.BOLD, 30));
        jButton2.setForeground(Color.WHITE);
        jButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton2.setFocusPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);

        jButton3.setBackground(new Color(135, 206, 250));
        jButton3.setText("<html><center>Computer Networks</center></html>");
        jButton3.setFont(new Font("Arial", Font.BOLD, 30));
        jButton3.setForeground(Color.WHITE);
        jButton3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton3.setFocusPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);

        jButton4.setBackground(new Color(135, 206, 250));
        jButton4.setText("<html><center>Computer Graphics</center></html>");
        jButton4.setFont(new Font("Arial", Font.BOLD, 30));
        jButton4.setForeground(Color.WHITE);
        jButton4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton4.setFocusPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);

        jButton5.setBackground(new Color(135, 206, 250));
        jButton5.setText("<html><center>Computer Architecture</center></html>");
        jButton5.setFont(new Font("Arial", Font.BOLD, 30));
        jButton5.setForeground(Color.WHITE);
        jButton5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton5.setFocusPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);

        jButton6.setBackground(new Color(135, 206, 250));
        jButton6.setText("<html><center>Operating Systems</center></html>");
        jButton6.setFont(new Font("Arial", Font.BOLD, 30));
        jButton6.setForeground(Color.WHITE);
        jButton6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton6.setFocusPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setOpaque(true);

        jButton7.setBackground(new Color(135, 206, 250));
        jButton7.setText("<html><center>Database Systems</center></html>");
        jButton7.setFont(new Font("Arial", Font.BOLD, 30));
        jButton7.setForeground(Color.WHITE);
        jButton7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton7.setFocusPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setOpaque(true);

        jButton8.setBackground(new Color(135, 206, 250));
        jButton8.setText("<html><center>Computer Security</center></html>");
        jButton8.setFont(new Font("Arial", Font.BOLD, 30));
        jButton8.setForeground(Color.WHITE);
        jButton8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton8.setFocusPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setOpaque(true);

        jButton9.setBackground(new Color(135, 206, 250));
        jButton9.setText("<html><center>Computer Vision</center></html>");
        jButton9.setFont(new Font("Arial", Font.BOLD, 30));
        jButton9.setForeground(Color.WHITE);
        jButton9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jButton9.setFocusPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setOpaque(true);

        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        buttonPanel.add(jButton4);
        buttonPanel.add(jButton5);
        buttonPanel.add(jButton6);
        buttonPanel.add(jButton7);
        buttonPanel.add(jButton8);
        buttonPanel.add(jButton9);

        contentPane.add(buttonPanel, BorderLayout.CENTER);

        JLabel jLabel3 = new JLabel();
        //set user
        jLabel3.setText(user.getFirstName() + " " + user.getLastName());
        jLabel3.setFont(new Font("Hannotate TC", Font.BOLD, 20));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(jLabel3, BorderLayout.SOUTH);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JButton jButton10 = new JButton("MY COURSES");
        JButton jButton11 = new JButton("TOP COURSES");
        JButton jButton12 = new JButton("CALENDAR");
        JButton jButton13 = new JButton("LOGOUT");

        //change font Hannotate TC
        jButton10.setFont(new Font("Hannotate TC", Font.BOLD, 20));
        jButton11.setFont(new Font("Hannotate TC", Font.BOLD, 20));
        jButton12.setFont(new Font("Hannotate TC", Font.BOLD, 20));
        jButton13.setFont(new Font("Hannotate TC", Font.BOLD, 20));

        topPanel.add(jButton10);
        topPanel.add(jButton11);
        topPanel.add(jButton12);
        topPanel.add(jButton13);

        contentPane.add(topPanel, BorderLayout.NORTH);

        JLabel jLabel2 = new JLabel();
        contentPane.add(jLabel2, BorderLayout.WEST);

        JLabel jLabel1 = new JLabel();
        contentPane.add(jLabel1, BorderLayout.EAST);

        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt,user));
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt,user));
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt,user));
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt,user));
        jButton5.addActionListener(evt -> jButton5ActionPerformed(evt,user));
        jButton6.addActionListener(evt -> jButton6ActionPerformed(evt,user));
        jButton7.addActionListener(evt -> jButton7ActionPerformed(evt,user));
        jButton8.addActionListener(evt -> jButton8ActionPerformed(evt,user));
        jButton9.addActionListener(evt -> jButton9ActionPerformed(evt,user));

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt, user);
            }

            private void jButton12ActionPerformed(ActionEvent evt, User user) {

                Calendar calendar = new Calendar();
                calendar.openCalendar();

            }
        });


        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }

            private void jButton13ActionPerformed(ActionEvent evt) {
                //from login.user to login.login
                login.login login = new login.login();
                login.setVisible(true);



                dispose();
            }
        });




        pack();
        setLocationRelativeTo(null);
    }

    //set an action listener for the button1
    private void jButton1ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course1
        CoursePersonalPage.course(course.course1,user);
        this.dispose();
    }

    private void jButton2ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course2
        CoursePersonalPage.course(course.course2,user);
        this.dispose();
    }

    private void jButton3ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course3
        CoursePersonalPage.course(course.course3,user);
        this.dispose();
    }

    private void jButton4ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course4
        CoursePersonalPage.course(course.course4,user);
        this.dispose();
    }

    private void jButton5ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course5
        CoursePersonalPage.course(course.course5,user);
        this.dispose();
    }

    private void jButton6ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course6
        CoursePersonalPage.course(course.course6,user);
        this.dispose();
    }

    private void jButton7ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course7
        CoursePersonalPage.course(course.course7,user);
        this.dispose();
    }

    private void jButton8ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course8
        CoursePersonalPage.course(course.course8,user);
        this.dispose();
    }

    private void jButton9ActionPerformed(ActionEvent evt, User user) {
        //open a frame for course9
        CoursePersonalPage.course(course.course9,user);
        this.dispose();
    }


    public static void pg1() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoursePage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
}
