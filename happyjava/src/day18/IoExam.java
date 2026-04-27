package day18;

import java.io.*;
import java.net.URI;
import java.net.URL;

public class IoExam {
    public static void main(String[] args) throws IOException {
//        InputStream in = System.in;
//        InputStream in = new FileInputStream("src/day18/test.txt");
        URL url = URI.create("https://www.google.com").toURL();
        InputStream in = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        while (true) {
            String msg = br.readLine();
            if (msg.equals("exit")) {
                break;
            }
            System.out.println(msg);
        }

        br.close();
        in.close();
    }
}
