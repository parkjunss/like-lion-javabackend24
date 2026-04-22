package mini.jdbc.DAO;

import mini.jdbc.DBUtil;
import mini.jdbc.DTO.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {
    public int insertUser(UserDTO userDTO) {
        String sql = "INSERT INTO users (username, password, balance) VALUES (?, ?, ?)";
        int result = 0;

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, userDTO.getUsername());
            ps.setString(2, userDTO.getPassword());
            ps.setDouble(3, userDTO.getBalance());

            result = ps.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return result;
    }

    public int insertUsers(List<UserDTO> userDTOList) {
        String sql = "INSERT INTO users (username, password, balance) VALUES (?, ?, ?)";
        int result = 0;

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            for (UserDTO userDTO : userDTOList) {
                ps.setString(1, userDTO.getUsername());
                ps.setString(2, userDTO.getPassword());
                ps.setDouble(3, userDTO.getBalance());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int updateUser(UserDTO userDTO) {
        String sql = "UPDATE users SET balance = ? WHERE id = ?";
        int result = 0;

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDouble(1, userDTO.getBalance());
            ps.setLong(2, userDTO.getId());
            result = ps.executeUpdate();
            if (result == 0) {
                System.out.println("경고: 업데이트된 유저가 없습니다. (ID 확인 필요)");
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int deleteUser(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        int result = 0;

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setLong(1, id);
            result = ps.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }


    public UserDTO getUser(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try(Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(rs.getLong("id"));
                    userDTO.setUsername(rs.getString("username"));
                    userDTO.setBalance(rs.getDouble("balance"));
                    return userDTO;
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
