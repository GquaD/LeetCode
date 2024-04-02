package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem340 {
    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/solutions/4962566/java-sliding-window-hashmap/
    //15min
    //Runtime
    //7
    //ms
    //Beats
    //82.70%
    //of users with Java
    //Memory
    //44.40
    //MB
    //Beats
    //61.56%
    //of users with Java
    static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        int a = 0, count = 0, len = s.length(), max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                while (map.size() >= k) {
                    char t = s.charAt(a++);
                    int freq = map.get(t);
                    if (freq == 1) {
                        map.remove(t);
                    } else {
                        map.put(t, freq - 1);
                    }
                    count--;
                }
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            count++;
            max = Math.max(count, max);
        }
        return max;
    }
}
