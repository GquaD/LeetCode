package LeetCode.medium;

import java.util.Arrays;

public class Problem1769 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110")));
        System.out.println(Arrays.toString(minOperations("001011")));
    }
    //Runtime: 371 ms, faster than 21.60% of Java online submissions for Minimum Number of Operations to Move All Balls to Each Box.
    //Memory Usage: 48.2 MB, less than 16.04% of Java online submissions for Minimum Number of Operations to Move All Balls to Each Box.
    static int[] minOperations(String boxes) {
        int sumOfMoves = 0;
        int res[] = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) == '1') {
                    sumOfMoves += Math.abs(j - i);
                }
            }
            res[i] = sumOfMoves;
            sumOfMoves = 0;
        }
        return res;
    }
}
