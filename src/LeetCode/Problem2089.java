package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2089 {
    //https://leetcode.com/problems/find-target-indices-after-sorting-array/submissions/
    public static void main(String[] args) {

    }

    //Runtime: 4 ms, faster than 46.24% of Java online submissions for Find Target Indices After Sorting Array.
    //Memory Usage: 43.6 MB, less than 71.87% of Java online submissions for Find Target Indices After Sorting Array.
    static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }
}
