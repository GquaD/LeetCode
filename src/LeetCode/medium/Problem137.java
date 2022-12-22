package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem137 {
    //https://leetcode.com/problems/single-number-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/single-number-ii/solutions/2938028/java-simple-map-solution/
    //Runtime
    //4 ms
    //Beats
    //79%
    //Memory
    //42.1 MB
    //Beats
    //79.41%
    static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return 0;
    }
}
