package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3137 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic/solutions/6108399/java-o-n-hashmap-solution/
    //5min
    //Runtime
    //32
    //ms
    //Beats
    //83.10%
    //Analyze Complexity
    //Memory
    //45.94
    //MB
    //Beats
    //18.81%
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= word.length() - k; i += k) {
            String s = word.substring(i, i + k);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int max = 0;
        for (String sub: map.keySet()) {
            max = Math.max(max, map.get(sub));
        }
        int subNumber = word.length() / k;
        return subNumber - max;
    }
}
