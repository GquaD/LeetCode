package LeetCode.easy;

import java.util.Arrays;

public class Problem3131 {
    //https://leetcode.com/problems/find-the-integer-added-to-array-i/description/
    public static void main(String[] args) {

    }

    //1min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //43.33
    //MB
    //Beats
    //33.33%
    //of users with Java
    static int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}
