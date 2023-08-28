package LeetCode.easy;

import java.util.Arrays;

public class Problem2605 {
    //https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/
    public static void main(String[] args) {

    }

    //3 min
    //Runtime
    //1 ms
    //Beats
    //95.80%
    //Memory
    //40.4 MB
    //Beats
    //69.54%
    static int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++)
                if (nums1[i] == nums2[j]) return nums1[i];
        return nums1[0] < nums2[0] ? nums1[0] * 10 + nums2[0] : nums2[0] * 10 + nums1[0];
    }
}
