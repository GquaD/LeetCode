package LeetCode.easy;

import java.util.Arrays;

public class Problem2974 {
    //https://leetcode.com/problems/minimum-number-game/description/
    public static void main(String[] args) {

    }

    //1min
    //Runtime
    //3 ms
    //Beats
    //40.38%
    //Memory
    //44.6 MB
    //Beats
    //91.77%
    static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int t = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = t;
        }
        return nums;
    }
}
