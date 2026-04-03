package LeetCode.easy;

public class Problem3038 {
    //2min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.58
    //MB
    //Beats
    //71.35%
    //https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/solutions/7766683/java-100-faster-solution-by-tbekpro-rohn/
    public int maxOperations(int[] nums) {
        int score = nums[0] + nums[1], ops = 1;
        for (int i = 2; i < nums.length - 1; i += 2) {
            if (nums[i] + nums[i + 1] == score) ops++;
            else break;
        }
        return ops;
    }
}
