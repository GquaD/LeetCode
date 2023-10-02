package LeetCode.medium;

public class Problem1749 {
    //https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{-7,-1,0,-2,1,3,8,-2,-6,-1,-10,-6,-6,8,-4,-9,-4,1,4,-9}));
        System.out.println(maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
        System.out.println(maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
    }

    //nn
    //Runtime
    //6 ms
    //Beats
    //34.98%
    //Memory
    //54.9 MB
    //Beats
    //26.63%
    static int maxAbsoluteSum(int[] nums) {
        int sum = 0, max = 0, min = 0;
        for (int n : nums) {
            max = Math.max(0, n + max);
            min = Math.min(0, n + min);
            sum = Math.max(sum, Math.max(max, -min));
        }
        return sum;
    }

    //24 of of 59
    static int maxAbsoluteSum1(int[] nums) {
        int sum = 0, l = 0, tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            if (Math.abs(tempSum) <= Math.abs(tempSum - nums[l]))
                tempSum -= nums[l++];
            sum = Math.max(sum, Math.abs(tempSum));
        }
        return sum;
    }
}
