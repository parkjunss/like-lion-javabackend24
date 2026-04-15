package day11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionCalculator {

    // 나눗셈을 수행하는 메소드
    public double divide(double a, double b) {
        // TODO: 0으로 나누기 예외 처리 추가
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        DivisionCalculator calc = new DivisionCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 나눗셈 계산기 ===");

        // TODO: 숫자가 아닌 입력에 대한 예외 처리 추가
        try {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = scanner.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = scanner.nextDouble();
            // TODO: divide 메소드에서 발생하는 예외 처리 추가
            double result = calc.divide(num1, num2);
            System.out.println("결과: " + num1 + " ÷ " + num2 + " = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Close");
        }

    }
}