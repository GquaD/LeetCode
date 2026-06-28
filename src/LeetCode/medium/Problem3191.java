package LeetCode.medium;

public class Problem3191 {
    //20min

    //Runtime
    //7
    //ms
    //Beats
    //62.94%
    //Memory
    //102.34
    //MB
    //Beats
    //79.47%
    public int minOperations(int[] nums) {
        int i = 0, flips = 0;

        while (i < nums.length) {
            i = findNextZero(nums, i);

            if (i == nums.length) break;
            if (i >= nums.length - 2) return -1;
            nums[i] = nums[i] == 1 ? 0 : 1;
            nums[i + 1] = nums[i + 1] == 1 ? 0 : 1;
            nums[i + 2] = nums[i + 2] == 1 ? 0 : 1;
            flips++;
            i++;
        }

        return flips;
    }

    private int findNextZero(int[] nums, int idx) {
        while (idx < nums.length) {
            if (nums[idx] == 0) {
                break;
            }
            idx++;
        }

        return idx;
    }
}
