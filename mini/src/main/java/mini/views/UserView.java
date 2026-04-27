package mini.views;

import mini.DTO.UserDTO;
import mini.controllers.UserController;
import mini.utils.AppException;
import mini.utils.InputUtil;

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
        if(password.length() < 6){
            System.out.println("[알림] 비밀번호는 최소 6글자 이상이어야 합니다.");
        }
        String confirmPassword = InputUtil.readPassword("비밀번호 확인");
        double balance = InputUtil.readDouble("잔고 설정");
        if(balance < 0){
            System.out.println("[알림] 잔고는 음수가 될 수 없습니다.");
        }
        try{
            if (password.equals(confirmPassword)) {
                int result = userController.getUserSignup(username, password, balance);
                if(result > 0){
                    System.out.println(userController.getUser().getUsername() + "님, 가입을 축하합니다.");
                }
            } else {
                System.out.println("잘못된 비밀번호 입니다.");
            }
        } catch(AppException e){
            System.out.println("[가입 실패] " + e.getMessage());
        }

    }
    public void getUserLogin(){
        String username = InputUtil.readString("아이디를 입력하세요");
        String password = InputUtil.readPassword("비밀번호를 입력하세요");
        try{
            userController.getUserLogin(username, password);
            System.out.println(userController.getUser().getUsername() + "님, 환영합니다.");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
    }
    public void logout(){
        try {
            userController.logout();
            System.out.println("로그아웃 되었습니다.");
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
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
                try{
                    String changeName = InputUtil.readString("새 아이디");
                    userController.updateUserName(changeName);
                    System.out.println("[알림] 아이디 수정 완료!");
                } catch (AppException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try{
                    String currentPassword = InputUtil.readPassword("현재 비밀번호");
                    String changePassword = InputUtil.readPassword("바꿀 비밀번호");
                    userController.updateUserPassword(currentPassword, changePassword);
                    System.out.println("[알림] 비밀번호 수정 완료!");

                } catch (AppException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                int balanceOption = InputUtil.readInt("1.입금 | 2.출금 | 3.취소");
                if (balanceOption == 3) break;
                if (balanceOption != 1 && balanceOption != 2) {
                    System.out.println("[ 오류 ] 1, 2 중에 하나를 입력하세요");
                    break;
                }
                double amount = InputUtil.readDouble("금액을 입력하세요");
                if(amount <= 0){
                    System.out.println("[오류] 0원 이하의 금액은 입력할 수 없습니다.");
                    break;
                }
                if (balanceOption == 2) amount = -amount;
                try{
                    UserDTO updatedUser = userController.updateBalance(amount);
                    System.out.println("[성공] 잔고가 정상적으로 갱신되었습니다.");
                    System.out.println("[현재 잔고: " + updatedUser.getBalance() + "원]");
                } catch (AppException e) {
                    System.out.println("[실패] " + e.getMessage());
                }
                break;
            case 4:
                String checkPassword = InputUtil.readPassword("탈퇴 확인을 위해 비밀번호를 입력해주세요");
                try{
                    userController.deleteUser(checkPassword);
                    System.out.println("유저 삭제 성공");
                } catch (AppException e) {
                    System.out.println("사용자 삭제에 실패했습니다.");
                }
                break;
            case 5:
                return;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }


    public boolean isAuthenticated() {
        return userController.isAuthenticated();
    }
}
