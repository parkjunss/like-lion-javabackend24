package mini.jdbc.DTO;

import java.time.LocalDateTime;

public class OrderDTO {
    private long orderId;
    private ProductDTO productDTO;
    private UserDTO userDTO;
    private double orderPrice;
    private int orderQty;
    private LocalDateTime orderDate;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", productDTO=" + productDTO +
                ", userDTO=" + userDTO +
                ", orderPrice=" + orderPrice +
                ", orderQty=" + orderQty +
                ", orderDate=" + orderDate +
                '}';
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
