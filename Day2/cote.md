
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



// 고고학자인 "튜브"는 고대 유적지에서 보물과 유적이 가득할 것으로 추정되는 비밀의 문을 발견하였습니다. 그런데 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨 있었고 문 앞에는 특이한 형태의 열쇠와 함께 자물쇠를 푸는 방법에 대해 다음과 같이 설명해 주는 종이가 발견되었습니다.
// 잠겨있는 자물쇠는 격자 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태이고 특이한 모양의 열쇠는 M x M 크기인 정사각 격자 형태로 되어 있습니다.
// 자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다. 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조입니다. 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만, 자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다. 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.
// 열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이 매개변수로 주어질 때, 열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록 solution 함수를 완성해주세요.
// 제한사항
// key는 M x M(3 ≤ M ≤ 20, M은 자연수)크기 2차원 배열입니다.
// lock은 N x N(3 ≤ N ≤ 20, N은 자연수)크기 2차원 배열입니다.
// M은 항상 N 이하입니다.
// key와 lock의 원소는 0 또는 1로 이루어져 있습니다.
// 0은 홈 부분, 1은 돌기 부분을 나타냅니다.
// key	lock	result
// [[0, 0, 0], [1, 0, 0], [0, 1, 1]]	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]	true
// 솔루션 방법 1. 열쇠를 90도씩 회전시키는 함수 작성
// 2. 열쇠를 자물쇠의 모든 위치에 맞춰보는 함수 작성
// 3. 열쇠의 돌기와 자물쇠의 홈이 일치하는지 확인하는 함수 작성
// 4. 자물쇠의 모든 홈이 채워졌는지 확인하는 함수 작성
// 5. 위의 함수들을 조합하여 solution 함수 작성


package day2;

public class Solution {
    // 1. 열쇠를 90도씩 회전시키는 함수
    public int[][] rotateKey(int[][] key) {
        int M = key.length;
        int[][] rotatedKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotatedKey[j][M - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    // 2. 열쇠를 자물쇠의 모든 위치에 맞춰보는 함수 작성
    public boolean checkKeyAtPosition(int[][] key, int[][] lock, int x, int y) {
        int M = key.length;
        int N = lock.length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int lockX = x + i;
                int lockY = y + j;
                if (lockX >= 0 && lockX < N && lockY >= 0 && lockY < N) {
                    if (key[i][j] == 1 && lock[lockX][lockY] == 1) {
                        return false; // 돌기와 돌기가 만나면 안됨
                    }
                }
            }
        }
        return true;
    }

    // 3. 열쇠의 돌기와 자물쇠의 홈이 일치하는지 확인하는 함수 작성
    public boolean isKeyFit(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int lockX = i;
                int lockY = j;
                if (lockX >= 0 && lockX < N && lockY >= 0 && lockY < N) {
                    if (key[i][j] == 1 && lock[lockX][lockY] == 0) {
                        return false; // 돌기와 홈이 일치하지 않으면 안됨
                    }
                }
            }
        }
        return true;
    }

    // 4. 자물쇠의 모든 홈이 채워졌는지 확인하는 함수 작성
    public boolean isLockOpen(int[][] lock) {
        int N = lock.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) {
                    return false; // 홈이 하나라도 비어있으면 안됨
                }
            }
        }
        return true;
    }

    // 5. 위의 함수들을 조합하여 solution 함수 작성
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;

        // 1. 자물쇠를 3배 크기로 확장 (열쇠가 밖으로 나가는 경우 처리)
        int size = n + (m - 1) * 2;
        
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key); // 90도 회전
            
            // 2. 확장된 판 위에서 열쇠를 한 칸씩 이동
            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {
                    
                    // 새로운 확장 판 생성
                    int[][] newLock = new int[size][size];
                    for(int i=0; i<n; i++) {
                        for(int j=0; j<n; j++) {
                            newLock[i + m - 1][j + m - 1] = lock[i][j];
                        }
                    }

                    // 3. 열쇠 끼워넣기 (더하기 연산)
                    if (check(newLock, key, x, y, m, n)) return true;
                }
            }
        }
        return false;
    }

    // 열쇠를 끼우고 자물쇠가 열리는지 확인하는 통합 함수
    public boolean check(int[][] newLock, int[][] key, int x, int y, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newLock[x + i][y + j] += key[i][j]; // 돌기(1) + 홈(0) = 1 (OK)
            }
        }

        // 중앙의 실제 자물쇠 영역이 모두 1인지 확인
        for (int i = m - 1; i < m + n - 1; i++) {
            for (int j = m - 1; j < m + n - 1; j++) {
                if (newLock[i][j] != 1) return false; // 0(여전히 홈)이거나 2(돌기 충돌)면 실패
            }
        }
        return true;
    }
}
