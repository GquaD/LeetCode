package LeetCode.medium;

public class Problem3904 {
    //solution is the same as f or 3903

    //Runtime
    //4
    //ms
    //Beats
    //94.46%
    //Memory
    //133.26
    //MB
    //Beats
    //24.72%
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
