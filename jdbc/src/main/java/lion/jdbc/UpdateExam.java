package lion.jdbc;

import java.sql.*;

public class UpdateExam {
    static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "jun";
        String password = "lion1234";
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "update member set name = ?, email = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "sss2");
            ps.setString(2, "sss2@gmail.com");
            ps.setInt(3, 9);

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
