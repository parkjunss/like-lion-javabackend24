package day6;

public class Animal {
    private String name;
    private final String type;

    Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void printInfos(){
        System.out.printf("이름: %s, 종류: %s\n", name, type);
    }

    public static void main(String[] args) {
        Animal dog = new Animal("뽀삐", "개");
        Animal cat = new Animal("나비", "고양이");
        Animal ham = new Animal("찡찡이", "햄스터");
        dog.printInfos();
        cat.printInfos();
        ham.printInfos();
    }
}
