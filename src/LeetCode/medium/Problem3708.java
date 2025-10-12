package LeetCode.medium;

public class Problem3708 {
    //https://leetcode.com/problems/longest-fibonacci-subarray/
    //https://leetcode.com/problems/longest-fibonacci-subarray/solutions/7269625/java-100100-solution-by-tbekpro-tfzg/
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //58.34
    //MB
    //Beats
    //100.00%
    public int longestSubarray(int[] nums) {
        int max = 2, len = 2;
        for (int i = 2; i < nums.length; i++) {
            int f3 = nums[i], f2 = nums[i - 1], f1 = nums[i - 2];
            if (f1 + f2 == f3) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 2;
            }
        }
        return Math.max(max, len);
    }
}
