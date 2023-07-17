package LeetCode.easy;

import java.util.Arrays;

public class Problem976 {
    //https://leetcode.com/problems/largest-perimeter-triangle/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //Details
    //9ms
    //Beats 75.45%of users with Java
    //Memory
    //Details
    //45.28mb
    //Beats 6.65%of users with Java
    static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) if (nums[i] < nums[i - 1] + nums[i - 2]) return nums[i] + nums[i - 1] + nums[i - 2];
        return 0;
    }
}
