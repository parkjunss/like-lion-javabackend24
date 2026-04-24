package mini.jdbc.DAO;

import mini.jdbc.utils.DBUtil;
import mini.jdbc.DTO.OrderDTO;
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

public class OrderDAO {
    public int insertOrder(Connection conn, OrderDTO orderDTO) {
        if (orderDTO.getUserDTO() == null || orderDTO.getProductDTO() == null) {
            System.out.println("오류: 유저 또는 상품 정보가 누락되었습니다.");
            return 0;
        }
        try(PreparedStatement ps = conn.prepareStatement(SqlQuery.ORDER_INSERT)){
            ps.setLong(1, orderDTO.getUserDTO().getId());
            ps.setLong(2, orderDTO.getProductDTO().getId());
            ps.setDouble(3, orderDTO.getOrderPrice());
            return ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int deleteOrder(long orderId) {
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(SqlQuery.ORDER_DELETE)){
            ps.setLong(1, orderId);
            return ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public OrderDTO mapResultSetToDTO(ResultSet rs) throws SQLException {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(rs.getLong("id"));
        orderDTO.setOrderPrice(rs.getDouble("order_price"));

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(rs.getLong("product_id"));
        productDTO.setProductName(rs.getString("title"));

        UserDTO user = new UserDTO();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));
        orderDTO.setUserDTO(user);
        orderDTO.setProductDTO(productDTO);
        orderDTO.setOrderDate(rs.getObject("created_at", LocalDateTime.class));
        return orderDTO;
    }

    public OrderDTO getOrderByParam(String sql, long id){
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapResultSetToDTO(rs);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<OrderDTO> getOrderListByParam(String sql, long id) {
        List<OrderDTO> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
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


    public OrderDTO getOrderById(OrderDTO orderDTO) {
        return getOrderByParam(SqlQuery.ORDER_GET_BY_ID, orderDTO.getOrderId());
    }

    public List<OrderDTO> getOrdersById(ProductDTO productDTO) {
        return getOrderListByParam(SqlQuery.ORDER_GET_BY_PRODUCT, productDTO.getId());
    }

    public List<OrderDTO> getOrderById(UserDTO userDTO) {
        return getOrderListByParam(SqlQuery.ORDER_GET_BY_USER, userDTO.getId());
    }
}
