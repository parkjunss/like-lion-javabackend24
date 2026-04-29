package day19.exam;

public class FileReadWriteApp {
    public static void main(String[] args) {
        String readFileName = "input.txt";
        String writeFileName = "output.txt";

        Thread t1 = new Thread(new FileReaderTask(readFileName));
        Thread t2 = new Thread(new FileWriterTask(writeFileName));

        t1.start();
        t2.start();
    }
}
