package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2934 {
    //https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/solutions/4467362/java-greedy-o-n-100-faster/
    //1 hour
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //45.2 MB
    //Beats
    //7.20%
    static int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, max1 = 0, max2 = 0, count1 = 0, count2 = 0;

        max1 = Math.min(nums1[n - 1], nums2[n - 1]);
        max2 = Math.max(nums1[n - 1], nums2[n - 1]);

        for (int i = 0; i < n; i++) {
            int min = Math.min(nums1[i], nums2[i]), max = Math.max(nums1[i], nums2[i]);

            if (max > max2 || min > max1) return -1;

            if (max == nums1[i] && max != min && max > max1) count1++;
            if (max == nums2[i] && max != min && max > max1) count2++;
        }
        return Math.min(count1, count2);
    }

    static int minOperations2(int[] nums1, int[] nums2) {
        int n = nums1.length, max1 = 0, max2 = 0, count1 = 0, count2 = 0;
        int[] arr1 = new int[n], arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            max1 = Math.max(nums1[i], max1);
            max2 = Math.max(nums2[i], max2);
        }

        if (max1 == nums1[n - 1] && max2 == nums2[n - 1]) return 0;

        int max11 = 0, max21 = 0;

        for (int i = 0; i < n; i++) {
            arr1[i] = nums1[i] > max1 ? nums2[i] : nums1[i];
            arr2[i] = nums2[i] > max2 ? nums1[i] : nums2[i];

            max11 = Math.max(arr1[i], max1);
            max21 = Math.max(arr2[i], max2);

            if (arr1[i] != nums1[i]) count1++;
            if (arr1[i] != nums2[i]) count2++;
        }

        if (max11 != arr1[n - 1] || max21 != arr2[n - 1]) return -1;
        return Math.min(count1, count2);
    }

    static int minOperations1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        int max1 = 0, max2 = 0, count = 0, n = nums1.length;
        for (int i = 0; i < n; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
            max1 = Math.max(max1, nums1[i]);
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
            max2 = Math.max(max2, nums2[i]);
        }
        if (nums1[n - 1] == max1 && nums2[n - 1] == max2) return 0;
        else if (nums1[n - 1] != max1 && nums2[n - 1] != max2) return -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums1[i] > max2 || nums2[i] > max1) {

            }
        }
        return 1;
    }
}
