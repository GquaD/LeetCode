package LeetCode.medium;

import java.util.*;

public class Problem90 {
    //https://leetcode.com/problems/subsets-ii/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/subsets-ii/solutions/3179302/java-backtracking-solution/
    //15 min since typical backtracking problem
    //Runtime
    //2 ms
    //Beats
    //44.55%
    //Memory
    //42.6 MB
    //Beats
    //51%
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        set.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            goBacktracking(i, nums, new ArrayList<>(), set);
        }
        return new ArrayList<>(set);
    }

    private static void goBacktracking(int i, int[] nums, ArrayList<Integer> list, Set<List<Integer>> set) {
        if (i >= nums.length) {
            List<Integer> templist = new ArrayList<>(list);
            Collections.sort(templist);
            set.add(templist);
            return;
        }

        list.add(nums[i]);

        for (int j = i + 1; j <= nums.length; j++) {
            goBacktracking(j, nums, list, set);
        }
        list.remove(list.size() - 1);
    }
}
