package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem3456 {
    //https://leetcode.com/problems/find-special-substring-of-length-k
    public static void main(String[] args) {

    }

    //15min
    //Runtime
    //3
    //ms
    //Beats
    //11.83%
    //Analyze Complexity
    //Memory
    //42.97
    //MB
    //Beats
    //15.20%
    public boolean hasSpecialSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        for (int i = k; i < s.length(); i++) {
            char prev = s.charAt(i - k);
            if (map.size() == 1) {
                if (!map.containsKey(s.charAt(i))) {
                    if (i - k - 1 < 0) return true;
                    if (i - k - 1 >= 0 && !map.containsKey(s.charAt(i - k - 1))) return true;
                }
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            int freq = map.get(prev);
            if (freq == 1) map.remove(prev);
            else map.put(prev, freq - 1);
        }
        if (s.length() > k && map.size() == 1 && !map.containsKey(s.charAt(s.length() - k - 1))) {
            return true;
        }
        return s.length() == k ? map.size() == 1 : false;
    }
}
