// int[] original = {1, 2, 3, 4, 5};
// int[] copy1 = original; // 참조 복사 (얕은 복사)
// copy1[0] = 10; // original 배열도 영향을 받음
// System.out.println("Original: " + Arrays.toString(original)); // [10,

// int[] copy2 = new int[original.length]; // 새로운 배열 생성 (깊은 복사)
// for(int i = 0; i < original.length; i++) {
//     copy2[i] = original[i]; // 원소 복사 
// }