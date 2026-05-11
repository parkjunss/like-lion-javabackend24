package day21;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogAnalyzer {
    public static void main(String[] args) {
        List<String> logLines = Arrays.asList(
                "2024-01-01 10:00:00 INFO User login: alice",
                "2024-01-01 10:05:00 ERROR Database connection failed",
                "2024-01-01 10:10:00 INFO User logout: alice",
                "2024-01-01 10:15:00 WARN Memory usage high",
                "2024-01-01 10:20:00 ERROR File not found: config.xml",
                "2024-01-01 10:25:00 INFO User login: bob"
        );

        // ERROR 로그만 추출
        System.out.println("=== ERROR 로그 ===");
        logLines.stream()
                .filter(line -> line.contains("ERROR"))
                .forEach(System.out::println);

        // 로그 레벨별 카운트
        System.out.println("\n=== 로그 레벨별 카운트 ===");
        Map<String, Long> logCounts = logLines.stream()
                .map(line -> line.split(" ")[2])
                .collect(Collectors.groupingBy(
                        level -> level,
                        Collectors.counting()
                ));

        logCounts.forEach((level, count) ->
                System.out.println(level + ": " + count)
        );
    }
}