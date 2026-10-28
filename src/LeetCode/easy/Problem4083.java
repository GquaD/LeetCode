package LeetCode.easy;

public class Problem4083 {
    //1min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //45.84
    //MB
    //Beats
    //40.88%
    public int minDeletions(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) if (nums[i] == nums[i - 1]) count++;
        return count;
    }
}
