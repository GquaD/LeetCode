package LeetCode.easy;

import java.util.Arrays;

public class Problem1460 {
    //https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
    public static void main(String[] args) {

    }

    //Runtime: 4 ms, faster than 74.27% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.
    //Memory Usage: 45.6 MB, less than 68.86% of Java online submissions for Make Two Arrays Equal by Reversing Sub-arrays.

    static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
