package LeetCode;

import java.util.*;

public class Permutation46v2 {
    //https://leetcode.com/problems/permutations/
    //solved

    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[]{5, 6, 7, 8});

        printMainList(list);
    }

    private static void printMainList(List<List<Integer>> mainList) {
        System.out.println("\nMain list:");
        for (List<Integer> combo : mainList) {
            System.out.println(Arrays.toString(combo.toArray()));
        }
        System.out.println("Size of main list: " + mainList.size());
    }

    public static List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        List<Integer> listGiven = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            listGiven.add(nums[i]);
        }

        int sizeOfFinalListWithCombinations = calculateNumberOfCombinations(nums.length);

        while (set.size() < sizeOfFinalListWithCombinations) {
            List<Integer> temp = generateCombinationPositions(nums);
            List<Integer> combination = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                combination.add(nums[temp.get(i)]);
            }
            set.add(combination);
        }

        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    private static List<Integer> generateCombinationPositions(int[] nums) {
        return generateUniqueNumbersCombination(nums.length);
    }

    private static List<Integer> generateUniqueNumbersCombination(int length) {
        Set<Integer> set = new LinkedHashSet<>(length);
        Random random = new Random();
        while (set.size() < length) {
            set.add(random.nextInt(length));
        }
        return new ArrayList<>(set);
    }

    private static int calculateNumberOfCombinations(int length) {
        if (length == 1) {
            return 1;
        }
        if (length == 2) {
            return 2;
        }
        int result = 2;
        for (int i = 2; i < length; i++) {
            result *= i + 1;
        }
        return result;
    }
}
