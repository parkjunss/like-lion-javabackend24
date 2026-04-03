package day3;
import java.util.Scanner;

public class IfElseIfPractice1 {
    public static void main(String[] args) {
        boolean condition = true;
        while (condition){
//            System.out.println("미세먼지를 입력하세요");
//            Scanner dust = new Scanner(System.in); // 미세먼지 수치
//            int intDust = dust.nextInt();
            int intDust = Integer.parseInt(args[0]);
            // if-else if문을 사용하여 미세먼지 상태를 출력하세요.
            // 여기에 코드를 작성하세요.
            // 조건 1: 30 이하이면 "좋음"
            if (intDust <= 30) {
                System.out.println("좋음");
            // 조건 2: 80 이하이면 "보통"
            } else if (intDust <= 80) {
                System.out.println("보통");
            // 조건 3: 150 이하이면 "나쁨"
            } else if (intDust <= 150) {
                System.out.println("나쁨");
            // 그 외 (151 이상): "매우 나쁨"
            } else {
                System.out.println("매우 나쁨");
            }
            System.out.println("Continue? y/n");
            Scanner userCondition = new Scanner(System.in);
            char charCondition = userCondition.next().charAt(0);
            if (charCondition == 'n'){
                condition = false;
            }
        }

        System.out.println("Bye");

    }
}