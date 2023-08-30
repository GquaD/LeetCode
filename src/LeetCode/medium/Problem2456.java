package LeetCode.medium;

import java.util.*;

public class Problem2456 {
    //https://leetcode.com/problems/most-popular-video-creator/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/most-popular-video-creator/solutions/3980736/java-o-n-using-3-hashmaps/
    //20-25 min
    //Runtime
    //52 ms
    //Beats
    //66.20%
    //Memory
    //98.3 MB
    //Beats
    //50.70%
    static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> map = new HashMap<>();
        Map<String, String> mapIds = new HashMap<>();
        Map<String, Long> mapSum = new HashMap<>();
        for (int i = 0; i < views.length; i++) {
            long v = map.getOrDefault(creators[i], -1L);
            if (views[i] > v) {
                mapIds.put(creators[i], ids[i]);
            } else if (views[i] == v) {
                String s = mapIds.get(creators[i]);
                if (s != null && ids[i].compareTo(s) < 0) mapIds.put(creators[i], ids[i]);
            }
            map.put(creators[i], Math.max(v, views[i]));
            mapSum.put(creators[i], mapSum.getOrDefault(creators[i], 0L) + views[i]);
        }
        long max = 0;
        for (String key : mapSum.keySet()) max = Math.max(max, mapSum.get(key));
        List<List<String>> list = new ArrayList<>();
        for (String key : mapSum.keySet()) if (mapSum.get(key) == max) list.add(Arrays.asList(key, mapIds.get(key)));
        return list;
    }
}
