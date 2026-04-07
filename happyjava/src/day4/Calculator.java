package day4;

public class Calculator {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String operator = args[2];
        int answer = 0;

        switch (operator) {
            case "+": answer = num1 + num2; break;
            case "-": answer = num1 - num2; break;
            case "*": answer = num1 * num2; break;
            case "/":
                if (num2 == 0) {
                    return;
                }
                answer = num1 / num2;
                break;
            default:
                return;
        }

        System.out.printf("%d %s %d = %d%n", num1, operator, num2, answer);
    }
}