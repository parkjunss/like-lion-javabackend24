package mini.utils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputUtil {
    public static Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    public static String readString(String msg) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

    public static String readPassword(String msg) {
        java.io.Console console = System.console();
        if (console == null) {
            return readString(msg + " (보안입력 미지원)");
        }
        char[] passwordChars = console.readPassword(msg + ": ");
        return new String(passwordChars);
    }

    public static int readInt(String msg) {
        while (true){
            try {
                System.out.print(msg + ": ");
                String input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[오류] 숫자만 입력 가능합니다. 다시 입력해주세요.");
            }
        }
    }

    public static double readDouble(String msg) {
        while (true){
            try {
                System.out.print(msg + ": ");
                String input = sc.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("[오류] 숫자만 입력 가능합니다. 다시 입력해주세요.");
            }
        }
    }

    public static void close() {
        sc.close();
    }
}
