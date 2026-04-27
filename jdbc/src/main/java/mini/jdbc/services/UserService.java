package mini.jdbc.services;

import mini.jdbc.DAO.UserDAO;
import mini.jdbc.DTO.UserDTO;
import mini.jdbc.utils.FuncUtil;
import mini.jdbc.utils.SessionManager;
import java.util.Objects;

public class UserService {
    private final SessionManager sessionManager = SessionManager.getInstance();
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(UserDTO userDTO) {
        if (userDAO.isUsernameExists(userDTO.getUsername())) {
            System.out.println("가입 불가: 중복된 아이디입니다.");
            return;
        }

        String encrypted = FuncUtil.encryptPassword(userDTO.getPassword());
        userDTO.setPassword(encrypted);

        int result = userDAO.insertUser(userDTO);
        if (result > 0) {
            System.out.println(userDTO.getUsername() + "님, 가입을 축하합니다!");
        }
    }

    public boolean deleteUser(long id) {
        userDAO.deleteUser(id);
        return true;
    }

    public void login(UserDTO userDTO) {
        UserDTO foundUser = userDAO.getUserByName(userDTO.getUsername());
        if (foundUser == null) {
            return;
        }
        String inputEncrypted = FuncUtil.encryptPassword(userDTO.getPassword());

        if (Objects.requireNonNull(foundUser).getPassword().equals(inputEncrypted)) {
            userDTO.setId(foundUser.getId());
            userDTO.setUsername(foundUser.getUsername());
            userDTO.setBalance(foundUser.getBalance());
            userDTO.setPassword(null);
            sessionManager.login(userDTO);
        }
    }

    public void logout() {
        sessionManager.logout();
        System.out.println("로그아웃 되었습니다. 세션이 초기화되었습니다.");
    }

    public UserDTO getUserInfo(UserDTO userDTO) {
        if (userDTO == null) {
            System.out.println("로그인 해주세요.");
        } else {
            return userDAO.getUserById(userDTO.getId());
        }
        return null;
    }
    public void updateUserName(UserDTO userDTO, String username) {
        if (userDTO != null) {
            int result = userDAO.updateUsername(userDTO.getId(), username);
            if (result > 0) {
                userDTO.setUsername(username);
                System.out.println("아이디가 수정되었습니다.");
            } else {
                System.out.println("수정 실패: 사용자를 찾을 수 없습니다.");
            }
        }
    }

    public void updateUserPassword(UserDTO userDTO, String currentPassword, String changePassword) {
        if (userDTO != null) {
            UserDTO dbUser = userDAO.getUserByName(userDTO.getUsername());
            if (dbUser == null) {
                System.out.println("사용자 정보를 찾을 수 없습니다.");
                return;
            }

            String encryptedCurrent = FuncUtil.encryptPassword(currentPassword);
            if (!dbUser.getPassword().equals(encryptedCurrent)) {
                System.out.println("현재 비밀번호가 일치하지 않습니다.");
                return;
            }

            if (currentPassword.equals(changePassword)) {
                System.out.println("현재 비밀번호와 동일한 비밀번호로 변경할 수 없습니다.");
                return;
            }

            String encryptedNew = FuncUtil.encryptPassword(changePassword);
            int result = userDAO.updatePassword(userDTO.getId(), encryptedNew);
            if (result > 0) {
                System.out.println("비밀번호가 성공적으로 변경되었습니다.");
            } else {
                System.out.println("수정 실패: 오류가 발생했습니다.");
            }
        }
    }

    public boolean updateBalance(UserDTO currentUser, double amount) {
        if (currentUser == null) return false;

        double newBalance = currentUser.getBalance() + amount;
        if (newBalance < 0) {
            return false;
        }

        int result = userDAO.updateBalance(currentUser.getId(), newBalance);
        if (result > 0) {
            currentUser.setBalance(newBalance);
            return true;
        }
        return false;
    }
}
