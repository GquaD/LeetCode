package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1426 {

    //https://leetcode.com/problems/counting-elements/description/
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //37.68%
    //Analyze Complexity
    //Memory
    //42.06
    //MB
    //Beats
    //8.43%
    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        int sum = 0;
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (map.containsKey(key + 1)) {
                sum += freq;
            }
        }
        return sum;
    }
}
