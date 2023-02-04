package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem77 {
    //https://leetcode.com/problems/combinations/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(combine(4, 2));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(combine(1, 1));
    }

    //https://leetcode.com/problems/combinations/solutions/3139162/java-backtracking-solution/
    //10-15 min
    //Runtime
    //35 ms
    //Beats
    //27.15%
    //Memory
    //43.6 MB
    //Beats
    //73.4%
    static List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            findUsingBackTracking(i, k, n, list, set);
        }
        return new ArrayList<>(set);
    }

    private static void findUsingBackTracking(int curr, int k, int n, List<Integer> list, Set<List<Integer>> set) {
        if (list.size() > k) {
            return;
        }

        list.add(curr);

        if (list.size() == k) {
            set.add(new ArrayList<>(list));
        }

        for (int i = curr + 1; i <= n; i++) {
            findUsingBackTracking(i, k, n, list, set);
        }
        list.remove(list.size() - 1);
    }
}
