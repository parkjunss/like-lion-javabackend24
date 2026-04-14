package day8;

interface Calculator {
    int add(int a, int b);
    int subtract(int a, int b);
}

interface Multipliable {
    int multiply(int a, int b);
}

class BasicCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}

class AdvancedCalculator extends BasicCalculator implements Multipliable {
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}