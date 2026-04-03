package day3;

public class TernaryExample {
    public static void main(String[] args) {
//        int a = 10, b = 20;
//        int max = a > b ? a : b;
//        System.out.println(max);

        int number = Integer.parseInt(args[0]);
        System.out.println(number % 2 == 0);
        String remain = (number % 2 == 0) ? "true":"false";
        int result = (number % 2 == 0) ? 0:1;

        System.out.println(remain);
        System.out.println(result);

    }
}
