package LeetCode.easy;

public class Problem4120 {
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //72.81%
    //Memory
    //45.96
    //MB
    //Beats
    //53.94%
    public int countDominantElements(int[] nums) {
        if (nums.length == 1) return 1;
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i - 1] + nums[i + 1]) * 1.0 / 2 <= nums[i] * 1.0) {
                count++;
            }
        }

        if (nums[0] >= nums[1]) count++;
        if (nums[nums.length - 1] >= nums[nums.length - 2]) count++;

        return count;
    }
}
