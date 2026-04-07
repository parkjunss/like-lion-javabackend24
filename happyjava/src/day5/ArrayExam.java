package day5;

import java.util.Arrays;

public class ArrayExam {
    public static void main(String[] args) {
        int[] iarr = new int[3];

        System.out.println(iarr[2]);



        System.out.println(Arrays.toString(iarr));

//        iarr[4] = 20;

        int iarr2[]; // C 형식 배열타입
        int[][] iarr3; // 2차원 배열
        int[][] iarr4[]; // 이건 뭐여 3차원 [] 개수가 차원 결정

        //배열은 선언만 하는것은 배열 자체를 가리킬 수 있는 변수
        // 실제 값을 저장하는 공간은 아님

        int[] arr3 = new int[]{10, 20, 30, 40, 50};

        // 배열의 초기화는 생성시만 가능
        int[] arr4 = new int[3];
        // arr4 = {10, 20, 30}; 안됨


        int[] arr5 = new int[]{10, 20, 30, 40, 50};
        int temp =  arr5[0];
        arr5[0] = arr5[1];
        arr5[1] = temp;

        System.out.println(Arrays.toString(arr5));


        for(int score:arr5){
            System.out.println(score);
        }

        char[] charArr = {'a', 'b', 'c', 'd', 'e'};
        for(char ch:charArr){
            System.out.println(ch);
        }


    }
}
