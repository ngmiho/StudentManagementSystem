package layout;

//asm

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;


/**
 *
 * @author TinDev
 */
public class QLDSV extends JFrame {
    
    DefaultTableModel tblModel;
    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;
    
    // Tạo đối tượng DecimalFormat với hai chữ số sau dấu phẩy
    NumberFormat format = new DecimalFormat("#0.00");
    
    int index = 1;
    
    JFrame f;
    
    JButton jButton1;
    JButton jButton11;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JButton jButton6;
    JButton jButton7;
    JButton jButton8;
    JButton jButton9;
    JComboBox<String> jComboBox1;
    JLabel jLabel1;
    JLabel jLabel10;
    JLabel jLabel11;
    JLabel jLabel12;
    JLabel jLabel13;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;
    JLabel jLabel8;
    JLabel jLabel9;
    JPanel jPanel1;
    JPanel jPanel2;
    JScrollPane jScrollPane1;
    JTable jTable1;
    JTextField jTextField1;
    JTextField jTextField3;
    JTextField jTextField4;
    JTextField jTextField5;
    

    
    public QLDSV(String currentUser) {
        jLabel1 = new JLabel();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel2 = new JLabel();
        jPanel2 = new JPanel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jLabel12 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel13 = new JLabel();
        jButton11 = new JButton();
        
        f = new JFrame();
        f.setVisible(true);
        f.setTitle("Quản Lý Điểm Sinh Viên");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(900, 800);
        f.setLocationRelativeTo(null);
        
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        f.setLocationRelativeTo(null);
        if (currentUser == null) 
            jLabel13.setText("Welcome!");
        else
            jLabel13.setText("Welcome! " + currentUser);
            
        String[] header = {"MãSV", "Họ tên", "Tiếng Anh", "Tin học", "GDTC", "Điểm TB"};
        String[][] datas = {
            {"SV005", "Nguyen Thi Tuong Vy", "10", "10", "10", "10"},
            {"PS26822", "Nguyen Minh Hoang", "10", "9.89", "9", "10"},
            {"SV006", "Loi Roi", "8", "8", "9", "9"},
        };
        
        tblModel = new DefaultTableModel (datas, header);
        jTable1.setModel(tblModel);
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
                    + "encrypt=true;trustServerCertificate=true;";
            con = DriverManager.getConnection(url, "sa", "123456");
            stmt = con.createStatement();
            String query = "select * from GRADE";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                jComboBox1.addItem(rs.getString(2));
            }
            loadTop3();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        
        
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        jLabel3.setText("Ma SV");

        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        jButton1.setText(" Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String upperMaSV = jTextField1.getText().trim().toUpperCase();
                jComboBox1.setSelectedItem(upperMaSV);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jLabel4.setText("Họ tên SV:");

        jLabel5.setText("Mã SV");

        jLabel6.setText("Tiếng anh:");

        jLabel7.setText("Tin học:");

        jLabel8.setText("Giáo dục TC:");

        jLabel9.setForeground(new java.awt.Color(51, 51, 255));


        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                    if (jTextField3.getText().trim().equals("") == false 
                    && jTextField4.getText().trim().equals("") == false
                    && jTextField5.getText().trim().equals("") == false) {
                double dtb = gpa();
                String numberDouble = "" + format.format(dtb);
                jLabel11.setText(numberDouble);
            } 
            }
        });

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (jTextField3.getText().trim().equals("") == false 
                && jTextField4.getText().trim().equals("") == false
                && jTextField5.getText().trim().equals("") == false) {
            double dtb = gpa();
            String numberDouble = "" + format.format(dtb);
            jLabel11.setText(numberDouble);
        } 
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (jTextField3.getText().trim().equals("") == false 
                && jTextField4.getText().trim().equals("") == false
                && jTextField5.getText().trim().equals("") == false) {
            double dtb = gpa();
            String numberDouble = "" + format.format(dtb);
            jLabel11.setText(numberDouble);
        } 
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText(" DTB");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "    " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
                            + "encrypt=true;trustServerCertificate=true;";
                    con = DriverManager.getConnection(url, "sa", "123456");


                    String query = "select hoTen from STUDENTS where maSV = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, (String)jComboBox1.getSelectedItem());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        jLabel9.setText(rs.getString("hoTen"));
                    }
                    query = "select * from GRADE where maSV = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, (String)jComboBox1.getSelectedItem());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {

                        jTextField3.setText(rs.getString("tiengAnh"));
                        jTextField4.setText(rs.getString("tinHoc"));
                        jTextField5.setText(rs.getString("GDTC"));
                    }
                    //tính và load dtb lên jlabel11
                    double dtb = gpa();
                    if (dtb == 0)
                        jLabel11.setText("");
                    else {
                        String numberDouble = "" + format.format(dtb);
                        jLabel11.setText(numberDouble);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, GroupLayout.Alignment.LEADING, 0, 122, Short.MAX_VALUE)
                            .addComponent(jTextField3, GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, GroupLayout.Alignment.LEADING))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setIcon(new ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        jButton2.setText(" New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1.setText("");
                jComboBox1.setSelectedIndex(0);
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jLabel9.setText("");
                jLabel11.setText("");
            }
        });

        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setIcon(new ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N
        jButton3.setText(" Save");


        jButton4.setForeground(new java.awt.Color(51, 51, 255));
        jButton4.setIcon(new ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        jButton4.setText(" Delete");


        jButton5.setForeground(new java.awt.Color(51, 51, 255));
        jButton5.setIcon(new ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        jButton5.setText(" Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
                            + "encrypt=true;trustServerCertificate=true;";
                    con = DriverManager.getConnection(url, "sa", "123456");


                    String query = "update GRADE set tiengAnh = ?, tinHoc = ?, GDTC = ? where maSV = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, jTextField3.getText().trim());
                    pstmt.setString(2, jTextField4.getText().trim());
                    pstmt.setString(3, jTextField5.getText().trim());
                    pstmt.setString(4, (String)jComboBox1.getSelectedItem());
                    int ret = pstmt.executeUpdate();
                    System.out.println(ret);
                    loadTop3();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jButton6.setIcon(new ImageIcon(getClass().getResource("/Icons/skip_backward.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                index = 1;
                loadSqlToControl(index);
            }
        });

        jButton7.setIcon(new ImageIcon(getClass().getResource("/Icons/previous.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                index--;
                loadSqlToControl(index);
            }
        });

        jButton8.setIcon(new ImageIcon(getClass().getResource("/Icons/next.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                index++;
                loadSqlToControl(index);
            }
        });

        jButton9.setIcon(new ImageIcon(getClass().getResource("/Icons/skip_forward.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
                            + "encrypt=true;trustServerCertificate=true;";
                    con = DriverManager.getConnection(url, "sa", "123456");

                    String query = "select * from GRADE";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    index = 0;
                    while (rs.next()) 
                        index++;
                    query = "select * from GRADE where ID = " + index;
                    pstmt = con.prepareStatement(query);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        jTextField3.setText(rs.getString("tiengAnh"));
                        jTextField4.setText(rs.getString("tinHoc"));
                        jTextField5.setText(rs.getString("GDTC"));
                        jComboBox1.setSelectedIndex(index);
                    }


                    while (rs.next()) {
                        query = "select hoTen from STUDENTS where maSV = ?";
                        pstmt = con.prepareStatement(query);
                        pstmt.setString(1, rs.getString("maSV"));
                        rs = pstmt.executeQuery();
                        while (rs.next()) {
                            jLabel9.setText(rs.getString("hoTen"));
                        }
                    }

                    //tính và load dtb lên jlabel11
                    double dtb = gpa();
                    String numberDouble = "" + format.format(dtb);
                    jLabel11.setText(numberDouble);


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("3 Sinh viên có điểm cao nhất:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MãSV", "Họ tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB"
            }
        ));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        jLabel13.setText("Welcome! ");

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton11.setText("Change");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f.dispose();
                DangNhap dn = new DangNhap();
            }
        });

        GroupLayout layout = new GroupLayout(f.getContentPane());
        f.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2))
                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton11)
                .addGap(15, 15, 15))
        );

        f.pack();
        
        f.addWindowListener(new WindowAdapter() {
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
        
    }
    
    //Tính điểm trung bình
    public double gpa() {
        if (jTextField3.getText().isEmpty() == true)
            return 0.0;
        else {
            double gpa = (Double.parseDouble(jTextField3.getText())
                + Double.parseDouble(jTextField4.getText())
                + Double.parseDouble(jTextField5.getText())) / 3;
            return gpa;
        }
    }
    
    public void loadSqlToControl(int index) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
                    + "encrypt=true;trustServerCertificate=true;";
            con = DriverManager.getConnection(url, "sa", "123456");
            
            String query = "select * from GRADE where ID = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, String.valueOf(index));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                jTextField3.setText(rs.getString("tiengAnh"));
                jTextField4.setText(rs.getString("tinHoc"));
                jTextField5.setText(rs.getString("GDTC"));
                jComboBox1.setSelectedIndex(index);
            }
            
            
            while (rs.next()) {
                query = "select hoTen from STUDENTS where maSV = ?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, rs.getString("maSV"));
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    jLabel9.setText(rs.getString("hoTen"));
                }
            }
 
            //tính và load dtb lên jlabel11
            double dtb = gpa();
            String numberDouble = "" + format.format(dtb);
            jLabel11.setText(numberDouble);
                
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    //kiễm trả nếu chuỗi null sẽ trả về false
    public boolean checkString(String s) {
        if (s.matches("^\\w+$") == false)
            return false;
        return true;
    }
    
    public void loadTop3() {
        try {
            String query = "select top 3 (tiengAnh + tinHoc + GDTC) / 3 as 'dtb', GRADE.maSV, tiengAnh, tinHoc, GDTC, hoTen from GRADE inner join STUDENTS on GRADE.maSV = STUDENTS.maSV";
            rs = stmt.executeQuery(query);
            tblModel.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(2));
                v.add(rs.getString(6));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(1));
                tblModel.addRow(v);
            }
            jTable1.setModel(tblModel);
        } catch (SQLException ex) {
            Logger.getLogger(QLDSVJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}