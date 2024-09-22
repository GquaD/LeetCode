package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3295 {
    //https://leetcode.com/problems/report-spam-message
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/report-spam-message/solutions/5819875/java-2-solutions-optimized-from-95ms-to-50ms/
    //5min
    //Runtime
    //50
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //73.74
    //MB
    //Beats
    //100.00%
    boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        for (String s: bannedWords) {
            set.add(s);
        }
        int count = 0;
        for (String s: message) {
            if (set.contains(s)) {
                count++;
                if (count >= 2) return true;
            }
        }
        return false;
    }


    //
    //10min
    //Runtime
    //95
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //91.82
    //MB
    //Beats
    //100.00%
    static boolean reportSpam1(String[] message, String[] bannedWords) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: message) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Set<String> set = new HashSet<>();
        for (String s: bannedWords) {
            set.add(s);
        }
        int count = 0;
        for (String ban: set) {
            Integer freq = map.get(ban);
            if (freq != null) {
                count += freq;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
