package LeetCode.medium;

public class Problem377 {
    //https://leetcode.com/problems/combination-sum-iv/description/
    public static void main(String[] args) {

    }

    //nnn
    //Runtime
    //1 ms
    //Beats
    //72.35%
    //Memory
    //39.6 MB
    //Beats
    //73.34%
    static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) for (int n : nums) if (n <= i) dp[i] += dp[i - n];
        return dp[target];
    }
}
