package day4;

import java.util.Scanner;

public class OddEvenDisc {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int num = Integer.parseInt(args[i]);
            if (num % 2 == 0){
                System.out.printf("%d은 짝수입니다.\n", num);
            } else {
                System.out.printf("%d은 홀수입니다.\n", num);
            }
        }
    }
}
