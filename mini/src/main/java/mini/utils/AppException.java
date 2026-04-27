package mini.utils;

public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }

    public void CannotFoundUserException() {
        System.out.println("유저를 찾을 수 없습니다.");
    }
}
