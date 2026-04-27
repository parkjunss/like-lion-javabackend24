package mini.jdbc.views;

import mini.jdbc.DTO.UserDTO;
import mini.jdbc.controllers.UserController;
import mini.jdbc.utils.InputUtil;

public class UserView {
    private final UserController userController;
    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void getUserSignup(){
        String username = InputUtil.readString("아이디");
        if(username.length() < 3){
            System.out.println("[알림] 아이디는 최소 3글자 이상이어야 합니다.");
        }
        String password = InputUtil.readPassword("비밀번호");
        if(username.length() < 5){
            System.out.println("[알림] 비밀번호는 최소 5글자 이상이어야 합니다.");
        }
        String confirmPassword = InputUtil.readPassword("비밀번호 확인");
        double balance = InputUtil.readDouble("잔고 설정");
        if(balance < 0){
            System.out.println("[알림] 잔고는 음수가 될 수 없습니다.");
        }
        if (password.equals(confirmPassword)) {
            userController.getUserSignup(username, password, balance);
        } else {
            System.out.println("잘못된 비밀번호 입니다.");
        }
    }
    public void getUserLogin(){
        String username = InputUtil.readString("아이디를 입력하세요");
        String password = InputUtil.readPassword("비밀번호를 입력하세요");
        userController.getUserLogin(username, password);
    }
    public void logout(){
        userController.logout();
    }
    public void showUserInfo() {
        UserDTO userInfo = userController.showUserInfo();
        if (userInfo == null) {
            System.out.println("[오류] 사용자 정보를 불러올 수 없습니다.");
            return;
        }

        System.out.println("\n=== [ 내 정보 ] ===");
        System.out.println("아이디: " + userInfo.getUsername());
        System.out.println("잔고: " + userInfo.getBalance() + "원");

        int option = InputUtil.readInt("1.아이디 수정 | 2.비밀번호 변경 | 3.잔고변경 | 4.회원탈퇴 | 5.뒤로가기");
        switch (option) {
            case 1:
                String changeName = InputUtil.readString("새 아이디");
                userController.updateUserName(changeName);
                break;
            case 2:
                String currentPassword = InputUtil.readPassword("현재 비밀번호");
                String changePassword = InputUtil.readPassword("바꿀 비밀번호");
                userController.updateUserPassword(currentPassword, changePassword);
                break;
            case 3:
                int balanceOption;
                while (true) {
                    balanceOption = InputUtil.readInt("1.입금 | 2.출금 | 3.취소");
                    if (balanceOption == 1 ||  balanceOption == 2 || balanceOption == 3) break;
                    System.out.println("[ 오류 ] 1, 2, 3 중에 하나를 입력하세요");
                }
                double amount = InputUtil.readDouble("금액을 입력하세요");

                if(amount <= 0){
                    System.out.println("[ 오류 ] 0원 이하의 금액은 입력할 수 없습니다.");
                }

                if (balanceOption == 2) amount = -amount;
                userController.updateBalance(amount);

                if (balanceOption == 3) break;
                break;
            case 4:
                String checkPassword = InputUtil.readPassword("탈퇴 확인을 위해 비밀번호를 입력해주세요");
                userController.signOut(checkPassword);
                break;
            case 5:
                return;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }


}
