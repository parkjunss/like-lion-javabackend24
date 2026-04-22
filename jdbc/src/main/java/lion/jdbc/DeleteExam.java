package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExam {
    static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "jun";
        String password = "lion1234";
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM member WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 9);
            int resultCount = ps.executeUpdate();
            System.out.println("resultCount: " + resultCount);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
