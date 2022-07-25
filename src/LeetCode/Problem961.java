package LeetCode;

import java.util.Arrays;

public class Problem961 {
    //https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    //Runtime: 3 ms, faster than 56.68% of Java online submissions for N-Repeated Element in Size 2N Array.
    //Memory Usage: 53.9 MB, less than 71.75% of Java online submissions for N-Repeated Element in Size 2N Array.
    static int repeatedNTimes1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                count++;
                if (nums[i] == nums[j] && i != j) {
                    System.out.println("count = " + count);
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //Runtime: 8 ms, faster than 43.67% of Java online submissions for N-Repeated Element in Size 2N Array.
    //Memory Usage: 55.4 MB, less than 24.63% of Java online submissions for N-Repeated Element in Size 2N Array.
    static int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
