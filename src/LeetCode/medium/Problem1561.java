package LeetCode.medium;

import java.util.Arrays;

public class Problem1561 {
    //https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2,4,1,2,7,8}));
        System.out.println(maxCoins(new int[]{2,4,5}));
        System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }

    //Runtime: 34 ms, faster than 81.81% of Java online submissions for Maximum Number of Coins You Can Get.
    //Memory Usage: 68.7 MB, less than 66.63% of Java online submissions for Maximum Number of Coins You Can Get.
    static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        int index = piles.length - 2;
        for (int i = 0; i < piles.length / 3; i++) {
            sum +=  piles[index];
            index -= 2;
        }
        return sum;
    }
}
