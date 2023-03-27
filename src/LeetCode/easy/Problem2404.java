package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem2404 {
    //https://leetcode.com/problems/most-frequent-even-element/

    //Runtime
    //46 ms
    //Beats
    //18.19%
    //Memory
    //42.3 MB
    //Beats
    //77.97%
    static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (n % 2 == 0) {
                if (map.containsKey(n)) map.put(n, map.get(n) + 1);
                else map.put(n, 1);
            }
        }
        int maxFreq = 0, res = -1;
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (maxFreq < freq) {
                maxFreq = freq;
                res = key;
            }
        }
        return res;
    }
}
