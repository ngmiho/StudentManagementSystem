package DAO;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TinDev
 */
public class ConnectionDemo { //chua chạy dc
    
    public static void main(String[] args) throws SQLException {
        //1. Load the driver
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
        }
        
        //2. Define the Connection URL
        String myURL = "jdbc:odbc:CONGNHAN";
        String myURLType_4 = "jdbc:jtds:sqlsserver://localhost:1433/pubs";
        
        //3. Establis the Connention
        String username = "sa";
        String password = "123";
        java.sql.Connection con =  DriverManager.getConnection(myURL, username, password);
        
//        //Optionally, look up information about the database
//        DatabaseMetaData dbMetaData = connection.getMetaData = connection.getMetaData();
//        String productName = dbMetaData.getDatabaseProductName();
//        System.out.println("Database: " + productName);
//        String productVersion = dbMetaData.getDatabaseProductVersion();
//        System.out.println("Version: " + productVersion);

        //4. Create a Statement
        Statement stmt = con.createStatement();
        String query = "select * from NhanVien";
        ResultSet rs = stmt.executeQuery(query);
        
        //modify: executeUpdate - for update, insert, delete
        String queryInsert = "insert NhanVien value ('PS03', 'c')";
        int rowEffect = stmt.executeUpdate(queryInsert);
        //số dòng ảnh hưởng
        //Để tạo 1 table, xóa 1 table  sử dụng phương thức execute
        // String query = “drop table LOP”;
        //statement.execute(query);
        
        //6. Xử lý kết quả trả về:
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getInt(2));
        }
        //một số phương thức
        //getString(int) , getInt(int) , getLong(int) , 
        //getObject(int) , getDate(int) …
        
        rs.close();
        stmt.close();
        con.close();
    }
}
