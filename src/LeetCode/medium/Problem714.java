package LeetCode.medium;

public class Problem714 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }

    //nnnn
    //Runtime
    //4 ms
    //Beats
    //99.11%
    //Memory
    //54.8 MB
    //Beats
    //42.39%
    static int maxProfit(int[] prices, int fee) {
        int noStockOnHands = 0, stockOnHands = Integer.MIN_VALUE;
        for (int p : prices) {
            int noStockOnHandsOld = noStockOnHands;
            noStockOnHands = Math.max(noStockOnHands, stockOnHands + p);
            stockOnHands = Math.max(stockOnHands, noStockOnHandsOld - p - fee);
        }
        return noStockOnHands;
    }

    static int maxProfit1(int[] prices, int fee) {
        int max = 0, temp = prices[0], diff = 0;
        for (int i = 1; i < prices.length; i++) {
            diff = prices[i] - temp - fee;
            if (diff > 0) {
                temp = i + 1 < prices.length ? prices[i + 1] : prices[prices.length - 1];
                max += diff;
            }
        }
        return diff > 0 ? max + diff : max;
    }
}
