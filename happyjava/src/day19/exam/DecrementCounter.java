package day19.exam;

public class DecrementCounter implements Runnable {
    private int i;
    private int count = 100;

    public int getCount() {
        return count;
    }

    public DecrementCounter(int i){
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < i; j++) {
            System.out.println("Decrement: " + getCount());
            count--;

            try {
                Thread.sleep((long) (Math.random()*11));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
