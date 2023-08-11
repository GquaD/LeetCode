package LeetCode.medium;

import java.util.Arrays;

public class Problem518 {
    //https://leetcode.com/problems/coin-change-ii/
    public static void main(String[] args) {
        System.out.println(change(0, new int[]{7}));
        System.out.println(change(5, new int[]{1,2,5}));
        System.out.println(change(13, new int[]{1,2,3,5}));
        System.out.println(change(3, new int[]{2}));
        System.out.println(change(10, new int[]{10}));
        System.out.println(change(500, new int[]{3,5,7,8,9,10,11}));
    }

    //nnnn
    //Runtime
    //2 ms
    //Beats
    //100%
    //Memory
    //40.2 MB
    //Beats
    //83.90%
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

    //Time Limit Exceeded
    //14 / 28
    static int change1(int amount, int[] coins) {
        int[] res = new int[1];
        Arrays.sort(coins);
        recursive(coins, amount, 0, res);
        return res[0];
    }

    private static void recursive(int[] coins, int amountLeft, int idx, int[] res) {
        if (idx >= coins.length) return;

        if (amountLeft == 0) {
            res[0]++;
            return;
        }

        for (int i = idx; i < coins.length; i++)
            if (amountLeft - coins[i] >= 0)
                recursive(coins, amountLeft - coins[i], i, res);
    }
}
