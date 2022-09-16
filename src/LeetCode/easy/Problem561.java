package LeetCode.easy;

import java.util.Arrays;

public class Problem561 {
    //https://leetcode.com/problems/array-partition/
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1,4,3,2}));
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
//        System.out.println(arrayPairSum(new int[]{}));
    }

    //Runtime: 17 ms, faster than 52.39% of Java online submissions for Array Partition.
    //Memory Usage: 53.6 MB, less than 72.43% of Java online submissions for Array Partition.
    static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
