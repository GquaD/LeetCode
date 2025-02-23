package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem2347 {
    //https://leetcode.com/problems/best-poker-hand
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/best-poker-hand/solutions/6459431/java-solution-by-tbekpro-kszi/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //45.31%
    //Analyze Complexity
    //Memory
    //41.15
    //MB
    //Beats
    //69.69%
    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> mapr = new HashMap<>();
        Map<Character, Integer> maps = new HashMap<>();
        for (int n : ranks)
            mapr.put(n, mapr.getOrDefault(n, 0) + 1);
        for (char c : suits)
            maps.put(c, maps.getOrDefault(c, 0) + 1);

        if (maps.size() == 1)
            return "Flush";
        int count = 0;
        for (int rank : mapr.keySet()) count = Math.max(count, mapr.get(rank));

        if (count >= 3)
            return "Three of a Kind";
        else if (count == 2)
            return "Pair";
        else
            return "High Card";
    }
}
