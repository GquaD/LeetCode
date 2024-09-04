package LeetCode.easy;

public class Problem3264 {
    //https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/


    //https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/solutions/5735626/java-100-faster-in-place-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.58
    //MB
    //Beats
    //92.72%
    static int[] getFinalState(int[] nums, int k, int m) {
        for (int i = 0; i < k; i++) {
            int min = nums[0], idx = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }
            nums[idx] *= m;
        }
        return nums;
    }
}
