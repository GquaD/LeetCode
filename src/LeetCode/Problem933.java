package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem933 {
    //https://leetcode.com/problems/number-of-recent-calls/
    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));
    }


    //Runtime: 32 ms, faster than 66.77% of Java online submissions for Number of Recent Calls.
    //Memory Usage: 70.7 MB, less than 51.08% of Java online submissions for Number of Recent Calls.
    static class RecentCounter {
        Deque<Integer> list;

        public RecentCounter() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            while (!list.isEmpty() && t - list.getFirst() > 3000) {
                list.removeFirst();
            }
            list.addLast(t);
            return list.size();
        }
    }


    //time limit exceeded
    /*static class RecentCounter {
        Map<Integer, Integer> map;
        Map<Integer, Integer> mapWithResults;
        public RecentCounter() {
            map = new HashMap<>();
            mapWithResults = new HashMap<>();
        }

        public int ping(int t) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }


            if (mapWithResults.containsKey(t)) {
                mapWithResults.put(t, mapWithResults.get(t) + 1);
            } else {
                int res = 0;

                for (Integer time : map.keySet()) {
                    if (time >= t - 3000 && time <= t) {
                        res += map.get(time);
                    }
                }
                mapWithResults.put(t, res);
            }

            return mapWithResults.get(t);
        }
    }*/

    //time limit exceeded
    /*class RecentCounter {
    Map<Integer, Integer> map;
    public RecentCounter() {
        map = new TreeMap<>();
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
}*/
}
