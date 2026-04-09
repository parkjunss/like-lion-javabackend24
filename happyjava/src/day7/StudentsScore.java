package day7;

import java.util.Scanner;

public class StudentsScore {
    private int[] scores;
    private int students;
    private int count;

    public StudentsScore(int students) {
        this.students = students;
        scores = new int[students];
        count = 0;
    }

    public int[] getScores(Scanner input) {
        for (int i = 0; i < scores.length; i++) {
            do {
                System.out.print("Enter Student Score " + (i+1) + ": ");
                scores[i] = input.nextInt();

                if (scores[i] < 0) {
                    System.out.println("You Can't enter a negative score");
                }
            } while (scores[i] < 0);
        }
        return scores;
    }

    public double getMeanScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return (double) total / students; // 소수점까지 나오게 형변환
    }

    public int getMaxScore() {
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public int overTargetScore(int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= target) {
                count++;
            }
        }
        return count;
    }


    public void printScores() {
        System.out.println("Student Mean Scores: " +  getMeanScore());
        System.out.println("Student Max Scores: " +  getMaxScore());
        System.out.println("Students Over Target Scores: " +  count);
    }

}
