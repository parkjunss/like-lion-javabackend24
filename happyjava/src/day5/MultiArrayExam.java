package day5;

import java.util.Arrays;

public class MultiArrayExam {
    public static void main(String[] args) {
        int[][][] arr = new int[3][4][5];
//        System.out.println(Arrays.deepToString(arr));

        int[][] iarr = new int[3][];

        iarr[0] = new int[5];
        iarr[1] = new int[2];
        iarr[2] = new int[3];

        System.out.println(Arrays.deepToString(iarr));
    }
}
