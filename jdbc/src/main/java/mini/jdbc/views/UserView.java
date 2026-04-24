package mini.jdbc.views;

import mini.jdbc.DTO.UserDTO;
import mini.jdbc.controllers.UserController;
import mini.jdbc.utils.InputUtil;

public class UserView {
    UserController userController = new UserController();

    public void getUserSignup(){
        String username = InputUtil.readString("아이디");
        String password = InputUtil.readString("비밀번호");
        String confirmPassword = InputUtil.readString("비밀번호 확인");
        double balance = InputUtil.readDouble("잔고 설정");
        if (password.equals(confirmPassword)) {
            userController.getUserSignup(username, password, balance);
        } else {
            System.out.println("잘못된 비밀번호 입니다.");
        }
    }
    public void getUserLogin(){
        String username = InputUtil.readString("아이디를 입력하세요");
        String password = InputUtil.readString("비밀번호를 입력하세요");
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
                String currentPassword = InputUtil.readString("현재 비밀번호");
                String changePassword = InputUtil.readString("바꿀 비밀번호");
                userController.updateUserPassword(currentPassword, changePassword);
                break;
            case 3:
                int balanceOption = InputUtil.readInt("1.입금 | 2.출금");
                double amount = InputUtil.readDouble("금액을 입력하세요");
                if (balanceOption == 2) amount = -amount;
                userController.updateBalance(amount);
                break;
            case 4:
                String checkPassword = InputUtil.readString("탈퇴 확인을 위해 비밀번호를 입력해주세요");
                userController.signOut(checkPassword);
                break;
            case 5:
                return;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }


}
