package LeetCode.easy;

import java.util.Arrays;

public class Problem2460 {
    //https://leetcode.com/problems/apply-operations-to-an-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1,2,2,1,1,0})));
        System.out.println(Arrays.toString(applyOperations(new int[]{0,1})));
        System.out.println(Arrays.toString(applyOperations(new int[]{0,1})));
    }

    //https://leetcode.com/problems/apply-operations-to-an-array/solutions/2787793/java-100-faster-o-n-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.3 MB
    //Beats
    //75%
    static int[] applyOperations(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int prev = i - 1;
            if (nums[prev] == nums[i] && nums[prev] != 0) {
                nums[prev] += nums[prev];
                nums[i] = 0;
            }
        }

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[idx++] = temp;
            }
        }
        return nums;
    }
}
