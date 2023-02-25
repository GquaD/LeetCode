package LeetCode.easy;

import java.util.Arrays;

public class Problem121 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    public static void main(String[] args) {
        System.out.println(maxProfit3(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit3(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit3(new int[]{1,2,4}));
        System.out.println(maxProfit3(new int[]{2, 1, 2, 0, 1}));
        System.out.println(maxProfit3(new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println("/////");
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit2(new int[]{1,2,4}));

    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/3227191/java-o-n-99-98-faster-solution/
    //5 min
    //Runtime
    //1 ms
    //Beats
    //99.98%
    //Memory
    //59.2 MB
    //Beats
    //42.39%
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int min = prices[0], maxDiff = 0;
        for (int n : prices) {
            min = Math.min(n, min);
            maxDiff = Math.max(maxDiff, n - min);
        }
        return maxDiff;
    }

    //time limit exceeded
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (result < prices[j] - prices[i]) {
                    result = prices[j] - prices[i];
                }
            }
        }
        if (result <= 0) {
            return 0;
        }
        return result;
    }

    //Runtime: 2 ms, faster than 93.07% of Java online submissions for Best Time to Buy and Sell Stock.
    //Memory Usage: 59 MB, less than 92.02% of Java online submissions for Best Time to Buy and Sell Stock.
    public static int maxProfit3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int soFarMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > soFarMin) {
                max = Math.max(max, prices[i] - soFarMin);
            } else {
                soFarMin = prices[i];
            }
        }
        return max;
    }
}
