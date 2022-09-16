package LeetCode.easy;

import java.util.Arrays;

public class Problem1920 {
    //solution for https://leetcode.com/problems/build-array-from-permutation/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[] {0,2,1,5,3,4})));
        System.out.println(Arrays.toString(buildArray(new int[] {5,0,1,2,3,4})));
        System.out.println(Arrays.toString(buildArray2(new int[] {0,2,1,5,3,4})));
        System.out.println(Arrays.toString(buildArray2(new int[] {5,0,1,2,3,4})));
    }
        //this solution is faster and consumes less memory
    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public static int[] buildArray2(int[] nums) {
        return Arrays.stream(nums)
                .map(el -> el = nums[el])
                .toArray();
    }
}
