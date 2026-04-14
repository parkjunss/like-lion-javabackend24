package day8;

interface SmartDevice{
    void turnOff();
    void turnOn();

    default void reset() {
        System.out.println("Default Reset");
    }
}

class SmartPhone implements SmartDevice{
    public void turnOff(){
        System.out.println("Turning off");
    }
    public void turnOn(){
        System.out.println("Turning on");
    }

    @Override
    public void reset(){
        System.out.println("Phone reset");
    }

}
public class Exam08 {
    public static void main(String[] args){
        SmartPhone phone = new SmartPhone();
        phone.turnOn();
        phone.turnOff();

        phone.reset();

        // 인터페이스 타입으로 참조
        SmartDevice device = phone;

        device.turnOn();
        device.turnOff();
        // 인터페이스의 default 메서드 호출
        // 근데 이거 결과가 phone의 reset이 나오는데?
        // 인터페이스의 default 메서드는 클래스에서 오버라이드된 메서드가 있으면 그 메서드를 호출합니다. 따라서, SmartPhone 클래스에서 reset() 메서드를 오버라이드했기 때문에, device.reset()을 호출하면 SmartPhone 클래스의 reset() 메서드가 실행됩니다. 만약 SmartPhone 클래스에서 reset() 메서드를 오버라이드하지 않았다면, 인터페이스 SmartDevice의 default reset() 메서드가 호출되었을 것입니다.
        device.reset();

        // SmartPhone 클래스에서 reset() 메서드를 오버라이드하지 않으면, device.reset()을 호출할 때 SmartDevice 인터페이스의 default reset() 메서드가 실행됩니다. 하지만 SmartPhone 클래스에서 reset() 메서드를 오버라이드했기 때문에, device.reset()을 호출하면 SmartPhone 클래스의 reset() 메서드가 실행됩니다. 이는 자바의 다형성(polymorphism) 원칙에 따라, 참조 변수의 타입이 인터페이스이더라도 실제 객체의 클래스에서 오버라이드된 메서드가 호출되기 때문입니다. 
        // 디폴드 리셋과 폰 리셋이 둘다 존재할 때는 폰 리셋이 우선적으로 호출됩니다.
        // SmartDevice로 형변환하면 디폴트 리셋이 나올줄 알았는데 왜 SmartPhone의 reset이 나오는거야?
        // SmartDevice로 형변환을 하더라도, 실제 객체는 여전히 SmartPhone이기 때문에, reset() 메서드를 호출할 때 SmartPhone 클래스에서 오버라이드된 reset() 메서드가 실행됩니다. 자바에서는 참조 변수의 타입이 인터페이스이더라도, 실제 객체의 클래스에서 오버라이드된 메서드가 호출되는 다형성(polymorphism) 원칙이 적용됩니다. 따라서, device.reset()을 호출하면 SmartPhone 클래스의 reset() 메서드가 실행되고, "Phone reset"이 출력됩니다.
        // 그럼 인터페이스의 default 메서드는 언제 호출돼?
        // 인터페이스의 default 메서드는 해당 메서드를 오버라이드하지 않은 클래스에서 호출됩니다. 만약 클래스가 인터페이스의 default 메서드를 오버라이드하지 않았다면, 인터페이스의 default 메서드가 호출됩니다. 예를 들어, 만약 SmartPhone 클래스에서 reset() 메서드를 오버라이드하지 않았다면, device.reset()을 호출할 때 SmartDevice 인터페이스의 default reset() 메서드가 실행되어 "Default Reset"이 출력되었을 것입니다. 따라서, 인터페이스의 default 메서드는 해당 메서드를 오버라이드하지 않은 클래스에서 호출될 때 사용됩니다.
        // 인터페이스는 구현이 되어있는게 아니고 메서드의 시그니처만 정의되어 있기 때문에, 다중 상속시 같은 이름의 메서드가 여러 인터페이스에 정의되어 있을 때, 클래스는 해당 메서드를 하나만 구현하면 됩니다. 이때, 클래스는 해당 메서드가 어떤 인터페이스에서 왔는지 구분할 필요 없이, 하나의 구현으로 모든 인터페이스에서 사용할 수 있습니다. 따라서, 인터페이스의 default 메서드는 해당 메서드를 오버라이드하지 않은 클래스에서 호출될 때 사용됩니다.
        


    }
}
