package day19.exam;

import java.io.*;

public class FileWriterTask implements Runnable {
    private final String fileName;

    FileWriterTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    break;
                }
                writer.println(line);
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}