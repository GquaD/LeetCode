package LeetCode.easy;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1403 {
    //https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
    public static void main(String[] args) {
        LeetCodeUtils.printList(minSubsequence(new int[]{4,3,10,9,8}));
    }

    //Runtime: 23 ms, faster than 5.13% of Java online submissions for Minimum Subsequence in Non-Increasing Order.
    //Memory Usage: 45.7 MB, less than 12.35% of Java online submissions for Minimum Subsequence in Non-Increasing Order.
    static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list);
        //Collections.reverse(list);
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        int sumBigger = 0;
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (sum >= sumBigger) {
            int curr = list.get(list.size() - 1 - count++);
            result.add(curr);
            sumBigger += curr;
            sum -= curr;
        }
        return result;
    }
}
