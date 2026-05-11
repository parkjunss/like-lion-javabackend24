package day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExam {
    public static void main(String[] args) {
        int[] iarr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : iarr) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        Arrays.stream(iarr).filter(i -> i % 2 == 0).forEach(System.out::println);

        List<String> list = Arrays.asList("Java", "Python", "C#", "JavaScript", "C#");
        Stream<String> streamStringList = list.stream();
        streamStringList.forEach(System.out::println);

        Stream<Integer> streamInteger = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        streamInteger.forEach(System.out::println);

        Stream<Integer> streamInteger2 = Stream.iterate(0, i -> i + 2).limit(10);
        streamInteger2.forEach(System.out::println);

        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
        randomStream.forEach(System.out::println);

        String[] array = {"Java", "Python", "C#", "JavaScript", "C#"};
        Stream<String> partialStream = Arrays.stream(array, 0, 3);
        List<String> toList = partialStream.toList();
        System.out.println(toList);




    }
}
