package day7;

import java.util.Arrays;

public class MinMaxNum {
    private int[] numbers;
    private int min;
    private int max;

    MinMaxNum(int... numbers) {
        if(numbers == null || numbers.length == 0){
            throw new IllegalArgumentException("Empty array");
        } else if(numbers.length > 5){
            throw new IllegalArgumentException("Too many numbers");
        }
        this.numbers = numbers;
        this.min = findMin();
        this.max = findMax();
    }

    public int findMin(){
        int min = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }

    public int findMax(){
        int max = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        return max;
    }

    public void printMinMax(){
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

}
