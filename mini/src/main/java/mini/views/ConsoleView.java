package mini.views;

import mini.controllers.OrderController;
import mini.controllers.ProductController;
import mini.controllers.UserController;


public class ConsoleView {
    private final UserView userView;
    private final ProductView productView;
    private final OrderView orderView;

    public ConsoleView(UserController userController, ProductController productController, OrderController orderController) {
        this.userView = new UserView(userController);
        this.productView = new ProductView(userController, productController, orderController);
        this.orderView = new OrderView(orderController, userController);
    }

    public void showMessage(String msg) {
        System.out.println("[알림] " + msg);
    }

    public void getUserSignup() {
        userView.getUserSignup();
    }

    public void getUserLogin() {
        userView.getUserLogin();
    }

    public void logout(){
        userView.logout();
    }

    public void showUserInfo(){
        userView.showUserInfo();
    }

    public void showAllProducts(){
        productView.showAllProducts();
    }

    public void searchProducts(){
        productView.searchProducts();
    }

    public void addProductView(){
        productView.addProductView();
    }

    public void showMyProducts(){
        productView.showMyProducts();
    }

    public void showMyOrders(){
        orderView.showMyOrders();
    }

    public boolean isLoggedIn() {
        return userView.isAuthenticated();
    }

}