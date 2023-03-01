package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {
    //https://leetcode.com/problems/combination-sum-iii/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum3(3, 7));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(combinationSum3(3, 9));
    }

    //https://leetcode.com/problems/combination-sum-iii/solutions/3242522/java-100-faster-backtracking-solution/
    //1 hour
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.9 MB
    //Beats
    //60.49%
    static List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= k || n > 55) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        goBackTracking(1, new ArrayList<>(), result, k, n, 0);

        return result;
    }

    private static void goBackTracking(int i, List<Integer> list, List<List<Integer>> result, int k, int sum, int tempSum) {
        if (list.size() == k) {
            if (tempSum == sum) {
                result.add(new ArrayList<>(list));
            }
            //list.remove(list.size() - 1);
            return;
        }

        for (int j = i; j < 10; j++) {
            list.add(j);
            goBackTracking(j + 1, list, result, k, sum, tempSum + j);
            list.remove(list.size() - 1);
        }
        //if (!list.isEmpty()) list.remove(list.size() - 1);
    }
}
