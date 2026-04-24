package mini.jdbc.utils;

import mini.jdbc.DTO.UserDTO;

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
        System.out.println("SessionManager: 사용자 " + userDTO.getUsername() + " 로그인 성공. 세션 상태가 설정되었습니다.");
    }

    public void logout() {
        this.currentUser = null;
        System.out.println("SessionManager: 로그아웃 처리 완료. 세션이 안전하게 초기화되었습니다.");
    }

    public UserDTO getCurrentUser() {
        return this.currentUser;
    }

    public boolean isAuthenticated() {
        return this.currentUser != null;
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