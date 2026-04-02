package day2;

public class Car {
    // 필드 = 클래스의 속성, 객체의 상태를 나타내는 변수
    public String brand; // 자동차 브랜드
    public String model; // 자동차 모델
    public int year;     // 자동차 제조 연도

    // 메서드 = 클래스의 행동, 객체가 수행할 수 있는 기능을 정의하는 함수
    public void start() {
        System.out.println("The car has started.");
    }

    public void stop() {
        System.out.println("The car has stopped.");
    }

    public void printInfo() {
        System.out.println("Car Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}