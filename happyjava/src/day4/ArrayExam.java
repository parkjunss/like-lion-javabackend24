package day4;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam {
    public static void main(String[] args) {
        int[] iarr = new int[5];

        for (int j = 0; j < iarr.length; j++) {
            iarr[j] = j + 1;
        }

        System.out.println(Arrays.toString(iarr));

        String[] sarr = new String[5];
        for (int j = 0; j < sarr.length; j++) {
            sarr[j] = j + 1 + "헤이헤이헤이";
        }

        System.out.println(Arrays.toString(sarr));

        int[] sarr2 = new int[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.printf("please enter a %d student's score\n", i+1);
            sarr2[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < sarr2.length; i++) {
            sum += sarr2[i];
        }

        System.out.println("sum = " + sum);
        System.out.println("mean = " + sum / 5);
    }
}
