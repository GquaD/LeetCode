package LeetCode;

import java.util.Arrays;

public class Problem2206 {
    //https://leetcode.com/problems/divide-array-into-equal-pairs/
    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));
    }

    //Runtime: 6 ms, faster than 59.55% of Java online submissions for Divide Array Into Equal Pairs.
    //Memory Usage: 45.7 MB, less than 79.14% of Java online submissions for Divide Array Into Equal Pairs.
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
