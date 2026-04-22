package lion.jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectOneExam {
    public boolean insertMember(Connection conn, String name, String email, String password) {
        String sql = "insert into member (name, email, password) values (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SelectOneExam.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static void main(String[] args) { // static 앞 public 추가 권장
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "jun";
        String password = "lion1234";
        String sql = "select * from member";
        SelectOneExam so = new SelectOneExam();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            boolean result = so.insertMember(conn, "test", "test@gmail.com", "test1234");
            if(result) {
                System.out.println("ok");
            } else {
                System.out.println("not ok");
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String rsPassword = rs.getString("password");
                    System.out.println(id + "\t" + name + "\t" + email + "\t" + rsPassword);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SelectOneExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}