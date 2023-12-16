package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Signin extends javax.swing.JFrame {

    /**
     * Creates new form signup
     */
    public Signin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        ButtonGroup buttonGroup = new ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign up");
        setMinimumSize(new java.awt.Dimension(1000, 667));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,0));

        jLabel2.setFont(new java.awt.Font("Kannada MN", 3, 48)); // NOI18N
        jLabel2.setText("Sign up");



        jLabel3.setFont(new java.awt.Font("Hannotate SC", 1, 24)); // NOI18N
        jLabel3.setText("FIRST NAME:");
        jTextField1.setFont(new java.awt.Font("Hannotate SC", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Hannotate SC", 1, 24)); // NOI18N
        jLabel4.setText("LAST NAME:");
        jTextField2.setFont(new java.awt.Font("Hannotate SC", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Hannotate SC", 1, 24)); // NOI18N
        jLabel5.setText("USERNAME:");
        jTextField3.setFont(new java.awt.Font("Hannotate SC", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Hannotate SC", 1, 24)); // NOI18N
        jLabel6.setText("PASSWORD:");
        jPasswordField2.setFont(new java.awt.Font("Hannotate SC", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Hannotate SC", 1, 24)); // NOI18N
        jLabel7.setText("CONFIRM PASS:");
        jPasswordField1.setFont(new java.awt.Font("Hannotate SC", 0, 24)); // NOI18N

        jRadioButton1.setText("STUDENT");
        jRadioButton2.setText("COURSE");

        jButton1.setBackground(new java.awt.Color(122, 167, 113));
        jButton1.setFont(new java.awt.Font("Kannada MN", 3, 24)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(158, 158, 158)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jPasswordField2)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(46, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton2)
                                .addGap(119, 119, 119))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(jTextField1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new java.awt.FlowLayout());
        jPanel1.setBounds(250, 80, 520, 490);

        jLabel1.setIcon(new javax.swing.ImageIcon("Rate_University_Application/image/img_1.png")); // NOI18N
        getContentPane().setLayout(null); // Set layout to null

        // Set bounds for jPanel1
        jPanel1.setBounds(250, 80, 520, 490);
        getContentPane().add(jPanel1);

        // Set bounds for jLabel1
        jLabel1.setBounds(0, 0, 1000, 667);
        getContentPane().add(jLabel1);

        setSize(new java.awt.Dimension(1000, 667));
        setLocationRelativeTo(null);



    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // Get user input from text fields
        String firstName = jTextField1.getText();
        String lastName = jTextField2.getText();
        String username = jTextField3.getText();
        String password = jPasswordField1.getText();
        String confirmPassword = jPasswordField2.getText();
        int id ;
        // Validate password
        boolean isValidPassword = validation.validatePassword(password);
        if (!isValidPassword) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
            return;
        }


        // Confirm password
        boolean isConfirmedPassword = validation.confirmPassword(password, confirmPassword);
        if (!isConfirmedPassword) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }
        // Validate name
        boolean isValidName = validation.validateName(firstName);
        if (!isValidName) {
            JOptionPane.showMessageDialog(this, "Name must be at least 2 characters long and contain only letters.");
            return;
        }

        // Validate last name
        boolean isValidLastName = validation.validateLastName(lastName);
        if (!isValidLastName) {
            JOptionPane.showMessageDialog(this, "Last name must be at least 2 characters long and contain only letters.");
            return;
        }

        // Validate username
        boolean isValidUsername = validation.validateUsername(username);
        if (!isValidUsername) {
            JOptionPane.showMessageDialog(this, "Username must be at least 6 characters long and contain only letters and numbers.");
            return;
        }

        // Check if username already exists
        User user = UserFileReader.readUserFromFile(username);
        if (user != null) {
            JOptionPane.showMessageDialog(this, "Username already exists.");
            return;
        }


        // Determine if the user is a student or a course based on radio button selection
        boolean isStudent = jRadioButton1.isSelected();
        if (isStudent) {
            id = 01;

        } else {
            id = 02;
        }
        JOptionPane.showMessageDialog(this, "Rregistrimi u krye me sukses.");

        password = validation.encryptPassword(password);

        // Create a User object
        User user1 = new User(firstName, lastName, username, password, id);

        //Write on file
        UserFileWriter userFileWriter = new UserFileWriter();
        userFileWriter.writeUserToFile(user1);
        // Open login form
        login login = new login();
        login.setVisible(true);
        dispose();
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration
}
