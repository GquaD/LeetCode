package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem1128 {
    //https://leetcode.com/problems/number-of-equivalent-domino-pairs
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-equivalent-domino-pairs/solutions/6769448/java-smart-solution-by-tbekpro-22mz/
    //10min
    //Runtime
    //24
    //ms
    //Beats
    //22.84%
    //Analyze Complexity
    //Memory
    //56.70
    //MB
    //Beats
    //9.71%
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] arr: dominoes) {
            String a = Math.min(arr[0], arr[1]) + "_" + Math.max(arr[0], arr[1]);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int res = 0;
        for (String key: map.keySet()) {
            int freq = map.get(key);
            if (freq > 1) res += freq * (freq - 1) / 2;
        }
        return res;
    }
}
