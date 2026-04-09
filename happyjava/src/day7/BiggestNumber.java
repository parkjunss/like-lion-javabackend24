package day7;

import java.util.Arrays;

public class BiggestNumber {
    int[] nums;

    public BiggestNumber(int ... numbers) {
        this.nums = new int[numbers.length];
        System.arraycopy(numbers, 0, nums, 0, numbers.length);
    }

    public int[]  getNums() {
        return nums;
    }

    public int[] sort() {
        Arrays.sort(nums);
        return nums;
    }

    public int getBiggestNumber() {
        this.sort();
        return nums[nums.length - 1];
    }

    public void printBiggestNumber() {
        System.out.println("Biggest Number: " + getBiggestNumber());
    }
}
