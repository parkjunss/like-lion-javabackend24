package day8;

abstract class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
    }
    abstract void makeSound();

    public void eat(){
        System.out.println("동물이 먹이를 먹습니다.");
    };
}


class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("멍멍");
    }
}


class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    
    @Override
    void makeSound() {
        System.out.println("야옹");
    }

}