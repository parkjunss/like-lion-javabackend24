package mini.controllers;

import mini.DTO.OrderDTO;
import mini.DTO.ProductDTO;
import mini.DTO.UserDTO;
import mini.services.OrderService;
import mini.utils.AppException;
import mini.utils.SessionManager;

import java.util.List;

public class OrderController {
    private final SessionManager sessionManager;
    private final OrderService orderService;

    public OrderController(OrderService orderService, SessionManager sessionManager) {
        this.orderService = orderService;
        this.sessionManager = sessionManager;
    }

    public void createOrder(UserDTO currentUser, ProductDTO productDTO, int orderCount) {
        UserDTO updatedUserAfterOrder = orderService.createOrderAndPay(currentUser, productDTO, orderCount);
        sessionManager.updateSessionState(updatedUserAfterOrder);
    }

    public List<OrderDTO> getMyOrders(UserDTO currentUser) {
        return orderService.getMyOrders(currentUser);
    }

}
