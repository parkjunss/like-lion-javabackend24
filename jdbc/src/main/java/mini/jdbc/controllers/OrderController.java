package mini.jdbc.controllers;

import mini.jdbc.DTO.OrderDTO;
import mini.jdbc.DTO.ProductDTO;
import mini.jdbc.DTO.UserDTO;
import mini.jdbc.services.OrderService;
import mini.jdbc.utils.SessionManager;

import java.util.List;

public class OrderController {
    private final SessionManager sessionManager = SessionManager.getInstance();
    OrderService orderService = new OrderService();

    public void createOrder(UserDTO currentUser, ProductDTO productDTO, int orderCount) {
        if (productDTO.getUserDTO().getId() == currentUser.getId()) {
            System.out.println("[오류] 본인이 등록한 상품은 직접 구매할 수 없습니다.");
        }
        UserDTO updatedUserAfterOrder = orderService.createOrderAndPay(currentUser, productDTO, orderCount);
        if (updatedUserAfterOrder != null) {
            sessionManager.updateSessionState(updatedUserAfterOrder);
        }
    }

    public List<OrderDTO> getMyOrders(UserDTO currentUser) {
        if (currentUser == null) {
            System.out.println("먼저 로그인 해주세요.");
            return null;
        }
        return orderService.getMyOrders(currentUser);
    }

}
