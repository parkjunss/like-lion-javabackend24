package day19.exam;

import java.io.*;

public class FileReaderTask implements Runnable {
    private final String fileName;

    FileReaderTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                System.out.println(line);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
