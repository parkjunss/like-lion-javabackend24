package day4;

public class LabelExam2 {
    public static void main(String[] args){
        outter:
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++){
                if(i == 0 && k == 0)
                    continue outter; // 바깥쪽 반복문의 다음 반복으로
                System.out.println(i + ", " + k);
            }
        }
    }
}
