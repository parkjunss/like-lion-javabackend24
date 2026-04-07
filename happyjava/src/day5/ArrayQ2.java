package day5;

import java.util.Arrays;

public class ArrayQ2 {
    public int[] initArray(int n){
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = i;
        }
        return numbers;
    };

    public void printArray(double[] array){
        for(int j = 0; j < array.length; j++){
            System.out.println(array[j]);
        }
    }

    public int lenOfArray(String[] array){
        int len;
        len = array.length;
        return len;
    }

    public void printForEachArray(int[] array){
        for(int i: array){
            System.out.println(i);
        }
    }

    public int[][] twoDimensionalArray(int first, int second){
        int[][] result = new int[first][second];
        int value = 1;
        for(int i = 0; i < first; i++){
            for(int j = 0; j < second; j++){
                result[i][j] = value;
                value++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayQ2 arrayQ2 = new ArrayQ2();
        double[] doubles = {1.0, 2.5, 3.7, 4.4};
        String[] words = {"Hello", "World", "Java", "Programming"};
        int[] numbers = {5, 10, 15, 20, 25};

        System.out.println(Arrays.toString(arrayQ2.initArray(10)));
        arrayQ2.printArray(doubles);
        System.out.println(arrayQ2.lenOfArray(words));
        arrayQ2.printForEachArray(numbers);
        System.out.println(Arrays.deepToString(arrayQ2.twoDimensionalArray(3, 3)));


    }
}
