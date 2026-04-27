package mini.services;

import mini.DAO.UserDAO;
import mini.DTO.UserDTO;
import mini.utils.AppException;
import mini.utils.FuncUtil;
import mini.utils.SessionManager;

public class UserService {
    private final SessionManager sessionManager = SessionManager.getInstance();
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int registerUser(UserDTO userDTO) {
        if (userDAO.isUsernameExists(userDTO.getUsername())) {
            throw new AppException("가입불가: 중복된 아이디입니다.");
        }
        if (userDTO.getBalance() < 0){
            throw new AppException("잔액은 0원 이상이어야 합니다.");
        }
        String encrypted = FuncUtil.encryptPassword(userDTO.getPassword());
        userDTO.setPassword(encrypted);
        return userDAO.insertUser(userDTO);
    }

    public void deleteUser(long userId, String inputPassword) {
        UserDTO user = userDAO.getUserById(userId);
        if (user == null) {
            throw new AppException("사용자를 찾을 수 없습니다.");
        }
        String encryptedInput = FuncUtil.encryptPassword(inputPassword);
        if (!user.getPassword().equals(encryptedInput)) {
            throw new AppException("비밀번호가 일치하지 않습니다.");
        }
        int result = userDAO.deleteUser(userId);
        if (result <= 0) {
            throw new AppException("삭제 중 오류가 발생했습니다.");
        }
    }

    public void login(UserDTO userDTO) {
        UserDTO foundUser = userDAO.getUserByName(userDTO.getUsername());
        if (foundUser == null) {
            throw new AppException("사용자를 찾을 수 없습니다.");
        }
        String inputEncrypted = FuncUtil.encryptPassword(userDTO.getPassword());

        if (foundUser.getPassword().equals(inputEncrypted)) {
            userDTO.setId(foundUser.getId());
            userDTO.setUsername(foundUser.getUsername());
            userDTO.setBalance(foundUser.getBalance());
            userDTO.setPassword(null);
            sessionManager.login(userDTO);
        }
    }

    public void logout() {
        try{
            sessionManager.logout();
        } catch (AppException e) {
            throw new AppException(e.getMessage());
        }
    }

    public UserDTO getUserInfo(UserDTO userDTO) {
        if (userDTO == null) {
            throw new AppException("로그인 해주세요.");
        } else {
            return userDAO.getUserById(userDTO.getId());
        }
    }
    public UserDTO updateUserName(UserDTO userDTO, String username) {
        if (userDTO == null) throw new AppException("로그인 세션이 만료되었습니다.");
        int result = userDAO.updateUsername(userDTO.getId(), username);
        if (result > 0) {
            UserDTO updatedUser = userDAO.getUserById(userDTO.getId());
            sessionManager.login(updatedUser);
            return updatedUser;
        } else {
            throw new AppException("수정 실패: 사용자를 찾을 수 없습니다.");
        }
    }

    public void updateUserPassword(UserDTO userDTO, String currentPassword, String changePassword) {
        if (userDTO != null) {
            UserDTO dbUser = userDAO.getUserByName(userDTO.getUsername());
            if (dbUser == null) {
                throw new AppException("사용자를 찾을 수 없습니다.");
            }

            String encryptedCurrent = FuncUtil.encryptPassword(currentPassword);
            if (!dbUser.getPassword().equals(encryptedCurrent)) {
                throw new AppException("현재 비밀번호가 일치하지 않습니다.");
            }

            if (currentPassword.equals(changePassword)) {
                throw new AppException("현재 비밀번호와 동일한 비밀번호로 변경할 수 없습니다.");
            }

            String encryptedNew = FuncUtil.encryptPassword(changePassword);
            int result = userDAO.updatePassword(userDTO.getId(), encryptedNew);
            if (result <= 0) throw new AppException("비밀번호 수정에 실패했습니다.");
        }
    }

    public UserDTO updateBalance(UserDTO currentUser, double amount) {
        if (currentUser == null) throw new AppException("유저 정보가 없습니다.");
        if (amount < 0 && (currentUser.getBalance() + amount < 0)) {
            throw new AppException("잔액이 부족합니다. (현재 잔고: " + currentUser.getBalance() + "원)");
        }
        int result = userDAO.updateBalance(currentUser.getId(), amount);
        if (result > 0) {
            UserDTO updatedUser = userDAO.getUserById(currentUser.getId());
            sessionManager.login(updatedUser);
            return updatedUser;
        } else {
            throw new AppException("데이터베이스 업데이트에 실패했습니다.");
        }
    }
}
