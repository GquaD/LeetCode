package LeetCode.medium;

import java.util.Arrays;

public class Problem1685 {
    //https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }


    //https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/solutions/3950001/java-o-n-solution/
    //30-40 min
    //Runtime
    //3 ms
    //Beats
    //95.65%
    //Memory
    //59 MB
    //Beats
    //52.57%
    static int[] getSumAbsoluteDifferences(int[] nums) {
        int sumPost = 0, sumBefore = 0;
        for (int n : nums) sumPost += n;
        int arr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sumPost -= nums[i];
            arr[i] = nums[i] * i - sumBefore + sumPost - nums[i] * (nums.length - i - 1);
            sumBefore += nums[i];
        }
        return arr;
    }
}
