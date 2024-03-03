package layout;

//asm1

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author TinDev
 */
public class DangNhap extends JFrame implements ActionListener {
    
    JFrame dnFrame;
    JButton btndangnhap, btnExit;
    JLabel jLabel1, jLabel2, lbllogin;
    JPanel jPanel1;
    JTextField txttaikhoan;
    JPasswordField txtmatkhau;
    
    public DangNhap() {
        dnFrame = new JFrame();
        //test.FrameLayout.setFrameLayout(dnFrame, 850, 600, "Sign In");
        
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txttaikhoan = new JTextField();
        txtmatkhau = new JPasswordField();
        btndangnhap = new JButton();
        btnExit = new JButton();
        lbllogin = new JLabel();
        
        jPanel1.setBackground(new java.awt.Color(197, 121, 27));
        jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Login", 
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Account      :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password    :");


        btndangnhap.setBackground(new java.awt.Color(255, 153, 51));
        btndangnhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btndangnhap.setForeground(new java.awt.Color(255, 255, 255));
        btndangnhap.setText("LOG IN");
        btndangnhap.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        
        btnExit.setBackground(new java.awt.Color(255, 153, 51));
        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));


        lbllogin.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbllogin.setForeground(new java.awt.Color(255, 255, 255));
        lbllogin.setText("LOG IN");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txttaikhoan, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtmatkhau, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btndangnhap, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(lbllogin, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbllogin)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txttaikhoan, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmatkhau, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btndangnhap, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        GroupLayout layout = new GroupLayout(dnFrame.getContentPane());
        dnFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
        
        addActionListener();
    }
    
    public void addActionListener() {
        btndangnhap.addActionListener(this);
        btnExit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btndangnhap) {
            if (txttaikhoan.getText().matches("^\\w+$") == false || txttaikhoan.getText().matches("^\\w+$") == false) {
                JOptionPane.showMessageDialog(null, "Input account information");
                txttaikhoan.requestFocus();
                return;
            }
            String username = txttaikhoan.getText();
            String password = new String(txtmatkhau.getPassword());
            boolean currentUser = data.Users.checkLogin(username, password);
            if (currentUser == true) {
                JOptionPane.showMessageDialog(this, "Logged in succesful");
                this.dispose();
                if (username.equalsIgnoreCase("giangvien"))
                    new QLDSV(username).setVisible(true);
                if (username.equalsIgnoreCase("canbo"))
                    new QLSV(username).setVisible(true);
            } else
                JOptionPane.showMessageDialog(this, "Log in failed");
        } else if (ae.getSource() == btnExit) {
            int choice = JOptionPane.showConfirmDialog(null, "Yes/No", "Exit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
}
