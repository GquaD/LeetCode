package LeetCode.medium;

public class Problem3192 {
    //https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/solutions/5630714/java-o-n-solution-beats-99/
    //5min
    //Runtime
    //6
    //ms
    //Beats
    //99.31%
    //Analyze Complexity
    //Memory
    //63.04
    //MB
    //Beats
    //15.25%
    public int minOperations(int[] nums) {
        int flips = 0;
        for (int n: nums) {
            if (flips % 2 == 0 && n == 0) {
                flips++;
            } else if (flips % 2 == 1 && n == 1) {
                flips++;
            }
        }
        return flips;
    }
}
