package LeetCode.medium;

import java.util.Arrays;

public class Problem164 {
    //https://leetcode.com/problems/maximum-gap/
    public static void main(String[] args) {

    }



    //not O(N) solution
    //5min
    //Runtime
    //42 ms
    //Beats
    //30.36%
    //Memory
    //61.8 MB
    //Beats
    //16.58%
    static int maximumGap1(int[] nums) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) max = Math.max(max, nums[i] - nums[i - 1]);
        return max;
    }
}
