package LeetCode.medium;

public class Problem309 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(maxProfit(new int[]{1}));
        System.out.println(maxProfit(new int[]{4,3,2,10,11,0,11}));
    }


    //nnnn
    //Runtime
    //3 ms
    //Beats
    //30.66%
    //Memory
    //41.7 MB
    //Beats
    //76.24%
    static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int sell = 0, buy = -prices[0], cool = 0, minBuy = buy, temp = sell;
        for (int i = 1; i < len; i++) {
            int curr = prices[i];
            sell = minBuy + curr;
            buy = cool - curr;
            cool = Math.max(cool, temp);
            temp = sell;
            minBuy = Math.max(minBuy, buy);
        }
        return Math.max(sell, cool);
    }
}
