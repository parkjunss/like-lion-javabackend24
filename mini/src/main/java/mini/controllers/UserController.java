package mini.controllers;

import mini.DTO.UserDTO;
import mini.services.UserService;
import mini.utils.AppException;
import mini.utils.SessionManager;

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

    public UserDTO getUser() {
        return sessionManager.getCurrentUser();
    }

    public UserDTO showUserInfo() {
        UserDTO currentUser = sessionManager.getCurrentUser();
        return userService.getUserInfo(currentUser);
    }

    public int getUserSignup(String username, String password, double balance) {
        UserDTO tempUserDTO = new UserDTO();
        tempUserDTO.setUsername(username);
        tempUserDTO.setPassword(password);
        tempUserDTO.setBalance(balance);
        return userService.registerUser(tempUserDTO);
    }

    public void deleteUser(String inputPassword) {
        long currentUserId = sessionManager.getCurrentUser().getId();
        userService.deleteUser(currentUserId, inputPassword);
        userService.logout();
    }

    public void updateUserName(String changeName) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        UserDTO updatedUser = userService.updateUserName(currentUser, changeName);
        userService.login(updatedUser);
    }

    public void updateUserPassword(String currentPassword, String changePassword) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        userService.updateUserPassword(currentUser, currentPassword, changePassword);
    }


    public UserDTO updateBalance(double amount) {
        UserDTO currentUser = sessionManager.getCurrentUser();
        if (currentUser == null) {
            throw new AppException("[오류] 로그인 세션이 만료되었습니다.");
        }
        return userService.updateBalance(currentUser, amount);
    }

    public boolean isAuthenticated() {
        return sessionManager.getCurrentUser() != null;
    }
}
