package LeetCode.easy;

public class Problem2970 {
    //15min
    //Runtime
    //7
    //ms
    //Beats
    //42.86%
    //Memory
    //44.19
    //MB
    //Beats
    //94.12%
    public int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a; b < nums.length; b++) {
                if (isIncreasingOnRemoval(nums, a, b)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isIncreasingOnRemoval(int[] nums, int start, int end) {
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < start || i > end) {
                if (prev >= nums[i]) {
                    return false;
                }
                prev = nums[i];
            }
        }

        return true;
    }
}
