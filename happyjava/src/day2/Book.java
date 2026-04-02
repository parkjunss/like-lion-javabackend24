package day2;

public class Book {
    // 강형언어 = 타입을 반드시 지정해서 사용하는 언어
    // 약형언어 = 그릇에 타입이 지정되지 않고 사용하는 언어
    // 캡슐화 = 객체의 필드와 메서드를 하나로 묶고, 외부에서 접근을 제한하는 원칙
    // private = 외부에서 접근할 수 없는 접근 제어자, 클래스 내부에서만 접근 가능

    
    private String title;
    private int price;

    // getter 메서드 = private 필드의 값을 반환하는 메서드
    // setter 메서드 = private 필드의 값을 설정하는 메서드
    public int getPrice(){
        return this.price * 2;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
