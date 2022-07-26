package LeetCode;

import java.util.Arrays;

public class Problem1475 {
    //https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(finalPrices(new int[]{10, 1, 1, 6})));
    }
    //Runtime: 2 ms, faster than 82.16% of Java online submissions for Final Prices With a Special Discount in a Shop.
    //Memory Usage: 44.8 MB, less than 10.08% of Java online submissions for Final Prices With a Special Discount in a Shop.
    static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
