package LeetCode.easy;

public class Problem3903 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //46.37
    //MB
    //Beats
    //-%
    //https://leetcode.com/problems/smallest-stable-index-i/solutions/8010136/java-100-faster-solution-by-tbekpro-59vm/
    public int firstStableIndex(int[] nums, int k) {
        int[] arrMin = new int[nums.length];
        arrMin[arrMin.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            arrMin[i] = Math.min(arrMin[i + 1], nums[i]);
        }

        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max - arrMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
