package LeetCode.easy;

import java.util.Arrays;

public class Problem1051 {
    //https://leetcode.com/problems/height-checker/
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(heightChecker(new int[]{1, 2, 3, 4, 5}));
    }

    //Runtime: 2 ms, faster than 72.90% of Java online submissions for Height Checker.
    //Memory Usage: 42.4 MB, less than 15.15% of Java online submissions for Height Checker.
    static int heightChecker(int[] heights) {
        int count = 0;
        int[] hCopy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (hCopy[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
