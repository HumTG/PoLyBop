/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

/**
 *
 * @author Admin
 */
public class DBconnect {
    
    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "PoLyBop";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123456";

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";" + "databaseName=" + DBNAME;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, USERNAME, PASSWORD);     
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
