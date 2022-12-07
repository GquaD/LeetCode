package LeetCode.easy;

public class Problem1800 {
    //https://leetcode.com/problems/maximum-ascending-subarray-sum/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-ascending-subarray-sum/solutions/2887772/java-100-time-97-memory-solution/
    //5-10min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.7 MB
    //Beats
    //96.8%
    static int maxAscendingSum(int[] nums) {
        int sum = nums[0], maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                sum += nums[i];
            } else {
                if (maxSum < sum) {
                    maxSum = sum;
                }
                sum = nums[i];
            }
        }
        if (maxSum < sum) {
            maxSum = sum;
        }
        return maxSum;
    }
}
