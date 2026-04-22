package mini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/minidb";
        String user = "mini";
        String password = "mini1234";

        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
