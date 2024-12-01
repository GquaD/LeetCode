package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1346 {
    //https://leetcode.com/problems/check-if-n-and-its-double-exist
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //5
    //ms
    //Beats
    //8.99%
    //Analyze Complexity
    //Memory
    //44.02
    //MB
    //Beats
    //7.10%
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: arr) map.put(n, map.getOrDefault(n, 0) + 1);
        if (map.containsKey(0)) {
            int freq = map.get(0);
            if (freq > 1)
                return true;
        }
        for (int n: arr) {
            if (n != 0 && map.containsKey(n * 2))
                return true;
        }

        return false;
    }
}
