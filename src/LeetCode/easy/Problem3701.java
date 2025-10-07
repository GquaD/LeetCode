package LeetCode.easy;

public class Problem3701 {
    //https://leetcode.com/problems/compute-alternating-sum/description/
    //Runtime
    //1
    //ms
    //Beats
    //95.24%
    //Analyze Complexity
    //Memory
    //44.82
    //MB
    //Beats
    //24.09%
    //1min
    public int alternatingSum(int[] nums) {
        int sum = 0, sign = -1;
        for (int n: nums) {
            sign *= -1;
            sum += sign * n;
        }
        return sum;
    }
}
