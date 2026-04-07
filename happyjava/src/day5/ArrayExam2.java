package day5;

import java.util.Arrays;

public class ArrayExam2 {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};

        int index = Arrays.binarySearch(original, 3); // 배열에서 3의 인덱스 검색
        System.out.println("Index of 3: " + index); // 2

        // sort array
        int[] unsorted = {5, 2, 4, 1, 3};
        Arrays.sort(unsorted); // 배열 정렬
        System.out.println("Sorted array: " + Arrays.toString(unsorted)); // [1, 2, 3, 4, 5]

        // copy array
        int[] copy = Arrays.copyOf(original, original.length); // 배열 복사
        System.out.println("Copied array: " + Arrays.toString(copy)); // [1,

        // fill array
        int[] filled = new int[5];
        Arrays.fill(filled, 7); // 배열을 7로 채우기
        System.out.println("Filled array: " + Arrays.toString(filled)); // [7, 7, 7, 7, 7]

        // equals array
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("Arrays equal: " + Arrays.equals(arr1, arr2)); // true

        // toString array
        System.out.println("Array as string: " + Arrays.toString(original)); // [1

        // deepToString for multi-dimensional arrays
        int[][] multiDim = {{1, 2}, {3, 4}};
        System.out.println("Multi-dimensional array: " + Arrays.deepToString(multiDim)); // [[1, 2], [3, 4]]

        // parallelSort for large arrays
        int[] largeArray = {5, 2, 4, 1, 3};
        Arrays.parallelSort(largeArray); // 대규모 배열을 병렬로 정렬
        System.out.println("Parallel sorted array: " + Arrays.toString(largeArray)); // [1, 2, 3, 4, 5]



        

    }
}
