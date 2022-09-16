package LeetCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations46 {
    static List<List<Integer>> mainList = new ArrayList<>();

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3, 4});

        printMainList();
    }

    private static void printMainList() {
        System.out.println("\nMain list:");
        for (List<Integer> combo : mainList) {
            System.out.println(Arrays.toString(combo.toArray()));
        }
        System.out.println("Size of main list: " + mainList.size());
    }

    //.looping
    public static List<List<Integer>> permute1(int[] nums) {

        return null;
    }


    //recursive algo

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        mainList.add(list);
        generateRecursive(list, 0, list.size() - 1);
        return mainList;
    }

    static List<Integer> generateRecursive(List<Integer> combination, int pos1, int pos2) {
        List<Integer> newCombination = rearrange(combination, pos1, pos2);
        if (!listContains(newCombination)) {
            mainList.add(newCombination);
        }
        if (combination.size() <= pos1 || pos2 < 0) {
            return null;
        }

        generateRecursive(newCombination, pos1 + 1, pos2);
        generateRecursive(newCombination, pos1, pos2 - 1);


        /*while (pos1 != pos2) {
            generateRecursive(newCombination, pos1, pos2 - 1);
        }*/
        //generateRecursive(combination, pos1 + 1, pos2 - 1);
        System.out.println("Combination: " + Arrays.toString(newCombination.toArray()) + ", pos1 = " + pos1 + ", pos2 = " + pos2);
        return null;
    }

    private static List<Integer> rearrange(List<Integer> combination, int pos1, int pos2) {
        if (combination.size() <= pos1 || pos2 < 0) {
            return combination;
        }

        List<Integer> result = new ArrayList<>(combination);

        int tempPos1 = result.get(pos1);
        int tempPos2 = result.get(pos2);

        result.remove(pos1);
        result.add(pos1, tempPos2);
        result.remove(pos2);
        result.add(pos2, tempPos1);

        return result;
    }

    static boolean listContains(List<Integer> givenCombo) {
        int givenSize = givenCombo.size();
        boolean result = mainList.stream()
                .filter(combo -> combo.size() == givenSize)
                .anyMatch(combo -> equals(combo, givenCombo));
        return result;
    }

    static boolean equals(List<Integer> one, List<Integer> two) {
        if (one.size() != two.size()) {
            return false;
        }
        for (int i = 0; i < one.size(); i++) {
            if (!one.get(i).equals(two.get(i))) {
                return false;
            }
        }
        return true;
    }
}
