package day30.b;


import day30.a.BInterface;

// B가 package a에 정의된 인터페이스를 "구현"한다.
public class B implements BInterface {
    @Override
    public void b() {
        System.out.println("B logic");
    }
}