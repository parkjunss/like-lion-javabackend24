public class PrimitiveCastExam {
    public static void main(String[] args) {
        int i = 100;
        long l = i; // int -> long (자동 형변환)
        System.out.println("int to long: " + l);

        double d = i; // int -> double (자동 형변환)
        System.out.println("int to double: " + d);

        byte b = (byte) i; // int -> byte (명시적 형변환)
        System.out.println("int to byte: " + b); // 100이 byte 범위를 벗어나므로 값이 손실됨

        char c = (char) i; // int -> char (명시적 형변환)
        System.out.println("int to char: " + c); // 100에 해당하는 유니코드 문자 출력

        long l2 = 100L;
        int i2 = (int) l2; // long -> int (명시적 형변환)
        System.out.println("long to int: " + i2);

        // 그릇의 크기 float과 long 크기 비교 
        // float는 32비트, long은 64비트이므로 long이 더 크지만, float는 소수점 표현이 가능하므로 서로 다른 용도로 사용됨
        float f = 10.5f;
        long l3 = f; // float -> long (명시적 형변환)
        System.out.println("float to long: " + l3); // 소수점이 손실되고 정수 부분만 남음

        double pi = 3.1415926535897932384626; // double 리터럴이 아닌 float 리터럴로 선언
        System.out.printf("pi as double: %.2f%n", pi);





    }
}