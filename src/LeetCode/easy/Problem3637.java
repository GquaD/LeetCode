package LeetCode.easy;

public class Problem3637 {
    //https://leetcode.com/problems/trionic-array-i/solutions/7422727/java-on-100-faster-solution-by-tbekpro-i2c8/
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.74
    //MB
    //Beats
    //12.94%
    public static void main(String[] args) {

    }

    //5min
    public boolean isTrionic(int[] nums) {
        boolean isPos = true;
        int switchCount = 0;
        if (nums[1] - nums[0] <= 0) return false;

        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) return false;

            boolean pos = diff > 0;
            if (isPos != pos) {
                switchCount++;
                if (switchCount > 2) return false;
                isPos = pos;
            }
        }
        return switchCount == 2;
    }
}
