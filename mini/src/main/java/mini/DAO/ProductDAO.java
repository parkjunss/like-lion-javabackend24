package mini.DAO;

import mini.DTO.ProductDTO;
import mini.DTO.UserDTO;
import mini.sqls.SqlQuery;
import mini.utils.AppException;
import mini.utils.DBUtil;

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
            throw new AppException(e.getMessage());
        }
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
            throw new AppException(e.getMessage());
        }
    }

    public int updateStock(Connection conn, long productId, double amount) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(SqlQuery.PRODUCT_UPDATE_STOCK)) {
            ps.setDouble(1, amount);
            ps.setLong(2, productId);
            return ps.executeUpdate();
        } catch (SQLException e){
            throw new AppException(e.getMessage());
        }
    }

    public int deleteProductWithOwner(long productId, long userId) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SqlQuery.PRODUCT_DELETE_WITH_OWNER)) {
            ps.setLong(1, productId);
            ps.setLong(2, userId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException(e.getMessage());
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
            throw new AppException(e.getMessage());
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
            throw new AppException(e.getMessage());
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
            throw new AppException(e.getMessage());
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
            throw new AppException(e.getMessage());
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
