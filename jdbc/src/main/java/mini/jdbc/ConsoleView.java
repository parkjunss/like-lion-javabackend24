package mini.jdbc;

import mini.jdbc.utils.SessionManager;
import mini.jdbc.views.OrderView;
import mini.jdbc.views.ProductView;
import mini.jdbc.views.UserView;

public class ConsoleView {
    SessionManager sessionManager = SessionManager.getInstance();
    UserView userView = new UserView();
    ProductView productView = new ProductView();
    OrderView orderView = new OrderView();

    public void showMessage(String msg) {
        System.out.println("[Info] " + msg);
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


}