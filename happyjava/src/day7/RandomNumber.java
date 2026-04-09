package day7;


import java.util.Scanner;

public class RandomNumber {
    private final int target;
    private boolean answer = false;

    public RandomNumber() {
        this.target = (int) (Math.random()*100)+1;
    }

    public void userRandomNumber(Scanner input) {
        do {
            System.out.print("Enter a number: ");
            int number = input.nextInt();
            if (number < target) {
                System.out.println("더 큰 수를 입력하세요.");
            } else if (number > target) {
                System.out.println("더 작은 수를 입력하세요.");
            } else {
                answer = true;
                System.out.println("정답입니다.");
            }
        } while (!answer);
    }

}
