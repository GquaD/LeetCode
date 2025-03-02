package LeetCode.easy;

public class Problem3467 {
    //https://leetcode.com/problems/transform-array-by-parity
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/transform-array-by-parity/solutions/6486372/java-even-count-solution-by-tbekpro-jn2c/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.81
    //MB
    //Beats
    //100.00%
    public int[] transformArray(int[] nums) {
        int zero = 0, len = nums.length;
        for (int n: nums) if (n % 2 == 0) zero++;
        for (int i = 0; i < len; i++) nums[i] = i < zero ? 0 : 1;
        return nums;
    }
}
