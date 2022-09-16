package LeetCode.easy;

import java.util.LinkedHashSet;
import java.util.Set;

public class Problem2154 {
    //https://leetcode.com/problems/keep-multiplying-found-values-by-two/
    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{5, 3, 6, 1, 12}, 3));
        System.out.println(findFinalValue(new int[]{2, 7, 9}, 4));
        System.out.println(findFinalValue(new int[]{2, 7, 9, 4}, 4));
    }

    //Runtime: 3 ms, faster than 69.41% of Java online submissions for Keep Multiplying Found Values by Two.
    //Memory Usage: 42 MB, less than 92.87% of Java online submissions for Keep Multiplying Found Values by Two.
    static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
