package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/ordermanagementdb"; 
    private static final String USER = "root";      
    private static final String PASSWORD = "";   
    
//    public static Connection getDBConn() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Database connected successfully.");
//        } catch (SQLException e) {
//            System.out.println("Database connection failed.");
//            e.printStackTrace();
//        }
//        return conn;
//    }


    public static void main(String[] args) throws SQLException {
    	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        if (conn != null) {
            System.out.println("Connection Test: Success!");
        } else {
            System.out.println("Connection Test: Failed.");
        }
    }

    public static Connection getDBConn() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ DB Connected!");
        } catch (SQLException e) {
            System.out.println("❌ DB Connection Failed.");
            e.printStackTrace();
        }
        conn.setAutoCommit(true);
        return conn;
    }

}
