package lion.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    // 1. 데이터 삽입
    public boolean insertMember(MemberDTO memberDTO) {
        String sql = "INSERT INTO member(name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, memberDTO.getName());
            ps.setString(2, memberDTO.getEmail());
            ps.setString(3, memberDTO.getPassword());

            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // 2. 데이터 삭제 (ID 기준)
    public int deleteMember(int id) {
        String sql = "DELETE FROM member WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate(); // getUpdateCount()보다 직접 비교가 명확합니다.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // 3. 데이터 수정
    public int updateMember(MemberDTO memberDTO) {
        String sql = "UPDATE member SET name = ?, email = ?, password = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, memberDTO.getName());
            ps.setString(2, memberDTO.getEmail());
            ps.setString(3, memberDTO.getPassword());
            ps.setInt(4, memberDTO.getId());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public MemberDTO getMember(int id) {
        String sql = "SELECT * FROM member WHERE id = ?";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setId(rs.getInt("id"));
                memberDTO.setName(rs.getString("name"));
                memberDTO.setEmail(rs.getString("email"));
                memberDTO.setPassword(rs.getString("password"));
                memberDTO.setCreated_at(rs.getObject("created_at", LocalDateTime.class));
                return memberDTO;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> memberDTOList = new ArrayList<>();

        String sql = "SELECT * FROM member";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setId(rs.getInt("id"));
                memberDTO.setName(rs.getString("name"));
                memberDTO.setEmail(rs.getString("email"));
                memberDTO.setPassword(rs.getString("password"));
                memberDTO.setCreated_at(rs.getObject("created_at", LocalDateTime.class));
                memberDTOList.add(memberDTO);
            }
            return  memberDTOList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // 4. 이름으로 ID 찾기
    public int findByName(String name) {
        String sql = "SELECT id FROM member WHERE name = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) { // ResultSet도 자동 close 대상입니다.
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // 데이터를 못 찾았을 때는 0보다 안전한 -1 권장
    }
}