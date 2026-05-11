package day20;

@FunctionalInterface
interface Calculator<T, R> {
    // 소수점 계산 하려고 더블로 받음
    R calculate(T a, T b);
}

public class CalculatorPractice {

    public static double calculate(double a, double b, Calculator<Double, Double> calc) {
        // TODO: 구현하세요
        // 처음에는 calc 안 쓰고 calculate 써서 에러 뜸
        return calc.calculate(a, b);
    }

    public static void main(String[] args) {
        // TODO: 여기에 람다식으로 사칙연산을 구현하세요
        Calculator<Double, Double> add = (a, b) -> a + b;
        Calculator<Double, Double> subtract = (a, b) -> a - b;
        Calculator<Double, Double> multiply = (a, b) -> a * b;
        Calculator<Double, Double> divide = (a, b) -> a / b;

        // TODO: calculate 메서드를 완성하세요
        System.out.println("10 + 5 = " + calculate(10, 5, add));
        System.out.println("10 + 5 = " + calculate(10, 5, subtract));
        System.out.println("10 + 5 = " + calculate(10, 5, multiply));
        System.out.println("10 + 5 = " + calculate(10, 5, divide));
    }


}