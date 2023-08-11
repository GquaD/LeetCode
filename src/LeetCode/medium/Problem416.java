package LeetCode.medium;

public class Problem416 {
    //https://leetcode.com/problems/partition-equal-subset-sum/
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
        System.out.println(canPartition(new int[]{1,2,3,5}));
        System.out.println(canPartition(new int[]{1,2,5}));
    }

    //nnn
    //Runtime
    //28 ms
    //Beats
    //87.88%
    //Memory
    //40.8 MB
    //Beats
    //93.89%
    static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 == 1) return false;
        sum /= 2;
        boolean dp[] = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums)
            for (int i = sum; i > 0; i--)
                if (i >= n) dp[i] = dp[i] || dp[i - n];
        return dp[sum];
    }

    static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }

    static boolean canPartition1(int[] nums) {
        int sum = 0, max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(n, max);
        }
        if (sum % 2 == 1) return false;
        return sum / 2 > max;
    }
}
