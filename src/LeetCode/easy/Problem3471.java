package LeetCode.easy;

import java.util.*;

public class Problem3471 {
    //https://leetcode.com/problems/find-the-largest-almost-missing-integer
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-largest-almost-missing-integer/solutions/6495236/java-3-cases-solution-by-tbekpro-xjf9/
    //15min
    //Runtime
    //3
    //ms
    //Beats
    //83.50%
    //Analyze Complexity
    //Memory
    //42.95
    //MB
    //Beats
    //96.31%
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        if (k == nums.length) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        } else if (k == 1) {
            Arrays.sort(nums);
            int i = nums.length - 1;
            while (i >= 0) {
                if (map.get(nums[i]) == 1) return nums[i];
                i--;
            }
        } else {
            int a = nums[0], b = nums[nums.length - 1], max = Math.max(a, b), min = Math.min(a, b);
            if (a == b) return -1;
            if (map.get(max) == 1) return max;
            if (map.get(min) == 1) return min;
        }
        return -1;
    }
}
