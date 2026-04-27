package mini.services;

import mini.DAO.OrderDAO;
import mini.DAO.ProductDAO;
import mini.DAO.UserDAO;
import mini.DTO.OrderDTO;
import mini.DTO.ProductDTO;
import mini.DTO.UserDTO;
import mini.utils.AppException;
import mini.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderService {

    private final ProductDAO productDAO;
    private final UserDAO userDAO;
    private final OrderDAO orderDAO;

    public OrderService(ProductDAO productDAO, UserDAO userDAO, OrderDAO orderDAO) {
        this.productDAO = productDAO;
        this.userDAO = userDAO;
        this.orderDAO = orderDAO;
    }

    public UserDTO createOrderAndPay(UserDTO userDTO, ProductDTO productDTO, int orderCount) {
        double totalPrice = productDTO.getProductPrice() * orderCount;
        if (productDTO.getUserDTO().getId() == userDTO.getId()) {
            throw new AppException("[오류] 본인이 등록한 상품은 직접 구매할 수 없습니다.");
        }
        if (userDTO.getBalance() < totalPrice) {
            throw new AppException("결제 실패: 잔액이 부족합니다.");
        }
        if (productDTO.getQuantity() < orderCount) {
            throw new AppException("결제 실패: 재고가 부족합니다.");
        }
        if (orderCount <= 0){
            throw new AppException("결제 실패: 주문 수량은 1 이상이어야 합니다.");
        }
        if (productDTO.getProductPrice() < 0) {
            throw new AppException("시스템 오류: 상품 가격이 음수입니다.");
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
                return userDAO.getUserById(userDTO.getId());

            } catch (Exception e) {
                conn.rollback();
                throw new AppException("결제 취소됨 (롤백): " + e.getMessage());
            }
        } catch (SQLException e) {
            throw new AppException(e.getMessage());
        }
    }

    public List<OrderDTO> getMyOrders(UserDTO userDTO) {
        return orderDAO.getOrderById(userDTO);
    }
}