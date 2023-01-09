package LeetCode.medium;

import java.util.Arrays;

public class Problem122 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/3023461/java-3-line-o-n-solution/
    //Runtime
    //1 ms
    //Beats
    //92.96%
    //Memory
    //42.6 MB
    //Beats
    //61.79%
    static int maxProfit(int[] p) {
        int count = 0;
        for (int i = 1; i < p.length; i++) if (p[i] - p[i - 1] > 0) count += p[i] - p[i - 1];
        return count;
    }

    //15 min
    //Runtime
    //1 ms
    //Beats
    //92.96%
    //Memory
    //42.3 MB
    //Beats
    //75.67%
    static int maxProfit1(int[] p) {
        int count = 0;
        for (int i = 1; i < p.length; i++) {
            int diff = p[i] - p[i - 1];
            if (diff > 0) count += diff;
        }
        return count;
    }
}
