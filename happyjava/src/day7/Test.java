package day7;

class Parent {
    int i = 10;

    public int getInfo() {
        return this.i;
    }

    public void setInfo(int i) {
        this.i = i;
    }
}
class Child extends Parent {
    int i = 20;

    @Override
    public int getInfo() {
        System.out.println(super.getInfo());
        return this.i;
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        System.out.println(p.i);
        System.out.println(p.getInfo());

        System.out.println(c.i);
        System.out.println(c.getInfo());
    }
}
