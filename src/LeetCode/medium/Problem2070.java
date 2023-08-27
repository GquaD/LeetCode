package LeetCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem2070 {
    //https://leetcode.com/problems/most-beautiful-item-for-each-query/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximumBeauty(new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}}, new int[]{1,2,3,4,5,6})));
    }


    //https://leetcode.com/problems/most-beautiful-item-for-each-query/solutions/3968907/java-using-treemap/
    //30-40 min
    //Runtime
    //98 ms
    //Beats
    //16.98%
    //Memory
    //100.3 MB
    //Beats
    //5.66%
    static int[] maximumBeauty(int[][] items, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) map.put(items[i][0], Math.max(map.getOrDefault(items[i][0], 0), items[i][1]));
        TreeMap<Integer, Integer> mapSorted = new TreeMap<>();
        for (int key : map.keySet()) mapSorted.put(key, map.get(key));
        int prev = 0, c = 0;
        int[] arr = new int[mapSorted.size()], res = new int[queries.length];
        for (int key : mapSorted.keySet()) {
            mapSorted.put(key, Math.max(mapSorted.get(key), prev));
            prev = mapSorted.get(key);
            arr[c++] = key;
        }
        for (int i = 0; i < queries.length; i++) {
            Integer val = mapSorted.get(queries[i]);
            if (val == null) {
                Integer higherKey = mapSorted.lowerKey(queries[i]);
                val = higherKey == null ? 0 : mapSorted.get(higherKey);
            }
            res[i] = val;
        }
        return res;
    }

    //Time Limit Exceeded
    //33 / 35
    static int[] maximumBeauty1(int[][] items, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) map.put(items[i][0], Math.max(map.getOrDefault(items[i][0], 0), items[i][1]));
        TreeMap<Integer, Integer> mapSorted = new TreeMap<>();
        for (int key : map.keySet()) mapSorted.put(key, map.get(key));
        int prev = 0;
        for (int key : mapSorted.keySet()) {
            mapSorted.put(key, Math.max(mapSorted.get(key), prev));
            prev = mapSorted.get(key);
        }
        for (int i = 0; i < queries.length; i++) {
            Integer val = mapSorted.get(queries[i]);
            if (val == null)
                for (int key : mapSorted.keySet())
                    if (key <= queries[i]) val = mapSorted.get(key);
            queries[i] = val == null ? 0 : val;
        }
        return queries;
    }
}
