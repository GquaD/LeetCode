package LeetCode.medium;

import java.util.Arrays;

public class Problem3627 {
    //5min
    //https://leetcode.com/problems/maximum-median-sum-of-subsequences-of-size-3/solutions/7857945/your-java-average-solution-by-tbekpro-soat/
    //Runtime
    //28
    //ms
    //Beats
    //31.32%
    //Memory
    //166.19
    //MB
    //Beats
    //59.34%
    public long maximumMedianSum(int[] nums) {
        long sum = 0;
        Arrays.sort(nums);
        int i = nums.length - 2, reps = nums.length / 3;
        while (reps-- > 0) {
            sum += nums[i];
            i -= 2;
        }

        return sum;
    }
}
