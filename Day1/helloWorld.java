// 주석 = 설명문 번역 실행을 안함
/*이것도 주석
여러 줄 주석*/
// 자바는 대소문자를 구분한다
// 자바는 클래스 단위로 프로그램이 구성된다
// 클래스 이름은 대문자로 시작하는 것이 관례이다
// 클래스로 만드는 문법
// public = 접근 제어자, 클래스가 어디서든 접근 가능하도록 설정
// class = 클래스 정의 키워드, helloWorld = 클래스 이름
// main 메서드는 자바 프로그램의 진입점으로, 프로그램이 시작될 때 가장 먼저 실행되는 메서드입니다.
// String[] args = 명령줄 인자를 저장하는 배열, 프로그램 실행 시 외부에서 전달된 인자들을 받을 수 있다
// static = 정적 메서드, 객체를 생성하지 않고도 호출할 수 있다
// void = 반환 타입, 이 메서드는 값을 반환하지 않음을 나타낸다
// System.out.println() = 콘솔에 메시지를 출력하는 메서드, "Hello, World!"는 출력할 문자열이다
// 자바 프로그램은 클래스 단위로 작성되며, main 메서드는 프로그램의 시작점입니다. 이 예제에서는 "Hello, World!"를 콘솔에 출력하는 간단한 프로그램을 작성했습니다.

public class helloWorld {
    //main 메서드 = 프로그램의 시작점
    public static void main(String[] args) {
        //콘솔에 "Hello, World!" 출력
        System.out.println("Hello, World!");
        System.out.println("Hello, Worldw!");

    }
}

// 자바 프로그램을 실행하려면, 먼저 소스 코드를 컴파일하여 바이트코드로 변환해야 합니다. 그런 다음, Java Virtual Machine (JVM)을 사용하여 바이트코드를 실행할 수 있습니다. 이 예제에서는 "Hello, World!"를 출력하는 간단한 프로그램을 작성했습니다.
// 컴파일 명령: javac helloWorld.java
// 실행 명령: java helloWorld
// 메소드 규칙 - 접근제한자 반환타입 메소드이름(매개변수) { 실행할 코드 }


