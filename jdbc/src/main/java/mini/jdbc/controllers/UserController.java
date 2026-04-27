package mini.jdbc.controllers;

import mini.jdbc.DTO.UserDTO;
import mini.jdbc.services.UserService;
import mini.jdbc.utils.SessionManager;

public class UserController {

    private final SessionManager sessionManager;
    private final UserService userService;

    public UserController(UserService userService, SessionManager sessionManager) {
        this.userService = userService;
        this.sessionManager = sessionManager;
    }

    public void getUserLogin(String username, String password) {
        UserDTO loginUser = new UserDTO();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        userService.login(loginUser);
    }

    public void logout() {
        userService.logout();
    }

    public void signOut(String checkPassword) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser.getPassword().equals(checkPassword)) {
            if (userService.deleteUser(currentUser.getId())) {
                sessionManager.logout();
                System.out.println("[완료] 회원 탈퇴되었습니다. 메인 화면으로 돌아갑니다.");
            }
        } else {
            System.out.println("[실패] 비밀번호가 일치하지 않습니다.");
        }
    }

    public void getUserSignup(String username, String password, double balance) {
        UserDTO tempUserDTO = new UserDTO();
        tempUserDTO.setUsername(username);
        tempUserDTO.setPassword(password);
        tempUserDTO.setBalance(balance);
        userService.registerUser(tempUserDTO);
    }


    public UserDTO showUserInfo() {
        UserDTO currentUser = sessionManager.getCurrentUser();
        return userService.getUserInfo(currentUser);
    }

    public void updateUserName(String changeName) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        userService.updateUserName(currentUser, changeName);
    }

    public void updateUserPassword(String currentPassword, String changePassword) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        userService.updateUserPassword(currentUser, currentPassword, changePassword);
    }


    public void updateBalance(double amount) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            System.out.println("[오류] 로그인 세션이 만료되었습니다.");
            return;
        }

        if (amount < 0 && (currentUser.getBalance() + amount < 0)) {
            System.out.println("[실패] 잔액이 부족합니다. (현재 잔고: " + currentUser.getBalance() + "원)");
            return;
        }

        boolean success = userService.updateBalance(currentUser, amount);
        
        if (success) {
            System.out.println("[성공] 잔고가 정상적으로 갱신되었습니다. (현재 잔고: " + currentUser.getBalance() + "원)");
        } else {
            System.out.println("[실패] 데이터베이스 업데이트 중 오류가 발생했습니다.");
        }
    }



    public UserDTO getUser() {
        return sessionManager.getCurrentUser();
    }
}
