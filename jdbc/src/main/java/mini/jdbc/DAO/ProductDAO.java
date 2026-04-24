package mini.jdbc.DAO;

import mini.jdbc.utils.DBUtil;
import mini.jdbc.DTO.ProductDTO;
import mini.jdbc.DTO.UserDTO;
import mini.jdbc.sqls.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private ProductDTO mapResultSetToDTO(ResultSet rs) throws SQLException {
        ProductDTO product = new ProductDTO();
        product.setId(rs.getLong("id"));
        product.setProductName(rs.getString("title"));
        product.setProductDescription(rs.getString("content"));
        product.setProductPrice(rs.getDouble("price"));
        product.setQuantity(rs.getInt("stock_quantity"));
        product.setCreatedAt(rs.getObject("created_at", LocalDateTime.class));
        UserDTO user = new UserDTO();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        product.setUserDTO(user);
        return product;
    }

    public int insertProduct(ProductDTO productDTO) {
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(SqlQuery.PRODUCT_INSERT)){
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

    public int updateProduct(ProductDTO productDTO) {
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(SqlQuery.PRODUCT_UPDATE)){
            ps.setString(1, productDTO.getProductName());
            ps.setString(2, productDTO.getProductDescription());
            ps.setDouble(3, productDTO.getProductPrice());
            ps.setInt(4, productDTO.getQuantity());
            ps.setLong(5, productDTO.getId());
            return ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int updateStock(Connection conn, long productId, double amount) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SqlQuery.PRODUCT_UPDATE_STOCK)) {
            ps.setDouble(1, amount);
            ps.setLong(2, productId);
            return ps.executeUpdate();
        }
    }

    public int deleteProductWithOwner(long productId, long userId) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SqlQuery.PRODUCT_DELETE_WITH_OWNER)) {
            ps.setLong(1, productId);
            ps.setLong(2, userId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                System.out.println("[오류] 이미 주문된 내역이 있는 상품은 삭제할 수 없습니다.");
            } else {
                System.out.println("[오류] 삭제 중 알 수 없는 문제가 발생했습니다: " + e.getMessage());
            }
            return 0;
        }
    }

    private ProductDTO getProductByParam(String sql, long id) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapResultSetToDTO(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<ProductDTO> getProductListByParam(String sql, String name) {
        List<ProductDTO> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToDTO(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<ProductDTO> getProductListByParam(String sql) {
        List<ProductDTO> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToDTO(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<ProductDTO> getProductListByParam(String sql, UserDTO userDTO) {
        List<ProductDTO> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, userDTO.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToDTO(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ProductDTO getProduct(ProductDTO productDTO) {
        return getProductByParam(SqlQuery.PRODUCT_GET_BY_ID, productDTO.getId());
    }

    public ProductDTO getProduct(long productId) {
        return getProductByParam(SqlQuery.PRODUCT_GET_BY_ID, productId);
    }

    public List<ProductDTO> getUserProducts(UserDTO userDTO) {
        return getProductListByParam(SqlQuery.PRODUCT_GET_BY_USER, userDTO);
    }

    public List<ProductDTO> getProductsByName(String productName) {
        return getProductListByParam(SqlQuery.PRODUCT_GET_BY_NAME, "%" + productName + "%");
    }

    public List<ProductDTO> getAllProducts() {
        return getProductListByParam(SqlQuery.PRODUCT_GET_ALL);
    }
}
