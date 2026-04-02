package day2;

public class EscapeChar {
    public static void main(String[] args) {
        // 이스케이프 문자 = 특수한 의미를 가지는 문자, 백슬래시(\)로 시작
        // \n = 줄 바꿈, \t = 탭, \\ = 백슬래시 자체, \" = 큰따옴표 자체
        System.out.println("Hello,\nWorld!"); // 줄 바꿈
        System.out.println("Hello,\tWorld!"); // 탭
        System.out.println("This is a backslash: \\"); // 백슬래시 자체
        System.out.println("She said, \"Hello!\""); // 큰따옴표 자체
        System.out.println("C:\\Users\\Username\\Documents"); // 파일 경로에서 백슬래시 사용
        // 유니코드 이스케이프 = \\uXXXX 형식으로 유니코드 문자 표현
        System.out.println("Unicode character: \u0041"); // A
        System.out.println("Another Unicode character: \u0042"); // B
        
        boolean isTrue = true; // boolean 타입은 true 또는 false 값을 가질 수 있다
        boolean isFalse = false;
        System.out.println("isTrue: " + isTrue);
        System.out.println("isFalse: " + isFalse);

        char letterA = 'A'; // char 타입은 단일 문자를 나타내며, 작은따옴표로 감싸서 표현한다
        System.out.println("letterA char: " + letterA);
        letterA = 65; // char 타입은 정수값으로도 표현할 수 있다, 65는 'A'의 유니코드 값이다
        System.out.println("letterA int: " + letterA); // char 타입은 정수값으로도 표현할 수 있다, 65는 'A'의 유니코드 값이다

        char letterB = 'B';
        int unicodeB = (int) letterB; // char 타입을 int 타입으로 변환할 수 있다, 'B'의 유니코드 값은 66이다
        System.out.println("letterB char: " + letterB);
        System.out.println("unicodeB int: " + unicodeB);

        // 연산자
        int a = 10;
        int b = 20;
        int sum = a + b; // 덧셈 연산자
        int difference = a - b; // 뺄셈 연산자
        int product = a * b; // 곱셈 연산자
        int quotient = b / a; // 나눗셈 연산자
        int remainder = b % a; // 나머지 연산자
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);

        // 비교 연산자
        boolean isEqual = (a == b); // 같음 연산자
        boolean isNotEqual = (a != b); // 같지 않음 연산자
        boolean isGreater = (a > b); // 크다 연산자
        boolean isLess = (a < b); // 작다 연산자
        boolean isGreaterOrEqual = (a >= b); // 크거나 같다 연산자
        boolean isLessOrEqual = (a <= b); // 작거나 같다 연산자
        System.out.println("isEqual: " + isEqual);
        System.out.println("isNotEqual: " + isNotEqual);
        System.out.println("isGreater: " + isGreater);
        System.out.println("isLess: " + isLess);
        System.out.println("isGreaterOrEqual: " + isGreaterOrEqual);
        System.out.println("isLessOrEqual: " + isLessOrEqual);

        // 논리 연산자
        boolean andResult = (a > 5) && (b > 15); // 논리 AND 연산자
        boolean orResult = (a > 15) || (b > 15); // 논리 OR 연산자
        boolean notResult = !(a > 5); // 논리 NOT 연산자
        System.out.println("AND Result: " + andResult);
        System.out.println("OR Result: " + orResult);
        System.out.println("NOT Result: " + notResult);

        // 대입 연산자
        int c = 5;
        c += 10; // c = c + 10; 덧셈 대입 연산자
        c -= 3; // c = c - 3; 뺄셈 대입 연산자
        c *= 2; // c = c * 2; 곱셈 대입 연산자
        c /= 4; // c = c / 4; 나눗셈 대입 연산자
        c %= 3; // c = c % 3; 나머지 대입 연산자
        System.out.println("Final value of c: " + c);
        
        // 증감 연산자
        int d = 10;
        d++; // d = d + 1; 후위 증가 연산자
        System.out.println("After d++: " + d);
        ++d; // d = d + 1; 전위 증가 연산자
        System.out.println("After ++d: " + d);
        d--; // d = d - 1; 후위 감소 연산자
        System.out.println("After d--: " + d);
        --d; // d = d - 1; 전위 감소 연산자
        System.out.println("After --d: " + d);

        // 삼항 연산자
        int e = 15;
        String result = (e > 10) ? "Greater than 10" : "Less than or equal to 10"; // 조건 ? 참일 때 값 : 거짓일 때 값
        System.out.println("Ternary Operator Result: " + result);

        // instanceof 연산자
        String str = "Hello";
        boolean isString = (str instanceof String); // str이 String 타입인지 확인하는 연산자
        System.out.println("Is str a String? " + isString);

        //자동 타입 변환과 강제 타입 변환
        int f = 100;
        double g = f; // 자동 타입 변환, int에서 double로 변환
        System.out.println("Value of g (double): " + g);
        double h = 3.14;
        int i = (int) h; // 강제 타입 변환, double에서 int
        System.out.println("Value of i (int): " + i);
        
    }
}
