package LeetCode.medium;

import java.util.TreeMap;

public class Problem2762 {
    //https://leetcode.com/problems/continuous-subarrays
    public static void main(String[] args) {

    }

    //40min
    //nn
    //Runtime
    //27
    //ms
    //Beats
    //53.54%
    //Analyze Complexity
    //Memory
    //58.70
    //MB
    //Beats
    //58.69%
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        long res = 0;
        for (int right = 0; right < nums.length; right++) {
            int cur = nums[right];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                int l = nums[left], freq = map.get(l);
                if (freq > 1) {
                    map.put(l, freq - 1);
                } else {
                    map.remove(l);
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
