package LeetCode.easy;

import java.util.Arrays;

public class Problem905 {
    //https://leetcode.com/problems/sort-array-by-parity/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0})));
    }

    //Runtime: 1 ms, faster than 99.98% of Java online submissions for Sort Array By Parity.
    //Memory Usage: 48.4 MB, less than 38.27% of Java online submissions for Sort Array By Parity.
    static int[] sortArrayByParity(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int t = nums[temp];
                nums[temp++] = nums[i];
                nums[i] = t;
            }
        }
        return nums;
    }
}
