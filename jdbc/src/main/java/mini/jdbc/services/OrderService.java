package mini.jdbc.services;

import mini.jdbc.DAO.ProductDAO;
import mini.jdbc.DAO.UserDAO;
import mini.jdbc.DAO.OrderDAO;
import mini.jdbc.DTO.OrderDTO;
import mini.jdbc.DTO.ProductDTO;
import mini.jdbc.DTO.UserDTO;
import mini.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderService {

    private final ProductDAO productDAO = new ProductDAO();
    private final UserDAO userDAO = new UserDAO();
    private final OrderDAO orderDAO = new OrderDAO();

    public UserDTO createOrderAndPay(UserDTO userDTO, ProductDTO productDTO, int orderCount) {
        double totalPrice = productDTO.getProductPrice() * orderCount;
        if (userDTO.getBalance() < totalPrice) {
            System.out.println("결제 실패: 잔액이 부족합니다.");
            return null;
        }
        if (productDTO.getQuantity() < orderCount) {
            System.out.println("결제 실패: 재고가 부족합니다.");
            return null;
        }

        if (orderCount <= 0) return null;
        if (productDTO.getProductPrice() < 0) {
            System.out.println("시스템 오류: 상품 가격이 음수입니다.");
            return null;
        }

        try (Connection conn = DBUtil.getConnection()) {
            try {
                conn.setAutoCommit(false);

                userDTO.setBalance(userDTO.getBalance() - totalPrice);
                productDTO.setQuantity(productDTO.getQuantity() - orderCount);

                int r1 = userDAO.updateBalance(conn, userDTO.getId(), -totalPrice);
                if (r1 == 0) throw new SQLException("잔액 차감 실패: DB 업데이트 실패");

                int r2 = productDAO.updateStock(conn, productDTO.getId(), -orderCount);
                if (r2 == 0) throw new SQLException("재고 차감 실패: DB 업데이트 실패");

                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setUserDTO(userDTO);
                orderDTO.setProductDTO(productDTO);
                orderDTO.setOrderPrice(totalPrice);

                int r3 = orderDAO.insertOrder(conn, orderDTO);
                if (r3 == 0) throw new SQLException("주문 생성 실패: DB 업데이트 실패");

                conn.commit();

                return userDTO;

            } catch (Exception e) {
                conn.rollback();
                System.err.println("결제 취소됨 (롤백): " + e.getMessage());
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<OrderDTO> getMyOrders(UserDTO userDTO) {
        return orderDAO.getOrderById(userDTO);
    }
}