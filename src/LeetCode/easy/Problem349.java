package LeetCode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem349 {
    //https://leetcode.com/problems/intersection-of-two-arrays/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    //Runtime: 18 ms, faster than 5.40% of Java online submissions for Intersection of Two Arrays.
    //Memory Usage: 43.7 MB, less than 73.10% of Java online submissions for Intersection of Two Arrays.
    static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !set.contains(nums2[j])) {
                    set.add(nums2[j]);
                }
            }
        }
        int[] res = new int[set.size()];
        int count = 0;
        for (Integer i : set) {
            res[count++] = i;
        }
        return res;
    }
}
