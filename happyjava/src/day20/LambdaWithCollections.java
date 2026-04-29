package day20;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaWithCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");

        List<String> names = Arrays.asList("abc", "bbc", "cbc");
        names.forEach(System.out::println);

        names.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);


        List<String> upperStrings = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        upperStrings.forEach(System.out::println);

        names.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 필터링하고 제곱한 후 합계 구하기
        int sumOfEvens = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sumOfEvens);

        Supplier<List<Integer>> numbers2 = ArrayList::new;

    }
}
