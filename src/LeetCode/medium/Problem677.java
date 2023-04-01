package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem677 {
    //https://leetcode.com/problems/map-sum-pairs/
    public static void main(String[] args) {

    }


}

//2 min
//Runtime
//12 ms
//Beats
//57.76%
//Memory
//42.7 MB
//Beats
//22%
class MapSum {
    Map<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                sum += map.get(key);
            }
        }
        return sum;
    }
}
