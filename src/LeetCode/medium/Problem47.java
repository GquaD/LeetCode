package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem47 {
    //https://leetcode.com/problems/permutations-ii/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(permuteUnique(new int[]{1,1,2}));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(permuteUnique(new int[]{1,2,3}));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(permuteUnique(new int[]{0,3,2,1,1,1}));
    }

    //nnnn
    //Runtime
    //3 ms
    //Beats
    //61.75%
    //Memory
    //42.8 MB
    //Beats
    //89.66%

    static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        goBacktracking(nums, new ArrayList<>(), list, map);
        return list;
    }

    private static void goBacktracking(int[] nums, ArrayList<Integer> list, List<List<Integer>> listResult, Map<Integer, Integer> map) {
        if (list.size() == nums.length) {
            listResult.add(new ArrayList<>(list));
            return;
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq != 0) {
                map.put(key, freq - 1);
                list.add(key);
                goBacktracking(nums, list, listResult, map);
                list.remove(list.size() - 1);
                map.put(key, freq);
            }
        }
    }

    /*static Set<List<Integer>> combinations;
    static List<Integer> allnums;
    static int[] integers;

    static List<List<Integer>> permuteUnique(int[] nums) {
        integers = nums;
        allnums = new ArrayList<>();
        int size = nums.length * 2;
        for (int i = 0; i < size; i++) {
            allnums.add(nums[i >= nums.length ? size - i - 1 : i]);
        }
        combinations = new HashSet<>();
        int mult = nums.length * nums.length;
        for (int i = 0; i < mult; i++) {
            findCombination(i % nums.length, new ArrayList<>());
        }
        return new ArrayList<>(combinations);
    }

    private static void findCombination(int idxStart, List<Integer> list) {
        if (list.size() == integers.length) {
            if (allNumbersInvolved(list)) {
                combinations.add(new ArrayList<>(list));
            }
            return;
        }
        if (idxStart >= allnums.size() || list.size() > integers.length) {
            return;
        }
        list.add(allnums.get(idxStart));
        for (int i = idxStart + 1; i <= allnums.size(); i++) {
            findCombination(i, list);
        }
        list.remove(list.size() - 1);
    }

    private static boolean allNumbersInvolved(List<Integer> list) {
        List<Integer> temp = new ArrayList<>(list);
        for (int i : integers) {
            if (temp.contains(i)) {
                temp.remove(Integer.valueOf(i));
            } else {
                return false;
            }
        }
        return true;
    }*/
}
