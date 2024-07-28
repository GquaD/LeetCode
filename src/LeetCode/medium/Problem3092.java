package LeetCode.medium;

import java.util.*;

public class Problem3092 {
    //https://leetcode.com/problems/most-frequent-ids/solutions/5548977/java-hashmap-treemap-solution/
    //25min
    //Runtime
    //201
    //ms
    //Beats
    //18.78%
    //Analyze Complexity
    //Memory
    //85.96
    //MB
    //Beats
    //5.08%
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Solver s = new Solver();
        long[] arr = new long[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.add(nums[i], freq[i]);
        }
        return arr;
    }
}

class Solver {
    //id -> freq
    Map<Integer, Long> map;
    //freq -> list of ids
    TreeMap<Long, Set<Integer>> mapf;

    public Solver() {
        map = new HashMap<>();
        mapf = new TreeMap<>((a, b) -> (b - a == 0 ? 0 : b - a > 0 ? 1 : -1));
    }

    public long add(int id, long f) {
        if (map.containsKey(id)) {
            long oldfreq = map.get(id), freqNew = oldfreq + f;
            map.put(id, freqNew);

            Set<Integer> set = mapf.get(oldfreq);
            if (set != null && set.size() > 0) {
                set.remove(id);
            }
            if (set.size() == 0) {
                mapf.remove(oldfreq);
            }
            set = null;
            set = mapf.get(freqNew);
            if (set == null) {
                set = new HashSet<>();
                mapf.put(freqNew, set);
            }
            set.add(id);
        } else {
            map.put(id, f);
            Set<Integer> set = mapf.get(f);
            if (set == null) {
                set = new HashSet<>();
                mapf.put(f, set);
            }
            set.add(id);
        }
        Long key = mapf.firstKey();
        return key == null ? 0 : key;
    }
}
