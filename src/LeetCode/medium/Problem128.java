package LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Problem128 {
    //https://leetcode.com/problems/longest-consecutive-sequence/
    public static void main(String[] args) {

    }

    //nnnn O(N)
    //Runtime
    //36 ms
    //Beats
    //60.54%
    //Memory
    //72 MB
    //Beats
    //13.62%
    static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int max = 0;
        for (int n : set) {
            if (set.contains(n + 1)) continue;
            int count = 0;
            while (set.contains(n - ++count));
            max = Math.max(max, count);
        }
        return max;
    }


    //15 min, but it's O(N log N) and not O(N) solution
    //Runtime
    //80 ms
    //Beats
    //47.2%
    //Memory
    //62.8 MB
    //Beats
    //19.63%
    static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) set.add(n);
        int prev = set.pollFirst(), count = 1, max = 0;
        while (set.size() > 0) {
            int curr = set.pollFirst();
            if (curr - prev == 1) count++;
            else {
                max = Math.max(count, max);
                count = 1;
            }
            prev = curr;
        }
        return Math.max(count, max);
    }

    static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int count = 1, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) count++;
            else {
                if (max < count) max = count;
                count = 1;
            }
        }
        return Math.max(count, max);
    }
}
