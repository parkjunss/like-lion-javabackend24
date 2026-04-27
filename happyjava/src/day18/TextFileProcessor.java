package day18;

import java.io.*;

public class TextFileProcessor {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            int lineNumber = 1;

            // 한 줄씩 읽어서 처리
            while ((line = reader.readLine()) != null) {
                // 줄 번호 추가하여 쓰기
                writer.println(lineNumber + ": " + line);
                lineNumber++;
            }

            System.out.println("텍스트 파일 처리 완료!");
            System.out.println("총 " + (lineNumber - 1) + "줄 처리됨");

        } catch (IOException e) {
            System.err.println("파일 처리 오류: " + e.getMessage());
        }
    }
}