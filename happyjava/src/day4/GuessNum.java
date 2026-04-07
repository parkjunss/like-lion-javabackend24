package day4;

import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        int target = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("입력값: ");
            int userAnswer = sc.nextInt();
            if(userAnswer == target){
                System.out.println("정답입니다!");
                break;
            } else if(userAnswer > target){
                System.out.println("더 낮습니다!");
            } else if(userAnswer < target){
                System.out.println("더 높습니다!");
            }
        }

    }
}
