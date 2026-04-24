package mini.jdbc.utils;

import java.util.Scanner;

public class InputUtil {
    public static Scanner sc = new Scanner(System.in);

    public static String readString(String msg) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

    public static int readInt(String msg) {
        System.out.print(msg + ": ");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("숫자만 입력해주세요: ");
        }
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    public static double readDouble(String msg) {
        System.out.print(msg + ": ");
        String input = sc.nextLine();
        return Double.parseDouble(input);
    }

    public static void close() {
        sc.close();
    }
}
