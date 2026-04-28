package day19;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello thread " + i);
        }
    }
}


public class ThreadExam02 {
    public static void main(String[] args) {
        System.out.println("main start");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main work");
        }

    }

}
