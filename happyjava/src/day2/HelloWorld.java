package day2;

public class HelloWorld {
    public int age;
    public String name;
    int test;
    protected int a;
    private int b;
    public HelloWorld(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld(18, "Hello World");
        System.out.println("Hello World");
        System.out.println("Age : " + helloWorld.age);
        System.out.println("Name : " + helloWorld.name);
        System.out.println("Test : " + helloWorld.test);

    }
}
