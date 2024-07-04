package LeetCode.medium;

public class Problem3205 {
    //https://leetcode.com/problems/maximum-array-hopping-score-i/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-array-hopping-score-i/solutions/5415367/java-100-100-solution/
    //nnn
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.57
    //MB
    //Beats
    //100.00%
    static int maxScore(int[] nums) {
        int score = 0, max = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            max = Math.max(nums[i], max);
            score += max;
        }
        return score;
    }
}
