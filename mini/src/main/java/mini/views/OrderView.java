package mini.views;

import mini.DTO.OrderDTO;
import mini.DTO.UserDTO;
import mini.controllers.OrderController;
import mini.controllers.UserController;
import mini.utils.InputUtil;

import java.util.List;

public class OrderView {
    private final OrderController orderController;
    private final UserController userController;

    public OrderView(OrderController orderController, UserController userController) {
        this.orderController = orderController;
        this.userController = userController;
    }

    public void showMyOrders() {
        try{
            UserDTO currentUser = userController.getUser();

            if (currentUser == null) {
                System.out.println("먼저 로그인 해주세요.");
                return;
            }
            List<OrderDTO> myOrderList = orderController.getMyOrders(currentUser);
            System.out.println("\n[ 나의 구매 내역 ]");
            if (myOrderList.isEmpty()) {
                System.out.println("주문 내역이 없습니다.");
            } else {
                for (OrderDTO o : myOrderList) {
                    System.out.printf("주문ID: %d |상품명: %s |결제금액: %.0f |날짜: %s\n",
                            o.getOrderId(), o.getProductDTO().getProductName(), o.getOrderPrice(), o.getOrderDate());
                }
            }
            InputUtil.readString("엔터를 누르면 뒤로 이동합니다.");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
