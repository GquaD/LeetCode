package LeetCode.easy;

import java.util.TreeMap;

public class Problem4065 {
    //2min
    //Runtime
    //12
    //ms
    //Beats
    //11.18%
    //Memory
    //45.89
    //MB
    //Beats
    //99.97%
    public int[] rearrangeArray(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        int idx = 0;
        while (idx < nums.length) {
            for (int key: map.keySet()) {
                int freq = map.get(key);
                if (freq > 0) {
                    nums[idx++] = key;
                    map.put(key, freq - 1);
                }
            }
        }

        return nums;
    }
}
