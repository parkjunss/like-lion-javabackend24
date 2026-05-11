package day20;

import java.util.function.*;

public class StringTransformer {
    public static void main(String[] args) {
        // TODO: 문자열 변환 람다식 구현
        // str -> str.toUpperCase() == String::toUpperCase
        // 타입::메서드 ??
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> toLowerCase = String::toLowerCase;
        Function<String, String> reverse = (String str) -> {
            StringBuilder reversed = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                reversed.append(str.charAt(i));
            }
            return reversed.toString();
        };

        // TODO: transform 메서드로 테스트
        System.out.println(transform("Hello", toUpperCase));
        System.out.println(transform("Hello", toLowerCase));
        System.out.println(transform("Hello", reverse));

    }

    public static String transform(String str, Function<String, String> transformer) {
        // TODO: 구현하세요
        return transformer.apply(str);
    }
}