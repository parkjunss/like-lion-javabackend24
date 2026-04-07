package day5;

import java.util.Arrays;

public class ArrayQ {
    public int[] printEven(int[] iarry) {
        int[] result = new int[iarry.length / 2];
        for (int i = 0; i < iarry.length; i++) {
            if(iarry[i]%2==0){
                result[i/2] = iarry[i];
            }
        }
        return result;
    };

    public int[] findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int[] result = new int[]{min, max};
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        result[0] = min;
        result[1] = max;
        return result;
    };

    public int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - i - 1];
        }
        return result;
    };

    public int[][] multipleTable(int maxTime) {
        int[][] result = new int[maxTime-1][9];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = (i+2) * (j+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] given = new int[10];
        for(int i=0;i<given.length;i++){
            given[i]=i+1;
        }
        ArrayQ arrayQ = new ArrayQ();
        int[][] multipleTable = arrayQ.multipleTable(9);

        System.out.println(Arrays.toString(arrayQ.printEven(given)));
        System.out.println(Arrays.toString(arrayQ.findMinMax(given)));
        System.out.println(Arrays.toString(arrayQ.reverseArray(given)));

        for (int[] row : multipleTable) {
            int dan = row[0];
            int num = 1;
            System.out.println(dan + "단");
            for (int value : row) {
                System.out.printf("%d * %d = %2d\t", dan, num, value);
                if(num % 3 == 0){
                    System.out.println();
                }
                num++;
            }
            System.out.println();
        }

    }
}
