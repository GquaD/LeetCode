package LeetCode.easy;

import java.util.Arrays;

public class Problem3774 {
    //https://leetcode.com/problems/absolute-difference-between-maximum-and-minimum-k-elements
    public static void main(String[] args) {

    }

    //1min
    //Runtime
    //6
    //ms
    //Beats
    //32.48%
    //Analyze Complexity
    //Memory
    //46.42
    //MB
    //Beats
    //96.28%
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i] - nums[nums.length - i - 1];
        return Math.abs(sum);
    }
}
