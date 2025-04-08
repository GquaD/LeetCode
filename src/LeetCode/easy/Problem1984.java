package LeetCode.easy;

import java.util.Arrays;

public class Problem1984 {
    //https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/solutions/6627252/java-simple-solution-explained-by-tbekpr-kw9r/
    //5min
    //Runtime
    //5
    //ms
    //Beats
    //97.36%
    //Analyze Complexity
    //Memory
    //44.52
    //MB
    //Beats
    //44.49%
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[k - 1] - nums[0];
        for (int i = k; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        }
        return min;
    }
}
