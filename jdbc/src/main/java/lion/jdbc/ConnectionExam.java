package lion.jdbc;

import com.mysql.cj.log.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExam {
    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "jun";
        String password = "lion1234";
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("^^");
            } else {
                System.out.println("ㅠㅠ");
            }
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
