package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1133 {
    //https://leetcode.com/problems/largest-unique-number

    //1min
    //Runtime
    //5
    //ms
    //Beats
    //38.63%
    //Analyze Complexity
    //Memory
    //42.97
    //MB
    //Beats
    //41.31%
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        int max = -1;
        for (int k : map.keySet()) if (map.get(k) == 1 && k > max) max = k;
        return max;
    }
}
