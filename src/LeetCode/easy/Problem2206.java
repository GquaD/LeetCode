package LeetCode.easy;

import java.util.Arrays;

public class Problem2206 {
    //https://leetcode.com/problems/divide-array-into-equal-pairs/
    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));
    }

    //Runtime
    //4
    //ms
    //Beats
    //74.89%
    //Analyze Complexity
    //Memory
    //44.16
    //MB
    //Beats
    //94.91%
    static boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
