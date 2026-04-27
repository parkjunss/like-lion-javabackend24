package day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        //파일에서 읽어와서 파일에 쓰려고해요.
//       파일에서 읽기위한 객체, FileInputStream
//       파일에 쓰기위한 객체 , FileOutputStream
        int count = 0;

        try(
                FileInputStream in = new FileInputStream("output.txt");
                FileOutputStream out = new FileOutputStream("haha2.txt");
        ){
//            int byteData;
//            while ((byteData = in.read()) != -1){
////                System.out.print(byteData +"::");
////                System.out.println((char)byteData);
//                out.write(byteData);
//                count++;
//            }
            int n = 0;
            byte[] bytes = new byte[1024];
            while ((n = in.read(bytes)) != -1){
                String str = new String(bytes,0,n);
                System.out.println(str);
                out.write(bytes);
                count++;
            }


            System.out.println("읽은횟수"+ count );
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}