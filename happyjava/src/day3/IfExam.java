package day3;

public class IfExam {
    public static void main(String[] args) {
        int score = 35;
        char gender = 'M';

        if (score >= 80) {
            if (gender == 'M'){
                System.out.println("완전합격입니다. 남학생");
            } else {
                System.out.println("완전합격입니다. 여학생");
            }
        } else if (score >= 50) {
            System.out.println("합격입니다");
        } else {
            System.out.println("불합격입니다");
        }
        System.out.println("프로그램 종료");
    }
}
