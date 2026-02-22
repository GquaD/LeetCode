package LeetCode.medium;

public class Problem3847 {
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //47.10
    //MB
    //Beats
    //-%
    //https://leetcode.com/problems/find-the-score-difference-in-a-game/solutions/7600894/java-100-faster-solution-by-tbekpro-4r49/
    public int scoreDifference(int[] nums) {
        int one = 0, two = 0;
        boolean oneActive = true;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if ((i + 1) % 6 == 0) oneActive = !oneActive;
            if (val % 2 == 1) oneActive = !oneActive;

            if (oneActive) one += val;
            else two += val;
        }

        return one - two;
    }
}
