package day3;

public class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int i = 0; i < numbers.length; i++){
            answer += numbers[i];
        }
        return answer / numbers.length;
    }

    public static void main(String[] args) {

    }
}
