package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3365 {
    //https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/solutions/6081859/java-hashmap-100-faster-solution/
    //5-10min
    //Runtime
    //71
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //55.29
    //MB
    //Beats
    //100.00%
    static boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> maps = new HashMap<>(), mapt = new HashMap<>();
        int size = s.length() / k;
        for (int i = 0; i < s.length(); i += size) {
            String ss = s.substring(i, i + size);
            maps.put(ss, maps.getOrDefault(ss, 0) + 1);
            ss = t.substring(i, i + size);
            mapt.put(ss, mapt.getOrDefault(ss, 0) + 1);
        }
        if (maps.size() != mapt.size()) return false;
        for (String ss: maps.keySet()) {
            Integer freqs = maps.get(ss), freqt = mapt.get(ss);
            if (freqs == null || freqt == null) return false;
            if (freqs.intValue() != freqt.intValue()) return false;
        }
        return true;
    }
}
