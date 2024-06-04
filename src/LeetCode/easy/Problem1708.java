package LeetCode.easy;

public class Problem1708 {
    //https://leetcode.com/problems/largest-subarray-length-k/description/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //2
    //ms
    //Beats
    //96.15%
    //of users with Java
    //Memory
    //55.59
    //MB
    //Beats
    //50.00%
    //of users with Java
    static int[] largestSubarray(int[] nums, int k) {
        int idx = 0, max = -1;
        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[idx + i];
        }
        return res;
    }
}
