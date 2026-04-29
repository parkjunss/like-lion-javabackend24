package day19.exam;

public class IncrementCounter implements Runnable {
    private final int i;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public IncrementCounter(int i){
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < i; j++) {
            count++;
            System.out.println("Increment: " + getCount());
            try {
                Thread.sleep((long) (Math.random()*11));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
