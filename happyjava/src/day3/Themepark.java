package day3;

/*
* 놀이공원 입장료는 다음과 같다:

기본 요금: 10,000원
나이가 13세 이하 → 50% 할인
나이가 65세 이상 → 30% 할인
단, 할인은 하나만 적용 (더 큰 할인 우선)

추가 조건:

소지금(money)이 입장료보다 적으면 "입장 불가" 출력
충분하면 "입장 가능: 실제 요금" 출력
📌 입력 예시
age = 10, money = 6000
📌 출력 예시
입장 가능: 5000원
📌 입력 예시 2
age = 70, money = 6000
📌 출력 예시 2
입장 불가*/
public class Themepark {
    public static void main(String[] args) {
        int price = 10000;
        int age = Integer.parseInt(args[0]);
        int money = Integer.parseInt(args[1]);
        int targetPrice = price;

        if(age < 14){
            targetPrice = (int) ((int) price * 0.5);
        } else if(age > 64){
            targetPrice = (int) ((int) price * 0.7);
        }

        if (targetPrice > money){
            System.out.println("입장 불가");
        } else {
            System.out.printf("입장 가능: %d", targetPrice);
        }

    }
}
