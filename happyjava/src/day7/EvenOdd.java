package day7;

public class EvenOdd {
    int number;

    public EvenOdd(int number) {
        this.number = number;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public void printFlag() {
        if (isEven()) {
            System.out.printf("%d is Even.\n", number);
        } else {
            System.out.printf("%d is Odd.\n", number);
        }
    }

    public int getNumber() {
        return number;
    }

    public void printNumber() {
        System.out.println("Number: " + number);
    }
}
