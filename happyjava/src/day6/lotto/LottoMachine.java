package day6.lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int MAX_NUMBER = 45;
    private final Ball[] balls = new Ball[MAX_NUMBER];
    private int currentStep = 0;

    public LottoMachine() {
        for (int i = 0; i < MAX_NUMBER; i++) {
            this.balls[i] = (new Ball(i+1));
        }
        shuffleBalls();
    }
    public void shuffleBalls() {
        for (int i = 0; i < 100; i++) {

            int index1 = (int) (Math.random() * MAX_NUMBER);
            int index2 = (int) (Math.random() * MAX_NUMBER);

            Ball temp = balls[index1];
            balls[index1] = balls[index2];
            balls[index2] = temp;
        }
        currentStep = 0;
    }

    public int pickOneBall() {
        int remaining = MAX_NUMBER - currentStep;
        if (remaining < 1) {
            System.out.println("공이 다 떨어졌습니다! 다시 섞으세요.");
            return -1;
        }
        int randomIndex = (int) (Math.random() * remaining);
        Ball pickedBall = balls[randomIndex];

        int result = pickedBall.getNumber();
        Ball lastBall = balls[remaining - 1];
        balls[remaining - 1] = pickedBall;
        balls[randomIndex] = lastBall;

        currentStep++;
        return result;
    }

    public int[] pickManyBalls() {
        int number = 6;
        int[] result = new int[number];
        for (int i = 0; i < number; i++) {
            result[i] = pickOneBall();
        }
        return result;
    }
}