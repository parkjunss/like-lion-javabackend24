package day10;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("김철수", 85));
        students.add(new Student("이영희", 92));
        students.add(new Student("박민수", 78));
        students.add(new Student("정수진", 92));

        // 1. Comparable을 이용한 기본 정렬 (점수 내림차순)
        Collections.sort(students);
        System.out.println("점수 내림차순: " + students);

        // 2. Comparator를 이용한 이름순 정렬
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        System.out.println("이름 오름차순: " + students);

        // 3. Lambda를 이용한 간단한 표현 (Java 8+)
        Collections.sort(students, (s1, s2) -> s1.getScore() - s2.getScore());
        System.out.println("점수 오름차순: " + students);

        // 4. Comparator의 정적 메소드 활용 (Java 8+)
        students.sort(Comparator.comparing(Student::getName).reversed());
        System.out.println("이름 내림차순: " + students);

        // 5. 복합 정렬: 점수로 먼저, 같으면 이름으로
        students.sort(Comparator.comparing(Student::getScore)
                .thenComparing(Student::getName));
        System.out.println("점수 후 이름순: " + students);
    }
}