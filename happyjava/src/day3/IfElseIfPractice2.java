package day3;

public class IfElseIfPractice2 {
    public static void main(String[] args) {
        int price = 120000; // 원래 구매 금액
        int finalPrice = 0; // 최종 결제 금액을 저장할 변수

        // if-else if문을 사용하여 할인율을 적용하세요.
        // 조건 1: 100,000원 이상 구매 시 20% 할인
        if(price >= 100000){
            finalPrice = (int) (price * 0.8);
        }
        // 조건 2: 50,000원 이상 구매 시 10% 할인
        else if(price >= 50000){
            finalPrice = (int) (price * 0.9);
        }
        // 그 외 (50,000원 미만): 할인 없음
        else {
            finalPrice = price;
        }

        // 여기에 코드를 작성하세요.


        System.out.println("최종 결제 금액은 " + finalPrice + "원입니다.");
    }
}
