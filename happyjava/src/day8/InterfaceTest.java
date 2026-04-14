package day8;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println("Q1");
        Printer printer = new ConsolePrinter();
        printer.print("Hello World");

        System.out.println("Q2");
        GameObject gameObject = new GameObject(5, 5);
        gameObject.draw();
        gameObject.move(10, 10);
        gameObject.draw();

        System.out.println("Q3");
        Calculator calculatorBasic = new BasicCalculator();
        Calculator calculatorAdvanced = new AdvancedCalculator();

        System.out.println(calculatorBasic.add(5,5));
        System.out.println(calculatorAdvanced.add(5,15));
        System.out.println(calculatorAdvanced.subtract(125,5));

        Multipliable multipliable = (Multipliable) calculatorAdvanced;
        System.out.println(multipliable.multiply(5,5));
        // System.out.println(multipliable.add(5,5)); error

        System.out.println("Q4");
        Character character = new Character();
        SwordAttack swordAttack = new SwordAttack();
        BowAttack bowAttack = new BowAttack();

        character.setAttackStrategy(swordAttack);
        character.performAttack();

        character.setAttackStrategy(bowAttack);
        character.performAttack();


        System.out.println("Q5");
        ReadWritable fileHandler = new FileHandler();

        System.out.println(fileHandler.readContent());
        fileHandler.writeContent("Hello World");
    }
}
