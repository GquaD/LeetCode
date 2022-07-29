package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem933 {
    //https://leetcode.com/problems/number-of-recent-calls/
    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));
    }


    //time limit exceeded
    static class RecentCounter {
        Map<Integer, Integer> map;
        public RecentCounter() {
            map = new HashMap<>();
        }

        public int ping(int t) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
            int res = 0;
            for (Integer time : map.keySet()) {
                if (time >= t - 3000 && time <= t) {
                    res += map.get(time);
                }
            }
            return res;
        }
    }
}
