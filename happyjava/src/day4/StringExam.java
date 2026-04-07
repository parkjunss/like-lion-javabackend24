package day4;

import java.util.Arrays;
import java.util.Scanner;

public class StringExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        int repeat = sc.nextInt();

        String hello = "";
        for  (int i = 0; i < repeat; i++){
            hello += "hello";
        }
        System.out.println(hello);
    }
}
