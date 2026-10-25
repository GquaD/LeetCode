package LeetCode.easy;

public class Problem4088 {
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //-%
    //Memory
    //45.53
    //MB
    //Beats
    //100.00%
    public int peakValleyDifference(int[] nums) {
        int peak = 0, valley = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) peak += nums[i];
            else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) valley += nums[i];
        }

        return peak - valley;
    }
}
