package day6;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Division by zero");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int num1 = 10;
        int num2 = 5;
        System.out.println("더하기 결과: " + calculator.add(num1, num2));
        System.out.println("빼기 결과: " + calculator.subtract(num1, num2));
        System.out.println("곱하기 결과: " + calculator.multiply(num1, num2));
        System.out.println("나누기 결과: " + calculator.divide(num1, num2));
    }
}
