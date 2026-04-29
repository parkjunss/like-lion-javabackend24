package day18;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleMemo {

    public void WriteFile(String fileName, BufferedReader reader) {
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            System.out.println("Write contents");
            String content;
            while ((content = reader.readLine()) != null && !content.isEmpty()) {
                writer.write(content + "\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<String> ReadFile(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> sb = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.add(line);
            }
            return sb;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void showContents(List<String> contents){
        for (String s : contents) {
            System.out.println(s);
        }
    }

    public void Menu(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                System.out.println("1. 쓰기, 2. 읽기, 3. 종료");
                String input = reader.readLine();
                int option = Integer.parseInt(input);
                if (option == 3) break;
                switch (option){
                    case 1:
                        System.out.println("Write file Name:");
                        String writeFileName = reader.readLine();
                        WriteFile(writeFileName, reader);
                        break;
                    case 2:
                        System.out.println("Write file Name:");
                        String readFileName = reader.readLine();
                        showContents(ReadFile(readFileName));
                        break;
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleMemo sm = new SimpleMemo();
        sm.Menu();
    }

}
