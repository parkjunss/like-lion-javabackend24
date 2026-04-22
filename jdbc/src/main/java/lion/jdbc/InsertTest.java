package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public boolean insertMember (String username, String email, String password) throws SQLException {
        return false;
    }
    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "jun";
        String password = "lion1234";
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("^^");
                String sql = "insert into member(name, email, password) values (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "sss");
                ps.setString(2, "sss@gmail.com");
                ps.setString(3, "1234");

                int resultCount = ps.executeUpdate();
                System.out.println("resultCount: " + resultCount);

            } else {
                System.out.println("ㅠㅠ");
            }
            conn.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
