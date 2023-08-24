package LeetCode.medium;

import java.util.Arrays;

public class Problem462 {
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
    public static void main(String[] args) {

    }

    //
    //10min
    //Runtime
    //5 ms
    //Beats
    //62.57%
    //Memory
    //43.4 MB
    //Beats
    //88.31%
    static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2], res = 0;
        for (int n : nums) res += Math.abs(n - median);
        return res;
    }

    static int minMoves21(int[] nums) {
        long sum = 0;
        for (int n : nums) sum += n;
        int avg = (int) sum / nums.length, res = 0;
        for (int n : nums) res += Math.abs(n - avg);
        return res;
    }
}
