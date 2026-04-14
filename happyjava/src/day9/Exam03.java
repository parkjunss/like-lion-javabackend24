package day9;

public class Exam03 {
    public static void main(String[] args) {
        String test = "TEST1";
        String test2 = "TEST2";
        String test3 = "TEST3";

        String str = "base   ";
        StringBuilder strBuilder = new StringBuilder("hello");
        System.out.println(str.length());
        System.out.println(str.toUpperCase());
        System.out.println(String.join("-", test, test2, test3));

        System.out.println(str.trim());

        System.out.println(strBuilder.append(">>>"));




    }
}

