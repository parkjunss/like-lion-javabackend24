package day21;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class aStudent{
    String name;
    int score;
    String department;
    aStudent(String name,int score,String department){
        this.name=name;
        this.score=score;
        this.department=department;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getDepartment() {
        return department;
    }

}

public class CollectorsExample {
    public static void main(String[] args) {
        List<aStudent> students = Arrays.asList(
                new aStudent("Alice", 85, "CS"),
                new aStudent("Bob", 92, "Math"),
                new aStudent("Charlie", 78, "CS"),
                new aStudent("David", 88, "Physics"),
                new aStudent("Eve", 95, "Math")
        );

        List<String> names = students.stream()
                .map(aStudent::getName)
                .toList();
        Set<String> departments = students.stream()
                .map(aStudent::getDepartment)
                .collect(Collectors.toSet());
        Map<String, Integer> scoreMap = students.stream()
                .collect(Collectors.toMap(
                        aStudent::getName,
                        aStudent::getScore
                ));

        String allName = students.stream()
                        .map(aStudent::getName)
                        .collect(Collectors.joining(", "));

        System.out.println("Names: " + names);
        System.out.println("Departments: " + departments);
        System.out.println("Scores: " + scoreMap);
        System.out.println("All Names: " + allName);

    }
}
