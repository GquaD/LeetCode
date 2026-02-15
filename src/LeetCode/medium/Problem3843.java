package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3843 {
    //10min

    //Runtime
    //124
    //ms
    //Beats
    //26.36%
    //Analyze Complexity
    //Memory
    //222.61
    //MB
    //Beats
    //22.40%
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int n: nums) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        for (int n: map1.keySet()) {
            int freq = map1.get(n);
            map2.put(freq, map2.getOrDefault(freq, 0) + 1);
        }

        for (int n: nums) {
            if (map2.get(map1.get(n)) == 1) {
                return n;
            }
        }
        return -1;
    }
}
