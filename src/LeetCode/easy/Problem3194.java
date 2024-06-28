package LeetCode.easy;

import java.util.Arrays;

public class Problem3194 {
    //https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements
    public static void main(String[] args) {

    }

    //1min
    //Runtime
    //2
    //ms
    //Beats
    //98.87%
    //Analyze Complexity
    //Memory
    //43.50
    //MB
    //Beats
    //87.35%
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double min = 50.0;
        for (int i = 0; i < nums.length / 2; i++) {
            int a = nums[nums.length - i - 1], b = nums[i];
            min = Math.min(min, (a + b) / 2.0);
        }
        return min;
    }
}
