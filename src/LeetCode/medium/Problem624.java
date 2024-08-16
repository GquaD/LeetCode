package LeetCode.medium;

import java.util.List;

public class Problem624 {
    //https://leetcode.com/problems/maximum-distance-in-arrays/

    //https://leetcode.com/problems/maximum-distance-in-arrays/solutions/5645282/java-o-n-prefix-max-min-solution/
    //15min
    //Runtime
    //7
    //ms
    //Beats
    //82.70%
    //Analyze Complexity
    //Memory
    //64.62
    //MB
    //Beats
    //37.97%
    int maxDistance(List<List<Integer>> arrays) {
        int max = -100_000, min = 100_000, dist = max;
        List<Integer> l = arrays.get(0);
        max = Math.max(max, l.get(l.size() - 1));
        min = Math.min(min, l.get(0));
        for (int i = 1; i < arrays.size(); i++) {
            l = arrays.get(i);
            int a = l.get(0), b = l.get(l.size() - 1);
            int d = Math.max(Math.max(Math.abs(max - b), Math.abs(min - a)), Math.max(Math.abs(max - a), Math.abs(min - b)));
            dist = Math.max(d, dist);
            max = Math.max(max, b);
            min = Math.min(min, a);
        }
        return dist;
    }
}
