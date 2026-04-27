package mini.jdbc.views;

import mini.jdbc.DAO.OrderDAO;
import mini.jdbc.DAO.ProductDAO;
import mini.jdbc.DAO.UserDAO;
import mini.jdbc.controllers.OrderController;
import mini.jdbc.controllers.ProductController;
import mini.jdbc.controllers.UserController;
import mini.jdbc.services.OrderService;
import mini.jdbc.services.ProductService;
import mini.jdbc.services.UserService;
import mini.jdbc.utils.SessionManager;

public class ConsoleView {
    private final SessionManager sessionManager;
    private final UserView userView;
    private final ProductView productView;
    private final OrderView orderView;

    public ConsoleView(){
        this.sessionManager = SessionManager.getInstance();
        UserDAO userDAO = new UserDAO();
        OrderDAO orderDAO = new OrderDAO();
        ProductDAO productDAO = new ProductDAO();

        UserService userService = new UserService(userDAO);
        ProductService productService = new ProductService(productDAO);
        OrderService orderService = new OrderService(productDAO, userDAO, orderDAO);

        UserController userController = new UserController(userService, sessionManager);
        ProductController productController = new ProductController(productService, sessionManager);
        OrderController orderController = new OrderController(orderService, sessionManager);

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
        return sessionManager.isAuthenticated();
    }


}