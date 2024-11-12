package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem170 {
    //https://leetcode.com/problems/two-sum-iii-data-structure-design
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //123
    //ms
    //Beats
    //21.00%
    //Analyze Complexity
    //Memory
    //52.59
    //MB
    //Beats
    //43.57%
    class TwoSum {
        Map<Integer, Integer> map;
        public TwoSum() {
            map = new HashMap<>();
        }

        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (int n: map.keySet()) {
                int freq = map.get(n), diff = value - n;
                if (diff == n) {
                    if (freq > 1) return true;
                } else if (map.containsKey(diff)) {
                    return true;
                }
            }
            return false;
        }
    }
}
