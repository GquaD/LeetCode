package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem2956 {
    //https://leetcode.com/problems/find-common-elements-between-two-arrays/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-common-elements-between-two-arrays/solutions/4530067/java-o-n-hashset/
    //5min
    //Runtime
    //6 ms
    //Beats
    //70.32%
    //Memory
    //45.4 MB
    //Beats
    //16.11%
    static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        int n = nums1.length, m = nums2.length;
        for (int i = 0; i < n; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < m; i++) {
            set2.add(nums2[i]);
        }

        int[] arr = new int[2];
        for (int i = 0; i < n; i++) {
            if (set2.contains(nums1[i])) arr[0]++;
        }
        for (int i = 0; i < n; i++) {
            if (set1.contains(nums2[i])) arr[1]++;
        }
        return arr;
    }
}
