package day11;

public class WithoutExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[3]); // ArrayIndexOutOfBoundsException 발생
        }  catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램 종료"); // 이 코드는 실행되지 않음
    }
}