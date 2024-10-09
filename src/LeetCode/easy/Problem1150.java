package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1150 {
    //https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/solutions/5890856/java-hashmap-solution/
    //2min
    //Runtime
    //3
    //ms
    //Beats
    //6.51%
    //Analyze Complexity
    //Memory
    //42.71
    //MB
    //Beats
    //5.92%
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        int max = 0, key = 0;
        for (int k : map.keySet()) {
            int freq = map.get(k);
            if (freq > max) {
                max = freq;
                if (freq > nums.length / 2) key = k;
            }
        }
        return key == target;
    }
}
