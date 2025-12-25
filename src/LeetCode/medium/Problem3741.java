package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3741 {
    //10min

    //Runtime
    //109
    //ms
    //Beats
    //58.68%
    //Analyze Complexity
    //Memory
    //272.96
    //MB
    //Beats
    //68.68%

    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> list = map.get(n);

            if (list == null) {
                list = new ArrayList<>();
                map.put(n, list);
            }

            list.add(i);
        }

        int min = Integer.MAX_VALUE;

        for (int key: map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() < 3) continue;

            for (int i = 0; i < list.size() - 2; i++) {
                int a = list.get(i), b = list.get(i + 1), c = list.get(i + 2);
                int dist = Math.abs(a - b) + Math.abs(a - c) + Math.abs(b - c);
                min = Math.min(dist, min);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
