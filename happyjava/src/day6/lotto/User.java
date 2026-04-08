package day6.lotto;

import java.util.Arrays;

public class User {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        int[] result = lottoMachine.pickManyBalls();
        Arrays.sort(result);
        System.out.println("Result: " + Arrays.toString(result));
    }
}
