package day7;

import java.util.Arrays;

public class GuGu {
    int dan;
    int[][] gugudans;

    GuGu(int dan) {
        this.dan = dan-1;
        gugudans = new int[dan][9];;
    }
    public int[][] gugudan(){
        gugudans = new int[dan][9];
        for (int i = 0; i < dan; i++) {
            for (int j = 0; j < 9; j++) {
                gugudans[i][j] = (i+2) * (j+1);
            }
        }
        return gugudans;
    }

    public void printGugudan() {
        int dan = 2;
        for (int[] row : gugudans) {
            System.out.printf("[%d단]\n", dan);
            int num = 1;
            for (int value : row) {
                System.out.printf("%d * %d = %2d\t", dan, num, value);
                if (num % 3 == 0) System.out.println();
                num++;
            }
            System.out.println();
            dan++;
        }
    }


}
