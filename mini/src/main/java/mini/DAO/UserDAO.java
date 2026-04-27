package mini.DAO;

import mini.DTO.UserDTO;
import mini.sqls.SqlQuery;
import mini.utils.AppException;
import mini.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public int insertUser(UserDTO userDTO) {
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_INSERT)){
            ps.setString(1, userDTO.getUsername());
            ps.setString(2, userDTO.getPassword());
            ps.setDouble(3, userDTO.getBalance());
            return ps.executeUpdate();
        } catch (SQLException e){
            throw new AppException(e.getMessage());
        }
    }

    public boolean isUsernameExists(String username) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_CHECK_EXISTS)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage());
        }
        return false;
    }

    public int updateUser(UserDTO userDTO) {
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_UPDATE_ALL)){
            ps.setString(1, userDTO.getUsername());
            ps.setString(2, userDTO.getPassword());
            ps.setDouble(3, userDTO.getBalance());
            ps.setLong(4, userDTO.getId());
            return ps.executeUpdate();
        } catch (SQLException e){
            throw new AppException(e.getMessage());
        }
    }

    public int updateUsername(long userId, String newUsername) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_UPDATE_USERNAME)) {
            ps.setString(1, newUsername);
            ps.setLong(2, userId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException(e.getMessage());
        }
    }

    public int updatePassword(long userId, String newPassword) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_UPDATE_PASSWORD)) {
            ps.setString(1, newPassword);
            ps.setLong(2, userId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException(e.getMessage());
        }
    }

    public int updateBalance(long userId, double newBalance) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_UPDATE_BALANCE)) {
            ps.setDouble(1, newBalance);
            ps.setLong(2, userId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException(e.getMessage());
        }
    }

    public int updateBalance(Connection conn, long userId, double amount) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_INCREMENT_BALANCE)) {
            ps.setDouble(1, amount);
            ps.setLong(2, userId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException(e.getMessage());
        }
    }

    public int deleteUser(long id) {
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_DELETE)){
            ps.setLong(1, id);
            return ps.executeUpdate();
        } catch (SQLException e){
            throw new AppException(e.getMessage());
        }
    }


    public UserDTO getUserById(long id) {
        try(Connection conn = DBUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_GET_BY_ID)){
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
            throw new AppException(e.getMessage());
        }
        return null;
    }

    public UserDTO getUserByName(String username) {
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(SqlQuery.USER_GET_BY_NAME)){
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(rs.getLong("id"));
                    userDTO.setUsername(rs.getString("username"));
                    userDTO.setPassword(rs.getString("password"));
                    userDTO.setBalance(rs.getDouble("balance"));
                    return userDTO;
                }
            }
        } catch (SQLException e){
            throw new AppException(e.getMessage());
        }
        return null;
    }
}
