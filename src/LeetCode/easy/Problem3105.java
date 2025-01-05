package LeetCode.easy;

public class Problem3105 {
    //https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/solutions/6235579/java-on-solution-by-tbekpro-o7n5/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //89.30%
    //Analyze Complexity
    //Memory
    //42.82
    //MB
    //Beats
    //37.27%
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 2) return nums[0] != nums[1] ? 2 : 1;

        int inc = nums[1] - nums[0] == 0 ? 0 : nums[1] > nums[0] ? 1 : -1;
        int temp = inc == 0 ? 1 : 2, res = temp;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                if (inc == 1) {
                    temp++;
                } else {
                    temp = 2;
                }
                inc = 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                if (inc == -1) {
                    temp++;
                } else {
                    temp = 2;
                }
                inc = -1;
            } else {
                temp = 1;
                inc = 0;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
