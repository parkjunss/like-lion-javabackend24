package day21;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    private String name;
    private Map<String, Integer> scores;

    public Student(String name, Map<String, Integer> scores) {
        this.name = name;
        this.scores = scores;
    }

    // TODO: 필요한 메서드 구현
    public String getName() {
        return name;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public double getAverageScore() {
        return scores.values()
                .stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }

    public String getGrade() {
        double score = getAverageScore();
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        }  else if (score >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }
}

public class GradeProcessor {

    public static void main(String[] args) {
       // TODO: 학생 데이터 생성 및 처리
        List<Student> students = Arrays.asList(
                new Student("Sam", Map.of("math", 95, "english", 80, "science", 90)),
                new Student("John", Map.of("math", 70, "english", 85, "science", 75)),
                new Student("Jon", Map.of("math", 70, "english", 80, "science", 70)),
                new Student("Hon", Map.of("math", 80, "english", 70, "science", 75)),
                new Student("Don", Map.of("math", 90, "english", 60, "science", 88)),
                new Student("Emma", Map.of("math", 100, "english", 95, "science", 98))
        );

        // 평균 점수가 80점 이상인 학생 찾기
        students.stream()
                .filter(student ->  student.getAverageScore() >= 80)
                .forEach((student -> System.out.printf("%s : %.2f\n", student.getName(), student.getAverageScore())));


        // 전체 학생의 평균 점수 계산
        students.stream()
                .mapToDouble(Student::getAverageScore)
                .average()
                .ifPresent(scores -> System.out.printf("Average score: %.2f\n", scores));


        // 과목별 최고 점수 구하기
        students.stream()
                .flatMap(student -> student.getScores().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::max))
                .forEach((subject, score ) -> System.out.printf("Top score of %s : %d\n", subject, score));


        // 학생을 등급별로 분류 (A: 90이상, B: 80-89, C: 70-79, D: 70미만)
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        TreeMap::new,
                        Collectors.mapping(Student::getName, Collectors.toList())
                )).forEach((grade, names) -> System.out.printf("%s : %s\n", grade, names));

    }
}
