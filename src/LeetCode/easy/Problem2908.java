package LeetCode.easy;

public class Problem2908 {
    //https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //2 ms
    //Beats
    //21.88%
    //Memory
    //40.5 MB
    //Beats
    //84.30%
    static int minimumSum(int[] nums) {
        int min = 151;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) min = Math.min(min, nums[i] + nums[j] + nums[k]);
                }
            }
        }
        return min == 151 ? -1 : min;
    }
}
