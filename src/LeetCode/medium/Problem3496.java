package LeetCode.medium;

public class Problem3496 {
    //https://leetcode.com/problems/maximize-score-after-pair-deletions/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximize-score-after-pair-deletions/solutions/6581952/java-on-solution-100-faster-with-explana-79uz/
    //5-10min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //59.16
    //MB
    //Beats
    //100.00%
    public int maxScore(int[] nums) {
        int score = nums[0], idx = 0, min = Integer.MAX_VALUE;
        if (nums.length % 2 == 0) {
            for (int i = 1; i < nums.length; i++) {
                score += nums[i];
                if (min > nums[i] + nums[i - 1]) {
                    idx = i;
                    min = nums[i] + nums[i - 1];
                }
            }
            return score - nums[idx] - nums[idx - 1];
        } else {
            min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                score += nums[i];
                min = Math.min(min, nums[i]);
            }
            return score - min;
        }

    }
}
