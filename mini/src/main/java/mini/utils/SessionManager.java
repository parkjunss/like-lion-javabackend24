package mini.utils;

import mini.DTO.UserDTO;

public class SessionManager {
    private static SessionManager instance = null;
    private UserDTO currentUser;

    private SessionManager() {
        this.currentUser = null;
        System.out.println("SessionManager: 새로운 세션이 시작되었습니다.");
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(UserDTO userDTO) {
        if (userDTO == null || userDTO.getId() <= 0) {
            throw new IllegalStateException("로그인할 유효한 사용자 정보가 없습니다.");
        }
        this.currentUser = userDTO;
    }

    public void logout() {
        this.currentUser = null;
    }

    public UserDTO getCurrentUser() {
        return this.currentUser;
    }

    public void updateSessionState(UserDTO latestUserDTO) {
        if (latestUserDTO == null) {
            System.out.println("[Warning] 상태 동기화에 실패했습니다. (DTO가 null)");
            return;
        }
        this.currentUser = latestUserDTO;
        System.out.println("[INFO] 세션 상태가 외부 DB 트랜잭션 결과를 반영하여 업데이트되었습니다.");
    }
}