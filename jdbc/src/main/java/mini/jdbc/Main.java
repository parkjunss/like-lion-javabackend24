package mini.jdbc;

import mini.jdbc.utils.InputUtil;
import mini.jdbc.views.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        boolean isRunning = true;
        boolean isLoggedIn = false;

        System.out.println("========= WELCOME TO MINI SHOP =========");

        while (isRunning) {
            if (!isLoggedIn) {
                System.out.println("\n1. 회원가입 | 2. 로그인 | 3. 종료");
                int choice = InputUtil.readInt("선택");

                switch (choice) {
                    case 1:
                        view.getUserSignup();
                        break;
                    case 2:
                        try{
                            view.getUserLogin();
                        }catch(Exception e){
                            System.out.println("[ 오류 ] 1, 2, 3 중에 하나를 입력하세요");
                        }
                        isLoggedIn = view.isLoggedIn();
                        if (isLoggedIn) {
                            view.showMessage("로그인에 성공했습니다.");
                        } else {
                            view.showMessage("로그인 실패. 아이디와 비밀번호를 확인하세요.");
                        }
                        break;
                    case 3:
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

                    switch (choice) {
                        case 1: view.showUserInfo(); break;
                        case 2: view.showAllProducts(); break;
                        case 3: view.searchProducts(); break;
                        case 4: view.addProductView(); break;
                        case 5: view.showMyProducts(); break;
                        case 6: view.showMyOrders(); break;
                        case 7: isLoggedIn = false; break;
                        default: System.out.println("잘못된 입력입니다.");
                    }
                }
            }
        }
        InputUtil.close();
    }
}