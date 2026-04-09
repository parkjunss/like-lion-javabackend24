```java
package day7;

public class EvenOdd {
    int number;

    public EvenOdd(int number) {
        this.number = number;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public void printFlag() {
        if (isEven()) {
            System.out.printf("%d is Even.\n", number);
        } else {
            System.out.printf("%d is Odd.\n", number);
        }
    }

    public int getNumber() {
        return number;
    }

    public void printNumber() {
        System.out.println("Number: " + number);
    }
}


package day7;

import java.util.Arrays;

public class BiggestNumber {
    int[] nums;

    public BiggestNumber(int ... numbers) {
        this.nums = new int[numbers.length];
        System.arraycopy(numbers, 0, nums, 0, numbers.length);
    }

    public int[]  getNums() {
        return nums;
    }

    public int[] sort() {
        Arrays.sort(nums);
        return nums;
    }

    public int getBiggestNumber() {
        this.sort();
        return nums[nums.length - 1];
    }

    public void printBiggestNumber() {
        System.out.println("Biggest Number: " + getBiggestNumber());
    }
}

package day7;

public class SumToHundred {
    int sum;
    int num;

    public SumToHundred(int num) {
        this.num = num;
    }

    public int getSum() {
        sum = 0;
        for (int i = 0; i < num; i++){
            sum += i+1;
        }
        return sum;
    }

    public void printSum() {
        this.getSum();
        System.out.printf("Sum 1 to %d = %d", num, sum);
    }
}

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


package day7;

import java.util.Arrays;

public class CommonMultiple {
    private final int maxNum;
    private final int num1;
    private final int num2;


    public CommonMultiple(int num1, int num2, int maxNum) {
        this.num1 = num1;
        this.num2 = num2;
        this.maxNum = maxNum;
    }

    public int getNum1() {
        return maxNum;
    }

    public int getCommonMultiple( int target) {
        if(target % num1 == 0 && target % num2 == 0){
            return target;
        }
        return 0;
    }

    public int[] getMult() {
        // 1. 일단 최대 크기로 배열 생성
        int[] temp = new int[maxNum];
        int count = 0;
        for (int i = 0; i < maxNum; i++) {
            int result = getCommonMultiple(i + 1);

            if (result != 0) {
                temp[count] = result;
                count++;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    public void printMult() {
        System.out.printf("Common Multiple of %d and %d : %s\n", num1, num2, Arrays.toString(getMult()));
    }

}


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


package day7;

import java.util.Arrays;
import java.util.Scanner;

public class FindFruit {
    private final String[] fruits = {"사과", "바나나", "딸기", "포도"};

    public void findFruit(Scanner input) {
        while (true) {
            System.out.println("Enter fruit name in Korean:");
            String fruit = input.nextLine();
            if(Arrays.asList(fruits).contains(fruit)){
                System.out.println("You Found " + fruit);
                break;
            } else {
                System.out.println("You Don't Have Such Fruit");
            }
        }
    }

}


package day7;

import java.util.Scanner;

public class StudentsScore {
    private int[] scores;
    private int students;
    private int count;

    public StudentsScore(int students) {
        this.students = students;
        scores = new int[students];
        count = 0;
    }

    public int[] getScores(Scanner input) {
        for (int i = 0; i < scores.length; i++) {
            do {
                System.out.print("Enter Student Score " + (i+1) + ": ");
                scores[i] = input.nextInt();

                if (scores[i] < 0) {
                    System.out.println("You Can't enter a negative score");
                }
            } while (scores[i] < 0);
        }
        return scores;
    }

    public double getMeanScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return (double) total / students; // 소수점까지 나오게 형변환
    }

    public int getMaxScore() {
        int max = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public int overTargetScore(int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= target) {
                count++;
            }
        }
        return count;
    }


    public void printScores() {
        System.out.println("Student Mean Scores: " +  getMeanScore());
        System.out.println("Student Max Scores: " +  getMaxScore());
        System.out.println("Students Over Target Scores: " +  count);
    }

}


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

package day7;

import java.util.Arrays;

public class Lotto {
    int[] balls;
    int[] lottoNumbers = new int[6];

    Lotto(int number){
        this.balls = new int[number];
    }

    public int[] makeNumbers() {
        for (int i = 0; i < balls.length; i++) {
            balls[i] = i + 1;
        }
        return balls;
    }

    public int[] shuffleNumbers() {
        for (int i = 0; i < 100; i++) {
            int randomIndex = (int) (Math.random() * balls.length);
            int temp = balls[0];
            balls[0] = balls[randomIndex];
            balls[randomIndex] = temp;
        }
        return balls;
    }

    public int[] pickNumbers() {
        System.arraycopy(balls, 0, lottoNumbers, 0, 6);
        Arrays.sort(lottoNumbers);
        return lottoNumbers;
    }
    public void printNumbers() {
        System.out.println("로또 번호: " + Arrays.toString(lottoNumbers));
    }

    public void runLotto() {
        makeNumbers();
        shuffleNumbers();
        pickNumbers();
        printNumbers();
    }


}


package day7;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Q1.");
        System.out.print("Enter number : ");
        EvenOdd num = new EvenOdd(input.nextInt());
        num.printFlag();
        System.out.println();

        System.out.println("Q2.");
        BiggestNumber biggest = new BiggestNumber(10, 50, 20);
        biggest.printBiggestNumber();
        System.out.println();


        System.out.println("Q3.");
        SumToHundred sumToHundred = new SumToHundred(100);
        sumToHundred.printSum();
        System.out.println();


        System.out.println("Q4.");
        GuGu gu = new GuGu(9);
        gu.gugudan();
        gu.printGugudan();
        System.out.println();


        System.out.println("Q5.");
        CommonMultiple cm = new CommonMultiple(3, 5, 50);
        cm.printMult();
        System.out.println();

        System.out.println("Q6.");
        MinMaxNum minMaxNum = new MinMaxNum(10, 50, 30, 5, 6);
        minMaxNum.printMinMax();

        System.out.println("Q7.");
        FindFruit f = new FindFruit();
        f.findFruit(input);
        System.out.println();


        System.out.println("Q8.");
        StudentsScore studentsScore = new StudentsScore(5);
        studentsScore.getScores(input);
        studentsScore.overTargetScore(60);
        studentsScore.printScores();
        System.out.println();


        System.out.println("Q9.");
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.userRandomNumber(input);
        System.out.println();

        System.out.println("Q10.");
        Lotto lotto = new Lotto(45);
        lotto.runLotto();
        System.out.println();
    }
}


```