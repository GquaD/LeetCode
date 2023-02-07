package LeetCode.easy;

import java.util.Arrays;

public class Problem1608 {
    //https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,6,7,7,0}));
        System.out.println(specialArray(new int[]{3, 5}));
    }

    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //78.25%
    //Memory
    //39.9 MB
    //Beats
    //80.25%
    static int specialArray(int[] nums) {
        if (nums.length == 1) return nums[0] > 0 ? 1 : -1;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[nums.length - 1 - i];
            if (curr < count) {
                return count - 1 == 0 || count - 1 == curr ? -1 : count - 1;
            }
            count++;
        }
        return count - 1;
    }
}
