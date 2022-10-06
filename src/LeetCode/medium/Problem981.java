package LeetCode.medium;

import java.util.*;

public class Problem981 {
    //https://leetcode.com/problems/time-based-key-value-store/

    public static void main(String[] args) {
        TimeMap map = new TimeMap();
        map.set("foo", "bar", 1);
        System.out.println(map.get("foo", 1));
        System.out.println(map.get("foo", 3));
        map.set("foo", "bar2", 4);
        System.out.println(map.get("foo", 4));
        System.out.println(map.get("foo", 5));


        TimeMap map1 = new TimeMap();
        map1.set("love", "high", 10);
        map1.set("love", "low", 20);
        System.out.println(map1.get("love", 5));
        System.out.println(map1.get("love", 10));
        System.out.println(map1.get("love", 15));
        System.out.println(map1.get("love", 20));
        System.out.println(map1.get("love", 25));
    }

    //https://leetcode.com/problems/time-based-key-value-store/solutions/2667238/java-solution-using-treemap/
    //20-25 mins
    //Runtime
    //307 ms
    //Beats
    //63.37%
    //Memory
    //218.1 MB
    //Beats
    //50.68%
    static class TimeMap {
        Map<String, Map<Integer, String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                Map<Integer, String> m = map.get(key);
                m.put(timestamp, value);
            } else {
                Map<Integer, String> m = new TreeMap<>();
                m.put(timestamp, value);
                map.put(key, m);
            }
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                TreeMap<Integer, String> m = (TreeMap<Integer, String>) map.get(key);
                if (m.containsKey(timestamp)) {
                    return m.get(timestamp);
                } else {
                    Integer time = m.lowerKey(timestamp);
                    if (time == null) return "";
                    String val = m.get(time);
                    return val == null ? "" : val;
                }
            } else return "";
        }
    }
}
