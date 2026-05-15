package day30.a;

// 새로 추가하는 인터페이스: A는 이 인터페이스만 알고 있음


// A는 이제 BInterface에만 의존
public class A {
    public void a(BInterface bInterface) {
        bInterface.b();
    }
}