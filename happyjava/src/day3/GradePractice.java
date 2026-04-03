package day3;

public class GradePractice {
    public static void main(String[] args) {
        int score = 96;
        String grade = "F";
        String sign = "";

        if (score < 0 || score > 100) {
            System.out.println("잘못된 점수");
            return;
        }

        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        }

        if (!grade.equals("F")) {
            int detail = score % 10;
            if (score == 100 || detail >= 7) {
                sign = "+";
            } else if (detail <= 3) {
                sign = "-";
            }
        }
        System.out.println("점수: " + score);
        System.out.println("학점: " + grade + sign);
        if (score == 100) {
            System.out.println("만점!");
        }
    }
}