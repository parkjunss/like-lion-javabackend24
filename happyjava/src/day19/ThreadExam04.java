package day19;

class IncrementCounter {
    private int count = 0;

    public synchronized void increment(){
        count++;
        System.out.println(count);
    }
}

class DecrementCounter{

}

public class ThreadExam04 {

    public static void main(String[] args) {
        Counter counter = new Counter();

    }

}
