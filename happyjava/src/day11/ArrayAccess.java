package day11;

public class ArrayAccess {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        try{

            // TODO: 배열 범위를 벗어나는 접근에 대한 예외 처리 추가
            System.out.println("인덱스 0: " + numbers[0]);
            System.out.println("인덱스 3: " + numbers[3]);
            System.out.println("인덱스 10: " + numbers[10]); // 예외 발생!
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }

        System.out.println("프로그램 종료");
    }
}
