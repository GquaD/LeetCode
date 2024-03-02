package LeetCode.medium;

import java.util.*;

public class Problem362 {
    //https://leetcode.com/problems/design-hit-counter/description/
    public static void main(String[] args) {

    }


}


//https://leetcode.com/problems/design-hit-counter/solutions/4811066/java-from-3ms-to-1ms-hashmap-vs-treemap/
//5min
//Runtime
//1
//ms
//Beats
//61.31%
//of users with Java
//Memory
//41.54
//MB
//Beats
//38.37%
//of users with Java
class HitCounter2 {

    TreeMap<Integer, Integer> map;
    public HitCounter2() {
        map = new TreeMap<>();
    }

    public void hit(int t) {
        map.put(t, map.getOrDefault(t, 0) + 1);
    }

    public int getHits(int t) {
        int i = t - 300, res = 0;

        Map.Entry<Integer, Integer> entry = map.higherEntry(i);
        while (entry != null && entry.getKey() <= t) {
            res += entry.getValue();
            entry = map.higherEntry(entry.getKey());
        }
        return res;
    }
}

//
//5min
//Runtime
//3
//ms
//Beats
//10.65%
//of users with Java
//Memory
//42.39
//MB
//Beats
//7.69%
//of users with Java
class HitCounter1 {

    Map<Integer, Integer> map;
    public HitCounter1() {
        map = new HashMap<>();
    }

    public void hit(int t) {
        map.put(t, map.getOrDefault(t, 0) + 1);
    }

    public int getHits(int t) {
        int i = t - 299, res = 0;
        for (; i <= t; i++) {
            Integer freq = map.get(i);
            if (freq != null) res += freq;
        }
        return res;
    }
}
