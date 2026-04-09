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
