package LeetCode.medium;

public class Problem1493 {
    //https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
    }

    //nnn
    //Runtime
    //3 ms
    //Beats
    //29.43%
    //Memory
    //53.4 MB
    //Beats
    //11.97%
    static int longestSubarray(int[] nums) {
        int l = 0, maxWindow = 0, lastZero = -1;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                l = lastZero + 1;
                lastZero = r;
            }
            maxWindow = Math.max(maxWindow, r - l);
        }
        return maxWindow;
    }

    static int longestSubarray1(int[] nums) {
        int count1 = 0, max = 0;
        boolean isFirstZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count1++;
            } else {
                if (count1 > 0 && isFirstZero) {
                    isFirstZero = false;
                } else {
                    max = Math.max(count1, max);
                    count1 = 0;
                    isFirstZero = true;
                }
            }
        }
        if (count1 == nums.length) count1--;
        return Math.max(count1, max);
    }
}
