package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    //https://leetcode.com/problems/subsets/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(subsets(new int[]{1,2,3}));
    }

    //https://leetcode.com/problems/subsets/discuss/2565503/Java-Backtracking-Solution-or-90-faster
    //5-10 minutes (cuz I had similar code in other problem's solution)
    //Runtime: 1 ms, faster than 89.66% of Java online submissions for Subsets.
    //Memory Usage: 43.8 MB, less than 18.20% of Java online submissions for Subsets.
    static int[] numbers;
    static List<List<Integer>> combinations;
    static List<List<Integer>> subsets(int[] nums) {
        numbers = nums;
        combinations = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            findCombinations(i, new ArrayList<>());
        }
        combinations.add(new ArrayList<>());
        return combinations;
    }

    private static void findCombinations(int idxStart, List<Integer> list) {
        if (idxStart >= numbers.length) {
            combinations.add(new ArrayList<>(list));
            return;
        }
        list.add(numbers[idxStart]);
        for (int i = idxStart + 1; i <= numbers.length; i++) {
            findCombinations(i, list);
        }
        list.remove(list.size() - 1);
    }
}
