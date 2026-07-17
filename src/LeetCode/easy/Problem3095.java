package LeetCode.easy;

public class Problem3095 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //44.17
    //MB
    //Beats
    //51.34%
    //https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/solutions/8403759/java-100-fast-solution-by-tbekpro-3cxw/
    public int minimumSubarrayLength(int[] nums, int k) {
        for (int i = 1; i <= nums.length; i++) {
            for (int j = i; j <= nums.length; j++) {
                int or = 0;
                for (int l = j - i; l < j; l++)
                    or |= nums[l];

                if (or >= k) return i;
            }
        }
        return -1;
    }
}
