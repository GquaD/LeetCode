package LeetCode.easy;

public class Problem4074 {
    //5min
    //Runtime
    //3
    //ms
    //Beats
    //38.45%
    //Memory
    //46.49
    //MB
    //Beats
    //92.89%
    public int[] maxProductPair(int[] nums, int target) {
        int a = -1, b = -1, max = -100_000;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j] && nums[i] + nums[j] == target && nums[i] * nums[j] > max) {
                    max = nums[i] * nums[j];
                    a = nums[i] > nums[j] ? i : j;
                    b = nums[i] > nums[j] ? j : i;;
                }
            }
        }

        return new int[]{a, b};
    }
}
