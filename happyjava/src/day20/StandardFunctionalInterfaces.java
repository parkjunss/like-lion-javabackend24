package day20;

import java.util.function.*;

@FunctionalInterface
interface MyFunction<T, R> {
    R apply(T t);
}

public class StandardFunctionalInterfaces {
    public static void main(String[] args) {
//        // Predicate<T> - 매개변수 하나, boolean 반환
//        Predicate<Integer> isEven = num -> num % 2 == 0;
//        Predicate<Integer> isOdd = num -> num % 2 != 0;
//
//        System.out.println(isEven.test(4)); // true
//        System.out.println(isEven.test(5)); // false
//
//        System.out.println(isOdd.test(5));
//        System.out.println(isOdd.test(6));

        // Function<T, R> - 매개변수 하나, 다른 타입 반환
        MyFunction<String, Integer> stringLength = str -> str.length();
        System.out.println(stringLength.apply("Hello")); // 5

//        Function<Integer, Integer> addOneNum = num -> num + num;
//        System.out.println(addOneNum.apply(10));
//
//        // Consumer<T> - 매개변수 하나, 반환값 없음
//        Consumer<String> printer = str -> System.out.println("출력: " + str);
//        printer.accept("람다식 테스트"); // 출력: 람다식 테스트
//
//        // Supplier<T> - 매개변수 없음, 값 반환
//        Supplier<Double> randomSupplier = () -> Math.random();
//        System.out.println("랜덤 값: " + randomSupplier.get());
//
//        // BinaryOperator<T> - 같은 타입 매개변수 두 개, 같은 타입 반환
//        BinaryOperator<Integer> add = (a, b) -> a + b;
//        System.out.println(add.apply(10, 20)); // 30
    }
}