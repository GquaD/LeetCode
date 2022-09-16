package LeetCode.easy;

import java.util.Arrays;

public class Problem1929 {
    //solution for https://leetcode.com/problems/concatenation-of-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[] {3, 2, 1, 0})));

    }

    public static int[] getConcatenation(int[] nums) {
        int[] result = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }
}
