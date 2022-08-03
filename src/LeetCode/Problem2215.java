package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2215 {
    //
    public static void main(String[] args) {
        findDifference(new int[]{1,2,3}, new int[]{2,4,6});
        findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2});
    }

    //Runtime: 21 ms, faster than 61.63% of Java online submissions for Find the Difference of Two Arrays.
    //Memory Usage: 54.7 MB, less than 58.80% of Java online submissions for Find the Difference of Two Arrays.
    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        List<Integer> list2 = new ArrayList<>();
        for (Integer i : set2) {
            if (!set1.contains(i)){
                list2.add(i);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        for (Integer i : set1) {
            if (!set2.contains(i)){
                list1.add(i);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        return res;
    }
}
