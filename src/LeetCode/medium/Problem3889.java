package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3889 {
    //10min

    //Runtime
    //189
    //ms
    //Beats
    //-%
    //Memory
    //64.97
    //MB
    //Beats
    //-%
    //
    public int mirrorFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < 13; i++) {
            char a = (char) ('a' + i), b = (char) (25 - i + 'a');
            Integer c = map.get(a), d = map.get(b);
            if (c == null) c = 0;
            if (d == null) d = 0;
            result += Math.abs(c - d);
        }

        for (int i = 0; i < 5; i++) {
            char a = (char) ('0' + i), b = (char) (9 - i + '0');
            Integer c = map.get(a), d = map.get(b);
            if (c == null) c = 0;
            if (d == null) d = 0;
            result += Math.abs(c - d);
        }

        return result;
    }
}
