package mini.jdbc.DAO;

import mini.jdbc.DBUtil;
import mini.jdbc.DTO.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    public int insertProduct(ProductDTO productDTO) {
        String sql = "INSERT INTO products (title, content, price, stock_quantity, user_id) VALUES (?,?,?,?,?)";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, productDTO.getProductName());
            ps.setString(2, productDTO.getProductDescription());
            ps.setDouble(3, productDTO.getProductPrice());
            ps.setInt(4, productDTO.getQuantity());
            ps.setLong(5, productDTO.getUserDTO().getId());
            return ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
