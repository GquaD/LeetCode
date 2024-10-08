package LeetCode.easy;

public class Problem1099 {
    //https://leetcode.com/problems/two-sum-less-than-k
    public static void main(String[] args) {

    }

    //2min
    //Runtime
    //3
    //ms
    //Beats
    //23.42%
    //Analyze Complexity
    //Memory
    //41.22
    //MB
    //Beats
    //98.90%
    public int twoSumLessThanK(int[] nums, int k) {
        int sum = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int t = nums[i] + nums[j];
                if (t < k) {
                    sum = Math.max(sum, t);
                }
            }
        }
        return sum;
    }
}
