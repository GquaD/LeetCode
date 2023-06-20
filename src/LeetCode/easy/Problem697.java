package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem697 {
    //https://leetcode.com/problems/degree-of-an-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/degree-of-an-array/solutions/3659825/java-using-frequency-map/
    //10 min
    //Runtime
    //12 ms
    //Beats
    //93.84%
    //Memory
    //46 MB
    //Beats
    //74.10%
    static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); //freq map
        for (int k : nums) map.put(k, map.getOrDefault(k, 0) + 1);
        int max = 0;
        for (int k : map.keySet()) max = Math.max(map.get(k), max);
        List<Integer> maxFreqValues = new ArrayList<>();
        for (int k : map.keySet()) if (map.get(k) == max) maxFreqValues.add(k);
        if (max == 1) return 1;
        int min = nums.length;
        for (int v : maxFreqValues) {
            int l = -1, r = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == v) {
                    if (l == -1) l = i;
                    else r = i;
                }
            }
            min = Math.min(min, r - l + 1);
            if (min == v) return min;
        }
        return min;
    }
}
