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
