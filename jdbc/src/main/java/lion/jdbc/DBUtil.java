package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "jun";
        String password = "lion1234";

        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnection(String user, String password) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/liondb";
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}