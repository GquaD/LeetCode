package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2275 {
    //https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
    public static void main(String[] args) {
        System.out.println(largestCombination(new int[]{16,17,71,62,12,24,14}));
        System.out.println(largestCombination(new int[]{8,8}));
    }

    static List<List<Integer>> combinations;
    static int[] allNums;
    static int largestCombination(int[] candidates) {
        combinations = new ArrayList<>();
        allNums = candidates;
        for (int i = 0; i < candidates.length; i++) {
            findCombinations(i, new ArrayList<>());
        }

        int maxAndSize = 0;
        for (int i = 0; i < combinations.size(); i++) {
            List<Integer> combo = combinations.get(i);
            int tempAnd = combo.get(0);
            for (int j = 1; j < combo.size(); j++) {
                tempAnd &= combo.get(j);
            }
            if (tempAnd > 0 && maxAndSize < combo.size()) {
                maxAndSize = combo.size();
            }
        }
        return maxAndSize;
    }

    private static void findCombinations(int idxStart, List<Integer> nums) {
        if (idxStart >= allNums.length) {
            combinations.add(new ArrayList<>(nums));
            return;
        }
        nums.add(allNums[idxStart]);
        for (int i = idxStart + 1; i <= allNums.length; i++) {
            findCombinations(i, nums);
        }
        nums.remove(nums.size() - 1);
    }
}
