package LeetCode.easy;

import java.util.Arrays;

public class Problem2540 {
    //https://leetcode.com/problems/minimum-common-value
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-common-value/solutions/4848360/java-binarysearch-until-1st-found/
    //5-10min
    //Runtime
    //5
    //ms
    //Beats
    //36.74%
    //of users with Java
    //Memory
    //62.81
    //MB
    //Beats
    //32.96%
    //of users with Java
    static int getCommon(int[] nums1, int[] nums2) {
        int prev = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            if (cur == prev) continue;
            int idx = Arrays.binarySearch(nums2, cur);
            if (idx >= 0) {
                min = Math.min(cur, min);
                break;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
