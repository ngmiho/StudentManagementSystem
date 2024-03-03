package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TinDev
 */
public class DBConnection {
    
    public static Connection getConnectionSQL(String databaseName, String user, String password) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName="+ databaseName +";"
                    + "encrypt=true;trustServerCertificate=true;";
            Connection con = null;
            return con = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public static void main(String[] args) throws SQLException {
            Connection con = getConnectionSQL("QLSINHVIEN", "sa", "123");
            Statement stmt = con.createStatement();
            String query = "select * from STUDENTS";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("MaSV"));
            }
            rs.close();
            stmt.close();
            con.close();
    }
}
