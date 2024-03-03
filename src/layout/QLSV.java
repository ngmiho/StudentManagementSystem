package layout;

import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TinDev
 */
//asm
public class QLSV extends JFrame implements MouseListener {
    
    JFrame qlsvFrame;
    JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6;
    JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9;

    JRadioButton jRadioButton1, jRadioButton2;
    JScrollPane jScrollPane1, jScrollPane2;
    JTable jTable1;
    JTextArea jTextArea1;
    JTextField jTextField1, jTextField2, jTextField3, jTextField4;
    ButtonGroup btnGroupGT;
    
    DefaultTableModel tblModel;
    String[] header = {"MãSV", "Họ tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ", "Hình"};
    String[][] datas = {
            {"PS26822", "Nguyen Minh Hoang", "minhhoang25498@gmail.com", "0813833677", "true", "", "D:\\Java_Anh\\anh1.jpg"},
            {"SV002", "Nguyen Van Teo", "t@gmail.com", "", "", "", "", ""},
            {"SV003", "Nguyen Thi Cu", "c@gmail.com", "", "", ""},
        };
    
    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    Vector v;
    
    String image = "";
    
    int index = -1;
    
    public QLSV(String currentUser) {
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jLabel5 = new JLabel();
        jTextField3 = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jTextField4 = new JTextField();
        jLabel2 = new JLabel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        btnGroupGT = new ButtonGroup();
        
        qlsvFrame = new JFrame();
        qlsvFrame.setSize(650, 800);
        qlsvFrame.setTitle("Quản Lý Sinh Viên");
        qlsvFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        qlsvFrame.setLocationRelativeTo(null);

        
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Quản Lý Sinh Viên");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        jButton2.setText(" New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jRadioButton1.setSelected(true);
                jTextArea1.setText("");
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N
        jButton3.setText(" Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String maSV = jTextField1.getText();
                String hoTen = jTextField1.getText();
                String email = jTextField1.getText();
                String SDT = jTextField1.getText();
                boolean GT;
                if (jRadioButton1.isSelected())
                    GT = true;
                else
                    GT = false;
                String diaChi = jTextArea1.getText();
                try {
                    String query = "insert into STUDENTS values (?, ?, ?, ?, ?, ?, NULL)";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, maSV);
                    pstmt.setString(2, hoTen);
                    pstmt.setString(3, email);
                    pstmt.setString(4, SDT);
                    pstmt.setBoolean(5, GT);
                    pstmt.setString(6, diaChi);
                    int ret = pstmt.executeUpdate();
                    if (ret == 1) {
                        JOptionPane.showMessageDialog(null, "Inserted Succesfully");
                        loadSqlToTable();
                    } else 
                        JOptionPane.showMessageDialog(null, "Insert Falied");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        jButton4.setText(" Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //delete
                String maSV = (String) jTable1.getValueAt(index, 0);
                System.out.println(maSV);

                try {
        //            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //            String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
        //                    + "encrypt=true;trustServerCertificate=true;";
        //            con = DriverManager.getConnection(url, "sa", "123456");

                    String query = "delete STUDENTS where maSV = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, maSV);
                    int ret = pstmt.executeUpdate();
                    if (ret == 1) {
                        JOptionPane.showMessageDialog(null, "Deleted Succesfully");
                        loadSqlToTable();
                        index = -1;
                    } else 
                        JOptionPane.showMessageDialog(null, "Delete Falied");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        jButton5.setText(" Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String maSV = (String) jTable1.getValueAt(index, 0);
                System.out.println(maSV);
                try {
                    String query = "update STUDENTS set hinh = ? where maSV = ?";
                    pstmt = con.prepareStatement(query);
                    if (image.equalsIgnoreCase("") == true)
                        return;
                    pstmt.setString(1, image);
                    pstmt.setString(2, maSV);
                    int ret = pstmt.executeUpdate();
                    if (ret == 1) {
                        JOptionPane.showMessageDialog(null, "Updated Succesfully");
                        loadSqlToTable();
                        index = -1;
                    } else 
                        JOptionPane.showMessageDialog(null, "Update Falied");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "masv", "hoten", "email", "sdt", "gt", "dc", "hinh"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //jTable1.getSelectedRow()
                try { 
                    int count = 0;
                    index = jTable1.getSelectedRow();

                    String query = "select * from STUDENTS";
                    pstmt = con.prepareStatement(query);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        jTextField1.setText(rs.getString(1));
                        jTextField2.setText(rs.getString(2));
                        jTextField3.setText(rs.getString(3));
                        jTextField4.setText(rs.getString(4));
                        boolean gt;
                        if (rs.getBoolean(5) == true)
                            jRadioButton1.setSelected(true);
                        else
                            jRadioButton2.setSelected(true);
                        jTextArea1.setText(rs.getString(6));
                        if (rs.getString(7).equalsIgnoreCase("Null"))
                            jLabel8.setIcon(null);
                        else
                            jLabel8.setIcon(resizeImage(rs.getString(7)));
                        if (count == index) {
                            count = 0;
                            break;
                        }
                        count++;
                    }
                } catch (Exception ex) { //để có cancel thì null không bị lỗi
                    Logger.getLogger(QLSVJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Picture not choose yet");
                }
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Ma SV");


        jLabel4.setText("Họ tên SV:");

        jLabel5.setText("Email");



        jLabel6.setText("Số ĐT");

        jLabel7.setText("GT:");

        jLabel2.setText("Địa chỉ");

        jRadioButton1.setText("Nam");

        jRadioButton2.setText("Nữ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 255));
        jButton6.setText("Image");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
        //            JFileChooser(path)
        //            index = jTable1.getSelectedRow();
        //            jLabel8.setIcon(resizeImage(datas[jTable1.getSelectedRow()][6]));

                    JFileChooser f = new JFileChooser();
                    f.setDialogTitle("Choose file");
                    int s = f.showOpenDialog(null);
                    File fanh = f.getSelectedFile();
                    image = fanh.getAbsolutePath();
                    System.out.println(image);
                    jLabel8.setIcon(resizeImage(image));

                } catch (Exception ex) { 
                    ex.printStackTrace();
                }
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qlsvFrame.dispose();
                DangNhap dn = new DangNhap();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(39, 39, 39))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2))
                            .addComponent(jLabel7))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        qlsvFrame.pack();
        
        tblModel = new DefaultTableModel (datas, header);
        jTable1.setModel(tblModel);
        
        
        if (currentUser == null) 
            jLabel9.setText("Welcome!");
        else
            jLabel9.setText("Welcome! " + currentUser);
        jRadioButton1.setSelected(true);
        
        btnGroupGT.add(jRadioButton1);
        btnGroupGT.add(jRadioButton2);
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
                    + "encrypt=true;trustServerCertificate=true;";
            con = DriverManager.getConnection(url, "sa", "123456");
            loadSqlToTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        qlsvFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                try {
                    System.exit(0);
                    if (rs != null)
                        rs.close();
                    if (stmt != null)
                        stmt.close();
                    if (pstmt != null)
                        pstmt.close();
                    if (con != null)
                        con.close();
                    System.exit(0);
                } catch (SQLException ex) {
                    Logger.getLogger(QLSVJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        addMouseListener();
    }
    
    public ImageIcon resizeImage(String ImagePath) {
        ImageIcon MyImg = new ImageIcon(ImagePath);
        Image img = MyImg.getImage();
        Image newImg = img.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public void loadSqlToTable() {
        try {
            String query = "select * from STUDENTS";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            tblModel.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 1; i < 8; i++) 
                    v.add(rs.getString(i));
                tblModel.addRow(v);
            }
            jTable1.setModel(tblModel);
        } catch (SQLException ex) {
            Logger.getLogger(QLSVJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addMouseListener() {
        jTable1.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == jTable1) {
            try { 
            jLabel8.setIcon(resizeImage(datas[jTable1.getSelectedRow()][6]));
            } catch (Exception ex) {
                System.out.println("Picture not choose yet");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
