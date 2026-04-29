package day19.exam;

public class CounterApp {
    public static void main(String[] args) {
        Thread incrementThread = new Thread(new IncrementCounter(100));
        Thread decrementThread = new Thread(new DecrementCounter(100));

        incrementThread.start();
        decrementThread.start();
    }
}