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
