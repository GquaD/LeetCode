package LeetCode.medium;

import java.util.Arrays;

public class Problem2364 {
    //https://leetcode.com/problems/count-number-of-bad-pairs/
    public static void main(String[] args) {

    }

    static long countBadPairs(int[] nums) {
        return 0;
    }

    //correct but TLE on 57/65
    static long countBadPairs2(int[] nums) {
        long count = 0, len = nums.length;
        for (int i = 0; i < len - 1; i++) for (int j = i + 1; j < len; j++) if (j - i != nums[j] - nums[i]) count++;
        return count;
    }

    static long countBadPairs1(int[] nums) {
        int count = 0;
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) count += Math.abs(nums[i] - arr[i]);
        return count;
    }
}
