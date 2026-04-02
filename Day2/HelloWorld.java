package day2;

public class HelloWorld {
    // static 메서드 = 객체를 생성하지 않고도 호출할 수 있는 메서드
    // void = 반환 타입, 이 메서드는 값을 반환하지 않음을 나타낸다  
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Car myCar = new Car(); // Car 클래스의 객체 생성
        myCar.brand = "Toyota"; // 객체의 필드에 값 할당    
        myCar.model = "Corolla";
        myCar.year = 2020;
        myCar.printInfo(); // 객체의 메서드 호출
        myCar.start(); // 객체의 메서드 호출    
        myCar.stop(); // 객체의 메서드 호출
    }
}