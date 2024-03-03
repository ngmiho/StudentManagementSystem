package data;

import static DAO.DBConnection.getConnectionSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author TinDev
 */
public class Users {
    private String username;
    private String password;
    private String role;

    static String url = "jdbc:sqlserver://localhost:1433;databaseName=FPL_DaoTao;"
                    + "encrypt=true;trustServerCertificate=true;";
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    
    
    public Users() {
        
    }
    
    public Users(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" + "username=" + username + ", password=" + password + ", role=" + role + '}';
    }
    
    public static boolean checkLogin(String username, String password) {
        try {
            con = DriverManager.getConnection(url, "sa", "123");
            stmt = con.createStatement();
            String query = "select username, password from USERS";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
                    //System.out.println("a");
                    con.close(); stmt.close(); rs.close();
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
            } catch (Exception ex2) {
                ex2.printStackTrace();
            } 
        }
        return false;
    }
    public static void main(String[] args) {
        boolean a = checkLogin("user", "123");
        if (a == true)
            System.out.println("a");
    }
    
}
