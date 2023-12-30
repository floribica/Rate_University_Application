package login;


import src.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class login extends javax.swing.JFrame {

    private JTextField jTextField1;
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPasswordField jPasswordField1;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel2;

    public login() {
        initComponents();
    }

    private void initComponents() {
        jTextField1 = new JTextField();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLayout(new BorderLayout());

        jPanel1.setBackground(new Color(0, 0, 0,0));
        jPanel1.setVisible(true);
        jPanel1.setPreferredSize(new Dimension(500, 500));
        jPanel1.setSize(new Dimension(500, 500));
        jPanel1.setOpaque(true);


        jLabel1.setFont(new Font("Hannotate TC", Font.BOLD, 50));
        jLabel1.setForeground(Color.darkGray);
        jLabel1.setText("Login");

        jLabel3.setFont(new Font("Hiragino Maru Gothic ProN", Font.BOLD, 18));
        jLabel3.setForeground(Color.white);
        jLabel3.setText("USERNAME:");

        jTextField1.setFont(new java.awt.Font("Hannotate SC", 0, 24)); // NOI18N

        jLabel4.setFont(new Font("Hiragino Maru Gothic ProN", Font.BOLD, 18));
        jLabel4.setForeground(Color.white);
        jLabel4.setText("PASSWORD:");

        jPasswordField1.setFont(new java.awt.Font("Hannotate SC", 0, 24)); // NOI18N


        jButton1.setBackground(new Color(74, 96, 84));
        jButton1.setFont(new Font("Arial Narrow", Font.BOLD, 24));
        jButton1.setForeground(Color.WHITE);
        jButton1.setText("Login");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(74, 96, 84), 2));
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.setPreferredSize(new Dimension(100, 50));
        jButton1.setSize(new Dimension(100, 50));
        jButton1.setFocusPainted(false);
        jButton1.setVisible(true);

        jButton2.setFont(new java.awt.Font("DialogInput", 1, 13)); // NOI18N
        jButton2.setText("I'm still not registered Signup");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jPasswordField1, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jButton2)))
                                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(jPasswordField1))
                                .addGap(49, 49, 49)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(97, Short.MAX_VALUE))
        );


        add(jPanel1, BorderLayout.CENTER);
        //set in the center of the jlabbel1

        jPanel1.setLocation(300, 200);





        jLabel2.setIcon(new ImageIcon("Rate_University_Application/image/img.png")); // NOI18N
        add(jLabel2, BorderLayout.CENTER);

        setSize(new Dimension(1000,698));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        // Open the Signin class
        Signin signinForm = new Signin();
        signinForm.setVisible(true);
        signinForm.pack();
        signinForm.setLocationRelativeTo(null);
        // Close the current form(login)
        this.dispose();
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String username = jTextField1.getText();
        String password = jPasswordField1.getText();

        validation val = new validation();
        password = val.encryptPassword(password);

        User user = UserFileReader.readUserFromFile(username, password);
        if (user != null) {
            dispose();
           // CourseGUI.main();

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
