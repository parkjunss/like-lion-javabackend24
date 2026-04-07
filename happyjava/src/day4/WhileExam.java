package day4;

public class WhileExam {
    public static void main(String[] args) {
        int i = 0;
        int j = Integer.parseInt(args[0]);
//        System.out.println("until : " + j);
//        int sum = 0;
//        while (i++ < j) {
//            if (i % 2 == 0) {
//                sum += i;
//                System.out.println("even sum = " + sum);
//            } else {
//                System.out.println("odd : " + i);
//            }
//
//        }

//        do {
//            i++;
//            System.out.println(i);
//        } while (i < j);

//        do {
//            System.out.println(i);
//        } while (i > j);

//        do{
//            System.out.println("i : " + i);
//            i--;
//        } while (i > 0);

        do {
            System.out.println("hello" + i);
            i++;
        } while (i > j);

        while (i++ < j) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }

    }
}
