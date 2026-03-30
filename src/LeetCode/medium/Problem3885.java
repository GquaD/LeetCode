package LeetCode.medium;

import java.util.*;

public class Problem3885 {
    //20min

     //Runtime
    //390
    //ms
    //Beats
    //-%
    //Memory
    //245.10
    //MB
    //Beats
    //-%
    //https://leetcode.com/problems/design-event-manager/solutions/7721844/java-solution-by-tbekpro-u18y/
}

class EventManager {
    private TreeMap<Integer, TreeSet<Integer>> map;
    private Map<Integer, Integer> conn;

    public EventManager(int[][] events) {
        conn = new HashMap<>();
        map = new TreeMap<>(Collections.reverseOrder());
        for (int[] e: events) {
            int id = e[0], p = e[1];
            conn.put(id, p);
            TreeSet<Integer> set = map.get(p);
            if (set == null) {
                set = new TreeSet<>();
                map.put(p, set);
            }
            set.add(id);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        int pOld = conn.get(eventId);
        conn.put(eventId, newPriority);
        TreeSet<Integer> set = map.get(pOld);
        set.remove(eventId);
        if (set.size() == 0) map.remove(pOld);

        set = map.get(newPriority);
        if (set == null) {
            set = new TreeSet<>();
            map.put(newPriority, set);
        }
        set.add(eventId);
    }

    public int pollHighest() {
        if (map.size() == 0) return -1;
        Integer p = map.firstKey();

        TreeSet<Integer> set = map.get(p);
        int result = set.pollFirst();
        if (set.size() == 0) map.remove(p);

        conn.remove(result);
        return result;
    }
}
