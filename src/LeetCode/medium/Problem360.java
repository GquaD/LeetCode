package LeetCode.medium;

import java.util.Arrays;

public class Problem360 {
    //https://leetcode.com/problems/sort-transformed-array/
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //2
    //ms
    //Beats
    //41.29%
    //of users with Java
    //Memory
    //42.28
    //MB
    //Beats
    //97.01%
    //of users with Java
    static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = a * x * x + b * x  + c;
        }
        Arrays.sort(nums);
        return nums;
    }
}
