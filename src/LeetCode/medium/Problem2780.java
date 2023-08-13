package LeetCode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2780 {
    //https://leetcode.com/problems/minimum-index-of-a-valid-split/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-index-of-a-valid-split/solutions/3901318/java-o-n-solution/
    //7min
    //Runtime
    //29 ms
    //Beats
    //80.83%
    //Memory
    //57.7 MB
    //Beats
    //35.10%
    static int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        int dominant = nums.get(0), freq = 0;
        for (int key : map.keySet()) {
            int tempFreq = map.get(key);
            if (freq < tempFreq) {
                freq = tempFreq;
                dominant = key;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) count++;
            if (count * 2 > i + 1 && (freq - count) * 2 > nums.size() - i - 1) return i;
        }
        return -1;
    }
}
