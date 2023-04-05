package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem40 {
    //https://leetcode.com/problems/combination-sum-ii/description/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 7));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    //https://leetcode.com/problems/combination-sum-ii/solutions/3382064/java-3ms-backtracking-solution/
    //Runtime
    //3 ms
    //Beats
    //68.53%
    //Memory
    //42.6 MB
    //Beats
    //79.28%
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();
        goBacktracking(0, 0, new ArrayList<>(), candidates, target, set);
        return new ArrayList<>(set);
    }

    private static void goBacktracking(int idx, int sum, ArrayList<Integer> list, int[] arr, int target, Set<List<Integer>> set) {
        if (sum == target) {
            set.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                if (i > idx && arr[i] == arr[i - 1]) continue; //omit duplicate cases
                sum += arr[i];
                list.add(arr[i]);
                goBacktracking(i + 1, sum, list, arr, target, set);
                sum -= arr[i];
                list.remove(list.size() - 1);
            }
        }
    }
}
