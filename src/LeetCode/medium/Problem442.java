package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem442 {
    //https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/
    public static void main(String[] args) {

    }

    //5 mins
    //Runtime: 35 ms, faster than 15.65% of Java online submissions for Find All Duplicates in an Array.
    //Memory Usage: 67.1 MB, less than 42.43% of Java online submissions for Find All Duplicates in an Array.
    static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
