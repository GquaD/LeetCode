package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem39 {
    //https://leetcode.com/problems/combination-sum/
    public static void main(String[] args) {
        //LeetCodeUtils.printListWithListsOfIntegers(combinationSum(new int[]{2,3,6,7}, 7));
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum3(new int[]{2, 3, 5}, 8));
        //LeetCodeUtils.printListWithListsOfIntegers(combinationSum(new int[]{7,3,2}, 18));
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum3(new int[]{11, 8, 4, 3, 12, 5}, 31));
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum3(new int[]{18, 34, 2, 16, 25, 6, 35}, 40));

    }

    //Runtime
    //2 ms
    //Beats
    //99.71%
    //Memory
    //42.5 MB
    //Beats
    //93.84%
    static List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(0, candidates, target, res, new ArrayList<>());
        System.out.println("////////////////////////////");
        System.out.println("Count = " + res.size());
        return res;
    }

    static void findCombinations(int i, int[] candidates, int target, List<List<Integer>> result, List<Integer> combo) {
        if (i >= candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(combo));
            }
            return;
        }
        if (candidates[i] <= target) {
            combo.add(candidates[i]);
            findCombinations(i, candidates, target - candidates[i], result, combo);
            combo.remove(combo.size() - 1);
        }
        findCombinations(i + 1, candidates, target, result, combo);
    }

    //todo overall 3 hours spent so far
    //time limit exceeded
    static List<Integer> allNums;
    static Set<List<Integer>> result;

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> allNumsPossible = new ArrayList<>();
        int sum = 0;
        for (int num : candidates) {
            allNumsPossible.add(num);
            sum += num;
            while (sum + num <= target) {
                allNumsPossible.add(num);
                sum += num;
            }
            sum = 0;
        }
        allNums = allNumsPossible;
        result = new HashSet<>();
        int curr = 0;
        for (int i = 0; i < allNumsPossible.size(); i++) {
            if (curr != allNumsPossible.get(i)) {//added this
                curr = allNumsPossible.get(i);
                backtrack(i, target, new ArrayList<>());
            }
        }
        System.out.println("////////////////////////////");
        System.out.println("Count = " + result.size());
        return new ArrayList<>(result);
    }

    private static void backtrack(int idxStart, int target, List<Integer> ints) {
        if (idxStart >= allNums.size()) {
            return;
        }

        ints.add(allNums.get(idxStart));
        int sumTemp = 0;
        for (int i = 0; i < ints.size(); i++) {
            sumTemp += ints.get(i);
        }
        if (sumTemp == target) {
            result.add(new ArrayList<>(ints));
            //LeetCodeUtils.printList(ints);
        } else if (sumTemp < target) {
            for (int i = idxStart + 1; i < allNums.size(); i++) {
                backtrack(i, target, ints);
            }
        }
        ints.remove(ints.size() - 1);
    }


    static int[] nums;

    /*static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        nums = candidates;
        result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            while (sum < target) {
                backtrack1(i, target, list);
                sum += nums[i];
                list.add(nums[i]);
            }
        }
        return result;
    }*/

    private static void backtrack1(int idxStart, int target, List<Integer> ints) {
        if (idxStart >= nums.length) {
            return;
        }

        ints.add(nums[idxStart]);
        int sumTemp = 0;
        for (int i = 0; i < ints.size(); i++) {
            sumTemp += ints.get(i);
        }
        if (sumTemp == target) {
            result.add(new ArrayList<>(ints));
            return;
        } else if (sumTemp < target) {
            for (int i = idxStart; i < nums.length; i++) {
                backtrack1(i, target, ints);
            }
        }
        ints.remove(ints.size() - 1);
    }
}
