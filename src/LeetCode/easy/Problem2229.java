package LeetCode.easy;

import java.util.Arrays;

public class Problem2229 {
    //https://leetcode.com/problems/check-if-an-array-is-consecutive
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-an-array-is-consecutive/solutions/5780470/java-o-nlogn-n-solution/
    //1min
    //Runtime
    //29
    //ms
    //Beats
    //36.84%
    //Analyze Complexity
    //Memory
    //56.64
    //MB
    //Beats
    //94.74%
    static boolean isConsecutive(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev != 1) {
                return false;
            }
            prev = nums[i];
        }
        return true;
    }
}
