package mini;

import mini.DAO.OrderDAO;
import mini.DAO.ProductDAO;
import mini.DAO.UserDAO;
import mini.controllers.OrderController;
import mini.controllers.ProductController;
import mini.controllers.UserController;
import mini.services.OrderService;
import mini.services.ProductService;
import mini.services.UserService;
import mini.utils.InputUtil;
import mini.utils.Menu;
import mini.utils.SessionManager;
import mini.views.ConsoleView;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }

        SessionManager sessionManager = SessionManager.getInstance();
        UserDAO userDAO = new UserDAO();
        OrderDAO orderDAO = new OrderDAO();
        ProductDAO productDAO = new ProductDAO();

        UserService userService = new UserService(userDAO);
        ProductService productService = new ProductService(productDAO);
        OrderService orderService = new OrderService(productDAO, userDAO, orderDAO);

        UserController userController = new UserController(userService, sessionManager);
        ProductController productController = new ProductController(productService, sessionManager);
        OrderController orderController = new OrderController(orderService, sessionManager);

        ConsoleView view = new ConsoleView(userController, productController, orderController);
        boolean isRunning = true;
        boolean isLoggedIn = false;

        System.out.println("========= WELCOME TO MINI SHOP =========");

        while (isRunning) {
            if (!isLoggedIn) {
                System.out.println("\n1. 회원가입 | 2. 로그인 | 3. 종료");
                int choice = InputUtil.readInt("선택");
                Menu.MainMenu mainMenu = Menu.MainMenu.getMainMenu(choice);

                switch (mainMenu) {
                    case SIGNUP:
                        view.getUserSignup();
                        break;
                    case LOGIN:
                        view.getUserLogin();
                        isLoggedIn = view.isLoggedIn();
                        if (isLoggedIn) {
                            view.showMessage("로그인에 성공했습니다.");
                        } else {
                            view.showMessage("로그인 실패. 아이디와 비밀번호를 확인하세요.");
                        }
                        break;
                    case EXIT:
                        isRunning = false;
                        view.logout();
                        view.showMessage("프로그램을 종료합니다.");
                        break;
                    default:
                        view.showMessage("잘못된 선택입니다.");
                }
            } else {
                while (isLoggedIn) {
                    System.out.println("\n========= [ MAIN MENU ] =========");
                    System.out.println("1. 내 정보 | 2. 전체 상품 보기 | 3. 상품 검색 | 4.상품 등록");
                    System.out.println("5. 내 상품보기 | 6. 내 구매 내역 | 7. 로그아웃");

                    int choice = InputUtil.readInt("선택");
                    Menu.SubMenu subMenu = Menu.SubMenu.getSubMenu(choice);
                    switch (subMenu) {
                        case USER_INFO: view.showUserInfo(); break;
                        case All_PRODUCTS: view.showAllProducts(); break;
                        case SEARCH_PRODUCT: view.searchProducts(); break;
                        case REGISTER_PRODUCT: view.addProductView(); break;
                        case MY_PRODUCT: view.showMyProducts(); break;
                        case MY_ORDER: view.showMyOrders(); break;
                        case LOGOUT: isLoggedIn = false; break;
                        default: System.out.println("잘못된 입력입니다.");
                    }
                }
            }
        }
        InputUtil.close();
    }
}