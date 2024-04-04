package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem159 {
    //https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/solutions/4972613/java-sliding-window-hashmap/
    //10-15min
    //Runtime
    //45
    //ms
    //Beats
    //42.27%
    //of users with Java
    //Memory
    //45.52
    //MB
    //Beats
    //12.55%
    //of users with Java
    static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, max = 0, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.size() == 2 && !map.containsKey(c)) {
                while (map.size() >= 2) {
                    char t = s.charAt(idx++);
                    int freq = map.get(t);
                    if (freq == 1) map.remove(t);
                    else map.put(t, freq - 1);
                    count--;
                }
            }
            count++;
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(count, max);
        }
        return max;
    }
}
