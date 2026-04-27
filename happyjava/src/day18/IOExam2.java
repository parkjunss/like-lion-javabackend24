package day18;

import java.io.*;

public class IOExam2 {
    public static void main(String[] args) {
        try(
        InputStream in = new FileInputStream("src/day18/test.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr))
        {
            System.out.println(br.readLine());
            System.out.println(br.readLine());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try(InputStream in = System.in;
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter("src/day18/outTest.txt"))
        {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) break;
                fw.write(line + "\n");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
