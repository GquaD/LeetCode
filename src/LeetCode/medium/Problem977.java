package LeetCode.medium;

import java.util.Arrays;

public class Problem977 {
    //https://leetcode.com/problems/squares-of-a-sorted-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
    //Runtime: 7 ms, faster than 38.39% of Java online submissions for Squares of a Sorted Array.
    //Memory Usage: 55.2 MB, less than 74.33% of Java online submissions for Squares of a Sorted Array.
    static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) nums[i] *= nums[i];
        Arrays.sort(nums);
        return nums;
    }
}
