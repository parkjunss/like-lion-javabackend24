package day20;
//interface Function1 {
//    int apply(int i);
//}

@FunctionalInterface
interface Cal {
    int cal(int i, int j);
}

@FunctionalInterface
interface CalFunction{
    int cal(int i, int j);
}
public class LambdaExam {
    public static void main(String[] args) {
        Cal plus = (i, j) -> i + j;
        Cal minus = (i, j) -> i - j;
        Cal multiply = (i, j) -> i * j;
        Cal divide = (i, j) -> i / j;

        System.out.println(plus.cal(1, 2));
        System.out.println(minus.cal(1, 2));
        System.out.println(multiply.cal(1, 2));
        System.out.println(divide.cal(1, 2));

    }
}
