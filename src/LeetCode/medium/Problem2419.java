package LeetCode.medium;

public class Problem2419 {
    //https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/solutions/4541696/java-100-faster-o-n-solution/
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //59.70
    //MB
    //Beats
    //22.34%
    //of users with Java
    static int longestSubarray(int[] nums) {
        int max = 0, len = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                count = 1;
                len = 0;
            } else if (max == nums[i]) {
                count++;
            } else {
                len = Math.max(len, count);
                count = 0;
            }

        }

        return Math.max(len, count);
    }


    //
    //10min
    //Runtime
    //3
    //ms
    //Beats
    //93.62%
    //of users with Java
    //Memory
    //59.58
    //MB
    //Beats
    //25.53%
    //of users with Java
    static int longestSubarray1(int[] nums) {
        int max = 0, len = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                count++;
            } else {
                len = Math.max(len, count);
                count = 0;
            }
        }

        return Math.max(len, count);
    }
}
