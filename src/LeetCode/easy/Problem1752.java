package LeetCode.easy;

public class Problem1752 {
    //https://leetcode.com/problems/check-if-array-is-sorted-and-rotated
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/solutions/6362597/java-100-faster-solution-by-tbekpro-w6fn/
    //3min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.33
    //MB
    //Beats
    //50.38%
    public boolean check(int[] nums) {
        int len = nums.length, count = 1, max = 1;
        for (int i = 1; i < len * 2; i++) {
            if (nums[i % len] >= nums[(i - 1) % len]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, Math.min(len, count));
        }
        return max == len;
    }
}
