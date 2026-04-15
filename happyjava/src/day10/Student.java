package day10;

import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 기본 정렬: 점수 기준 내림차순
    @Override
    public int compareTo(Student other) {
        return other.score - this.score; // 내림차순
        // return this.score - other.score; // 오름차순
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }

    // getter 메소드들
    public String getName() { return name; }
    public int getScore() { return score; }
}