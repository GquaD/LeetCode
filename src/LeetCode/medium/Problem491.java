package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem491 {
    //https://leetcode.com/problems/non-decreasing-subsequences/description/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(findSubsequences(new int[]{4,6,7,7}));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(findSubsequences(new int[]{4,4,3,2,1}));
    }

    //https://leetcode.com/problems/non-decreasing-subsequences/solutions/3075741/java-recursive-solution/
    //my sample
    //25 minutes
    //Runtime
    //16 ms
    //Beats
    //47.82%
    //Memory
    //49.1 MB
    //Beats
    //69.9%
    static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            goRecursive(i, new ArrayList<>(), nums, set);
        }
        return new ArrayList<>(set);
    }

    private static void goRecursive(int idx, List<Integer> list, int[] nums, Set<List<Integer>> set) {
        if (idx == nums.length) {
            if (list.size() > 1) {
                List<Integer> listNew = new ArrayList<>(list);
                set.add(listNew);
            }
            return;
        }

        int curr = nums[idx++];
        if (!list.isEmpty() && curr >= list.get(list.size() - 1)) list.add(curr);
        else list.add(curr);

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] >= list.get(list.size() - 1)) goRecursive(i, list, nums, set);
        }

        if (list.size() > 1) {
            List<Integer> listNew = new ArrayList<>(list);
            set.add(listNew);
        }

        if (!list.isEmpty()) list.remove(list.size() - 1);
    }

    private static void goRecursive1(int idx, List<Integer> list, int[] nums, Set<List<Integer>> set) {
        if (idx == nums.length) {
            if (list.size() > 1) {
                List<Integer> listNew = new ArrayList<>(list);
                set.add(listNew);
            }
            return;
        }

        int curr = nums[idx++];
        if (!list.isEmpty() && curr >= list.get(list.size() - 1)) list.add(curr);
        else list.add(curr);

        if (list.size() > 1) {
            List<Integer> listNew = new ArrayList<>(list);
            set.add(listNew);
        }
        goRecursive1(idx, list, nums, set);
        if (!list.isEmpty()) list.remove(list.size() - 1);
    }
}
