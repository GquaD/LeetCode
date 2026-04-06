package LeetCode.easy;

public class Problem643 {
    //5min

    //Runtime
    //3
    //ms
    //Beats
    //81.39%
    //Memory
    //69.48
    //MB
    //Beats
    //82.95%
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) sum += nums[i];
        max = Math.max(max, sum);
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max * 1.0 / k;
    }
}
