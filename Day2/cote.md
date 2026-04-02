
// import java.util.Arrays;
// import java.util.Comparator;

// // 문제 설명
// // 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

// // 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

// // 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

// // 제한 사항
// // numbers의 길이는 1 이상 100,000 이하입니다.
// // numbers의 원소는 0 이상 1,000 이하입니다.
// // 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
// // 입출력 예
// // numbers	return
// // [6, 10, 2]	"6210"
// // [3, 30, 34, 5, 9]	"9534330"

// class Solution {
//     public String solution(int[] numbers) {
//         String answer = "";
        
//         // 이를 위해, 문자열로 변환된 숫자들을 정렬할 때, 두 숫자 a와 b를 비교할 때, a + b와 b + a를 비교하여 더 큰 조합이 되는 순서로 정렬하면 됩니다. 예를 들어, "6"과 "10"을 비교할 때, "610"과 "106"을 비교하여 "610"이 더 크므로 "6"이 "10"보다 앞에 오도록 정렬해야 합니다.
//         // Java에서는 Arrays.sort() 메서드를 사용하여 배열을 정렬할 때, Comparator를 사용하여 사용자 정의 정렬 기준을 지정할 수 있습니다. Comparator는 두 객체를 비교하는 메서드를 구현하는 인터페이스입니다. 이를 활용하여 문자열로 변환된 숫자들을 정렬할 때, 두 숫자 a와 b를 비교할 때, a + b와 b + a를 비교하여 더 큰 조합이 되는 순서로 정렬할 수 있습니다.
//         // 예를 들어, "6"과 "10"을 비교할 때, "610"과 "106"을 비교하여 "610"이 더 크므로 "6"이 "10"보다 앞에 오도록 정렬해야 합니다. 이를 위해, Comparator를 구현하여 문자열로 변환된 숫자들을 정렬할 때, 두 숫자 a와 b를 비교할 때, a + b와 b + a를 비교하여 더 큰 조합이 되는 순서로 정렬할 수 있습니다.
//         // 정렬된 문자열 배열을 이어붙여서 가장 큰 수를 만들 수 있습니다. 예를 들어, 정렬된 문자열 배열이 ["9", "5", "34", "3", "30"]이라면, 이어붙여서 "9534330"을 만들 수 있습니다.
//         // 또한, 모든 숫자가 0인 경우에는 "0"을 반환해야 합니다. 예를 들어, 정렬된 문자열 배열이 ["0", "0", "0"]이라면, 이어붙여서 "000"이 되지만, 이 경우에는 "0"을 반환해야 합니다.
//         // 따라서, 정렬된 문자열 배열을 이어붙인 후, 결과가 "0"으로 시작하는 경우에는 "0"을 반환하도록 처리해야 합니다.

//         // 그래서 어떻게 구현? 문자열로 변환된 숫자들을 정렬할 때, 두 숫자 a와 b를 비교할 때, a + b와 b + a를 비교하여 더 큰 조합이 되는 순서로 정렬하는 Comparator를 구현하여 Arrays.sort() 메서드에 전달하면 됩니다. 예를 들어, 다음과 같이 Comparator를 구현할 수 있습니다.
//         Comparator<String> comparator = new Comparator<String>() {
//             @Override
//             public int compare(String a, String b) {
//                 String order1 = a + b;
//                 String order2 = b + a;
//                 return order2.compareTo(order1); // 내림차순 정렬
//             }
//         };

//         // 문자열 배열을 정렬
//         String[] stringNumbers = new String[numbers.length];
//         for (int i = 0; i < numbers.length; i++) {
//             stringNumbers[i] = Integer.toString(numbers[i]);
//         }
//         Arrays.sort(stringNumbers, comparator);

//         // 정렬된 문자열을 이어붙임
//         StringBuilder sb = new StringBuilder();
//         for (String s : stringNumbers) {
//             sb.append(s);
//         }
//         answer = sb.toString();

//         // 모든 숫자가 0인 경우 "0"을 반환
//         if (answer.charAt(0) == '0') {
//             answer = "0";
//         }    

//         System.out.println(answer);

//         return answer;
//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] numbers = {6, 10, 2};
//         String result = sol.solution(numbers);
//         System.out.println("Result: " + result);
//     }
// }

